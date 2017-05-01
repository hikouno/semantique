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
public class ClasseTypeImpl implements Type {

	private Classe classe;

	public ClasseTypeImpl(Classe _classe) {
		this.classe = _classe;
	}
	
	public Classe getClasse() {
		return this.classe;
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#equalsTo(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean equalsTo(Type _other) {
		if (_other instanceof ClasseTypeImpl) {
			return this.classe.equalsTo( ((ClasseTypeImpl) _other).getClasse() );
		} else {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#compatibleWith(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean compatibleWith(Type _other) {
		if (_other instanceof ClasseTypeImpl) {
			throw new SemanticsUndefinedException("Semantics compatibleWith is not implemented in ClasseTypeImpl.");
		} else {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#merge(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public Type merge(Type _other) {
		if (_other instanceof ClasseTypeImpl) {
			throw new SemanticsUndefinedException("Semantics merge is not implemented in ClasseTypeImpl.");
		} else {
			return AtomicType.ErrorType;
		}
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#length(int)
	 */
	@Override
	public int length() {
		throw new SemanticsUndefinedException("Semantics length is not implemented in ClasseTypeImpl.");
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.classe.getNom();
	}

}
