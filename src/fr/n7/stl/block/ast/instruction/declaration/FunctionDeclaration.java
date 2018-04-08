/**
 * 
 */
package fr.n7.stl.block.ast.instruction.declaration;

import java.util.Iterator;
import java.util.List;

import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.instruction.Instruction;
import fr.n7.stl.block.ast.scope.Declaration;
import fr.n7.stl.block.ast.scope.HierarchicalScope;
import fr.n7.stl.block.ast.scope.SymbolTable;
import fr.n7.stl.block.ast.type.AtomicType;
import fr.n7.stl.block.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.tam.ast.TAMInstruction;

/**
 * Abstract Syntax Tree node for a function declaration.
 * @author Marc Pantel
 */
public class FunctionDeclaration implements Instruction, Declaration {

	/**
	 * Name of the function
	 */
	protected String name;
	
	/**
	 * AST node for the returned type of the function
	 */
	protected Type type;
	
	/**
	 * List of AST nodes for the formal parameters of the function
	 */
	protected List<ParameterDeclaration> parameters;
	
	/**
	 * AST node for the body of the function
	 */
	protected Block body;

	/** Offset of the function */
    private int offset;
    private Register register;

    /**
	 * Builds an AST node for a function declaration
	 * @param _name : Name of the function
	 * @param _type : AST node for the returned type of the function
	 * @param _parameters : List of AST nodes for the formal parameters of the function
	 * @param _body : AST node for the body of the function
	 */
	public FunctionDeclaration(String _name, Type _type, List<ParameterDeclaration> _parameters, Block _body) {
		this.name = _name;
		this.type = _type;
		this.parameters = _parameters;
		this.body = _body;
	}

	public List<ParameterDeclaration> getParameters() {
		return parameters;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String _result = this.type + " " + this.name + " (";
		Iterator<ParameterDeclaration> _iter = this.parameters.iterator();
		if (_iter.hasNext()) {
			_result += _iter.next();
			while (_iter.hasNext()) {
				_result += ", " + _iter.next();
			}
		}
		return _result + ") " + this.body;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Declaration#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Declaration#getType()
	 */
	@Override
	public Type getType() {
		return this.type;
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.instruction.Instruction#resolve(fr.n7.stl.block.ast.scope.Scope)
	 */
	@Override
	public boolean resolve(HierarchicalScope<Declaration> _scope) {
		if (! _scope.accepts(this)) return false;
		if (! type.resolve(_scope)) return false;
		// pour les appels récursifs on doit l'enregistrer dans le scope parent avant de créer l'enfant
        _scope.register(this);

		HierarchicalScope<Declaration> funScope = new SymbolTable(_scope);
		for (ParameterDeclaration parameterDeclaration: parameters)
		    funScope.register(parameterDeclaration);

        return body.resolve(funScope);
    }

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.instruction.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
	    for (ParameterDeclaration parameterDeclaration: parameters) {
	        if (parameterDeclaration.getType().equalsTo(AtomicType.ErrorType))
	            return false;
        }
        if (! body.checkType())
            return false;

		//if (! body.getReturnType().equalsTo(type))
		//    return false;

	    return true;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.instruction.Instruction#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register register, int offset) {
	    this.register = register;
	    this.offset = offset;

	    int length = 0;
        for (ParameterDeclaration parameterDeclaration: parameters)
            length += parameterDeclaration.type.length();
        body.allocateMemory(register, offset);

	    return length;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.instruction.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 * @TODO Handle the case of 'void' return
	 * @TODO Handle parameters
	 */
	@Override
	public Fragment getCode(TAMFactory factory) {
	    String id = String.valueOf(factory.createLabelNumber());
        String startLabel = "fun_start_" + id ;
        String endLabel = "fun_end_" + id ;

	    Fragment fragment1 = factory.createFragment();
        fragment1.add(factory.createJump(endLabel));

        Fragment fragment2 = factory.createFragment();
        fragment2.append(body.getCode(factory));
        fragment2.addPrefix(startLabel + ":");
        fragment2.addSuffix(endLabel + ":");

        fragment1.append(fragment2);

        return fragment1;
	}

    @Override
    public Type getReturnType() {
        return AtomicType.VoidType;
    }

    public int getOffset() {
        return offset;
    }

    public Register getRegister() {
        return register;
    }
}
