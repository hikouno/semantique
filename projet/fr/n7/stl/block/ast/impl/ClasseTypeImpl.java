/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.List;

import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.ClasseDeclaration;
import fr.n7.stl.block.ast.InterfaceDeclaration;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.Type;

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
	
	/**
	 * Synthesized Semantics attribute to compute the type of an expression.
	 * @return Synthesized Type of the expression.
	 */
	public Type toDeclared(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes, Classe classeMere) throws ToDeclaredException {
		return this;
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
		int length = 0;
		for (AttributImpl _atts : this.classe.getAttributs()) {
			length += _atts.getType().length();
		}
		
		return length;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.classe.getNom();
	}

}
