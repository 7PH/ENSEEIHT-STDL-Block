package fr.n7.stl.block.ast.expression;

import fr.n7.stl.block.ast.scope.Declaration;
import fr.n7.stl.block.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Common elements between identifier use.
 * @author Marc Pantel
 *
 */
public abstract class AbstractUse {
	
	protected Declaration declaration;
	
	/**
	 * Creates a variable use expression Abstract Syntax Tree node.
	 * @param _name Name of the used variable.
	 */
	public AbstractUse(Declaration _declaration) {
		this.declaration = _declaration;
	}
	
	/**
	 * Synthesized Semantics attribute to compute the type of an identifier expression.
	 * @return Synthesized Type of the expression.
	 */
	public Type getType() {
		return this.declaration.getType();
	}
	
	/**
	 * Synthesized Semantics attribute to generate the code of an identifier expression.
	 * @return Synthesized Type of the expression.
	 */
	public abstract Fragment getCode(TAMFactory _factory);

}