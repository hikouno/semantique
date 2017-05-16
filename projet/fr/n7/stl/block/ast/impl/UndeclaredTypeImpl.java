/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.Classe;

/**
 * Type d'instance de classe.
 */
public class UndeclaredTypeImpl implements Type {

	private String nom;

	public UndeclaredTypeImpl(String _nom) {
		this.nom = _nom;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#equalsTo(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean equalsTo(Type _other) {
		throw new SemanticsUndefinedException("Semantics equalsTo should not be implemented in UndeclaredTypeImpl.");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#compatibleWith(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean compatibleWith(Type _other) {
		throw new SemanticsUndefinedException("Semantics compatibleWith should not be implemented in UndeclaredTypeImpl.");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#merge(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public Type merge(Type _other) {
		throw new SemanticsUndefinedException("Semantics merge should not be implemented in UndeclaredTypeImpl.");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#length(int)
	 */
	@Override
	public int length() {
		throw new SemanticsUndefinedException("Semantics length should not be implemented in UndeclaredTypeImpl.");
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "???" + this.nom;
	}

}
