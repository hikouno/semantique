/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.Interface;

/**
 * Type d'instance de classe.
 */
public class InterfaceTypeImpl implements Type {

	private Interface interf;

	public InterfaceTypeImpl(Interface _interf) {
		this.interf = _interf;
	}
	
	public Interface getInterface() {
		return this.interf;
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#equalsTo(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean equalsTo(Type _other) {
		if (_other instanceof InterfaceTypeImpl) {
			return this.interf.equalsTo( ((InterfaceTypeImpl) _other).getInterface() );
		} else {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#compatibleWith(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean compatibleWith(Type _other) {
		if (_other instanceof InterfaceTypeImpl) {
			throw new SemanticsUndefinedException("Semantics compatibleWith is not implemented in InterfaceTypeImpl.");
		} else {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#merge(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public Type merge(Type _other) {
		if (_other instanceof InterfaceTypeImpl) {
			throw new SemanticsUndefinedException("Semantics merge is not implemented in InterfaceTypeImpl.");
		} else {
			return AtomicType.ErrorType;
		}
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#length(int)
	 */
	@Override
	public int length() {
		throw new SemanticsUndefinedException("Semantics length is not implemented in InterfaceTypeImpl.");
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.interf.getNom();
	}

}
