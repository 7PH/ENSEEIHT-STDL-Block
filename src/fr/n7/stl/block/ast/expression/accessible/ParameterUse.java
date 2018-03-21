package fr.n7.stl.block.ast.expression.accessible;

import fr.n7.stl.block.ast.expression.AbstractUse;
import fr.n7.stl.block.ast.expression.Expression;
import fr.n7.stl.block.ast.instruction.declaration.ParameterDeclaration;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

public class ParameterUse extends AbstractUse {

    public Expression value;

    /**
     * Creates a variable use expression Abstract Syntax Tree node.
     * @param _declaration Name of the used variable.
     */
    public ParameterUse(ParameterDeclaration _declaration, Expression value) {
        super(_declaration);

        this.value = value;
    }

    @Override
    public Fragment getCode(TAMFactory _factory) {
        throw new Error("not yet implemented");
    }
}
