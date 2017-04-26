/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.AtomicType;

/**
 * Implementation of the Abstract Syntax Tree node for a pointer type.
 * @author Marc Pantel
 *
 */
public class PointerTypeImpl implements Type {

	private Type element;

	public PointerTypeImpl(Type _element) {
		this.element = _element;
	}
	
	public Type getPointedType() {
		return this.element;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#equalsTo(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean equalsTo(Type _other) {
		if (_other instanceof PointerTypeImpl) {
			
			PointerTypeImpl _otherPtr = (PointerTypeImpl) _other;
			return this.getPointedType().equalsTo(_otherPtr.getPointedType());
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#compatibleWith(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean compatibleWith(Type _other) {
		if (_other instanceof PointerTypeImpl) {
			
			PointerTypeImpl _otherPtr = (PointerTypeImpl) _other;
			return this.getPointedType().compatibleWith(_otherPtr.getPointedType());
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#merge(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public Type merge(Type _other) {
		if (_other instanceof PointerTypeImpl) {
			
			PointerTypeImpl _otherPtr = (PointerTypeImpl) _other;
			return new PointerTypeImpl( this.getPointedType().merge(_otherPtr.getPointedType()) );
		}
		
		return AtomicType.ErrorType;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#length(int)
	 */
	@Override
	public int length() {
		return 1;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(" + this.element + " *)";
	}
}
