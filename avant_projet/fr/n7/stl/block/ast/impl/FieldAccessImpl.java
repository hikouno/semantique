/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.Optional;

import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.FieldDeclaration;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.tam.ast.Register;

/**
 * Implementation of the Abstract Syntax Tree node for accessing a field in a record.
 * @author Marc Pantel
 *
 */
public class FieldAccessImpl implements Expression {

	protected Expression record;
	protected String name;
	protected FieldDeclaration field;

	/**
	 * Construction for the implementation of a record field access expression Abstract Syntax Tree node.
	 * @param _record Abstract Syntax Tree for the record part in a record field access expression.
	 * @param _name Name of the field in the record field access expression.
	 */
	public FieldAccessImpl(Expression _record, String _name) {
		this.record = _record;
		this.name = _name;
	}

	/**
	 * Construction for the implementation of a record field access expression Abstract Syntax Tree node.
	 * @param _record Abstract Syntax Tree for the record part in a record field access expression.
	 * @param _field Abstract Syntax Tree for the field declaration in a record field access expression.
	 */
	public FieldAccessImpl(Expression _record, FieldDeclaration _field) {
		this.record = _record;
		this.field = _field;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.record + "." + this.name;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		if (this.record.getType() instanceof RecordTypeImpl) {
			Optional<FieldDeclaration> element = ((RecordTypeImpl) this.record.getType()).get(this.name);
			
			if (element.isPresent())
				return element.get().getType();
			
		}
		
		return AtomicType.ErrorType;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		
		Fragment res = _factory.createFragment();
		
		if (record instanceof VariableUseImpl) {
			
			res.add(_factory.createLoad(this.getRegister(),
				this.getOffset(), this.getLength()));
		}
		
		return res;
	}
	
	public Register getRegister() {
		if (record instanceof VariableUseImpl) {
			return ((VariableUseImpl)record).getDeclaration().getRegister();
		}
		
		return null;
	}
	
	public int getOffset() {
		if (record instanceof VariableUseImpl) {
			int offset = ((VariableUseImpl) record).getDeclaration().getOffset();
			
			String name_a_comparer = (field != null) ? field.getName() : name;
			
			RecordTypeImpl rec_type = ((RecordTypeImpl) record.getType());
			
			for( FieldDeclaration fd : rec_type.getFields() ) {
				if (fd.getName().equals(name_a_comparer)) 
					break;
				else
					offset += fd.getType().length();
			}
			
			return offset;
		}
		
		return 0;
	}
	
	public int getLength() {
		if (record instanceof VariableUseImpl) {

			RecordTypeImpl rec_type = ((RecordTypeImpl) record.getType());
			if (rec_type.get(name).isPresent())
				return rec_type.get(name).get().getType().length();
		}
		
		return 0;
	}

}
