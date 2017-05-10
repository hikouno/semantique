/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a variable use expression.
 * @author Marc Pantel
 *
 */
public class UndeclaredVariableUseImpl implements Expression {

	protected String decName;
	
	/**
	 * Creates a variable use expression Abstract Syntax Tree node.
	 */
	public UndeclaredVariableUseImpl(String _decName) {
		this.decName = _decName;
	}
	
	public String getDecName() {
		return decName;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ("@???{" + this.decName + "}");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		throw new RuntimeException("getType pour UndeclarationVariableUseImpl");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new RuntimeException("getCode pour UndeclarationVariableUseImpl");
	}

}
