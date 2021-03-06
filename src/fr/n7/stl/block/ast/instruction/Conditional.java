package fr.n7.stl.block.ast.instruction;

import java.util.Optional;

import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.expression.Expression;
import fr.n7.stl.block.ast.scope.Declaration;
import fr.n7.stl.block.ast.scope.HierarchicalScope;
import fr.n7.stl.block.ast.type.AtomicType;
import fr.n7.stl.block.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.tam.ast.impl.FragmentImpl;
import org.apache.commons.text.StrSubstitutor;

/**
 * Implementation of the Abstract Syntax Tree node for a conditional instruction.
 * @author Marc Pantel
 *
 */
public class Conditional implements Instruction {

	protected Expression condition;
	protected Block thenBranch;
	protected Optional<Block> elseBranch;

	public Conditional(Expression _condition, Block _then, Block _else) {
		this.condition = _condition;
		this.thenBranch = _then;
		this.elseBranch = Optional.of(_else);
	}

	public Conditional(Expression _condition, Block _then) {
		this.condition = _condition;
		this.thenBranch = _then;
		this.elseBranch = Optional.empty();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "if (" + this.condition + " )" + this.thenBranch + ((this.elseBranch.isPresent())?(" else " + this.elseBranch.get()):"");
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.instruction.Instruction#resolve(fr.n7.stl.block.ast.scope.Scope)
	 */
	@Override
	public boolean resolve(HierarchicalScope<Declaration> _scope) {
		return condition.resolve(_scope)
				&& thenBranch.resolve(_scope)
				&& (! elseBranch.isPresent() || elseBranch.get().resolve(_scope));
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
		boolean b = condition.getType() == AtomicType.BooleanType;
        if (!b)
        	throw new RuntimeException("Condition " + this.condition.getType().toString()
        									+ " is not boolean.");
		b &= thenBranch.checkType();
		if (!b) 
			throw new RuntimeException("Then Branch is not well typed.");
		b &= (!elseBranch.isPresent() || elseBranch.get().checkType());
		if (!b) 
			throw new RuntimeException("Else Branch is not well typed.");
		return b;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register register, int offset) {
	    thenBranch.allocateMemory(register, offset);
        elseBranch.ifPresent(block -> block.allocateMemory(register, offset));
        return 0;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory factory) {
		Fragment fragment = factory.createFragment();

        String endLabel = "endif_" + factory.createLabelNumber();
        String elseLabel = "else_" + factory.createLabelNumber();

		if (! elseBranch.isPresent()) {
            fragment.append(condition.getCode(factory));
            fragment.add(factory.createJumpIf(endLabel, 0));
            fragment.append(thenBranch.getCode(factory));
            fragment.addSuffix(endLabel + ":");
        } else {
		    fragment.append(condition.getCode(factory));
		    fragment.add(factory.createJumpIf(elseLabel, 0));
		    fragment.append(thenBranch.getCode(factory));
		    fragment.add(factory.createJump(endLabel));
		    fragment.addSuffix(elseLabel + ":");
		    fragment.append(elseBranch.get().getCode(factory));
		    fragment.addSuffix(endLabel + ":");
        }

        return fragment;
	}

	@Override
	public Type getReturnType() {
		Type type = thenBranch.getReturnType();
		if (elseBranch.isPresent()) {
		    type = type.merge(elseBranch.get().getReturnType());
		}

        return type;
	}

}
