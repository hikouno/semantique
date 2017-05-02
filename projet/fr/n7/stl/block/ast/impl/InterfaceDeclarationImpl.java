/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.InterfaceDeclaration;
import fr.n7.stl.block.ast.Interface;

/**
 * Implementation of the Abstract Syntax Tree node for a interface declaration instruction.
 *
 */
public class InterfaceDeclarationImpl implements InterfaceDeclaration {

	protected Interface interf;
	
	/**
	 * Creates a class declaration instruction node for the Abstract Syntax Tree.
	 * @param _classe The declared class.
	 */
	public InterfaceDeclarationImpl(Interface _interf) {
		this.interf = _interf;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InterfaceDeclaration : " + this.interf;
	}

	/* (non-Javadoc)
	 */
	@Override
	public Interface getInterface() {
		return this.interf;
	}

	/* (non-Javadoc)
	 * @see fr.n7.block.ast.VariableDeclaration#getName()
	 */
	@Override
	public String getName() {
		return this.interf.getNom();
	}

}
