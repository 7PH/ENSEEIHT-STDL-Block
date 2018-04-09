package fr.n7.stl.block.ast;

import fr.n7.stl.block.ast.instruction.Instruction;
import fr.n7.stl.block.ast.type.AtomicType;

import java.util.List;

public class RootBlock extends Block {
    /**
     * Constructor for the root block.
     * @param _instructions
     */
    public RootBlock(List<Instruction> _instructions) {
        super(_instructions);
    }

    @Override
    public boolean checkType() {
        return super.checkType() && getReturnType() == AtomicType.VoidType;
    }
}
