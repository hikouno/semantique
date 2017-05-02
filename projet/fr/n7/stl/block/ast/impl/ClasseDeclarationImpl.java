/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.ClasseDeclaration;
import fr.n7.stl.block.ast.Classe;

/**
 * Implementation of the Abstract Syntax Tree node for a class declaration instruction.
 *
 */
public class ClasseDeclarationImpl implements ClasseDeclaration {

	protected Classe classe;
	
	/**
	 * Creates a class declaration instruction node for the Abstract Syntax Tree.
	 * @param _classe The declared class.
	 */
	public ClasseDeclarationImpl(Classe _classe) {
		this.classe = _classe;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClasseDeclaration : " + this.classe;
	}

	/* (non-Javadoc)
	 */
	@Override
	public Classe getClasse() {
		return this.classe;
	}

	/* (non-Javadoc)
	 * @see fr.n7.block.ast.VariableDeclaration#getName()
	 */
	@Override
	public String getName() {
		return this.classe.getNom();
	}

}
