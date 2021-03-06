package fr.n7.stl.block.ast.expression.assignable;

import fr.n7.stl.block.ast.expression.AbstractField;
import fr.n7.stl.block.ast.type.ArrayType;
import fr.n7.stl.block.ast.type.declaration.FieldDeclaration;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Library;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Abstract Syntax Tree node for an expression whose computation assigns a field in a record.
 * @author Marc Pantel
 *
 */
public class FieldAssignment extends AbstractField implements AssignableExpression {

	/**
	 * Construction for the implementation of a record field assignment expression Abstract Syntax Tree node.
	 * @param record Abstract Syntax Tree for the record part in a record field assignment expression.
	 * @param name Name of the field in the record field assignment expression.
	 */
	public FieldAssignment(AssignableExpression record, String name) {
		super(record, name);
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.impl.FieldAccessImpl#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory factory) {
        int offset = ((VariableAssignment)record).declaration.getOffset();

        FieldDeclaration field = null;

        int lengthBefore = 0;
        for (FieldDeclaration fieldDeclaration: recordType.getFields()) {
            if (fieldDeclaration.getName().equals(name)) {
                field = fieldDeclaration;
                break;
            }
            lengthBefore += fieldDeclaration.getType().length();
        }

        Fragment fragment = factory.createFragment();
        fragment.add(factory.createLoadL(offset));
        fragment.add(factory.createLoadL(lengthBefore));
        fragment.add(Library.IAdd);
        fragment.add(factory.createStoreI(field.getType().length()));
        return fragment;
	}
	
}
