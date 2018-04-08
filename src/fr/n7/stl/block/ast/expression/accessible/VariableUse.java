/**
 * 
 */
package fr.n7.stl.block.ast.expression.accessible;

import fr.n7.stl.block.ast.expression.AbstractUse;
import fr.n7.stl.block.ast.instruction.declaration.VariableDeclaration;
import fr.n7.stl.block.ast.scope.Declaration;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a variable use expression.
 * @author Marc Pantel
 */
public class VariableUse extends AbstractUse {
	
	protected VariableDeclaration declaration;
	
	/**
	 * Creates a variable use expression Abstract Syntax Tree node.
	 * @param declaration Name of the used variable.
	 */
	VariableUse(VariableDeclaration declaration) {
	    this.declaration = declaration;
	}

    @Override
    protected Declaration getDeclaration() {
        return declaration;
    }

    /* (non-Javadoc)
         * @see fr.n7.stl.block.ast.expression.AbstractUse#getCode(fr.n7.stl.tam.ast.TAMFactory)
         */
	public Fragment getCode(TAMFactory factory) {
		Fragment _result = factory.createFragment();
		_result.add(factory.createLoadL(declaration.getOffset()));
		return declaration.getCode(factory);
	}

}
