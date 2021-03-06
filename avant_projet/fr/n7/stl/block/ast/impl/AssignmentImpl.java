/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Assignable;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Instruction;
import fr.n7.stl.block.ast.VariableDeclaration;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for an array type.
 * @author Marc Pantel
 *
 */
public class AssignmentImpl implements Instruction {

	protected VariableDeclaration declaration;
	protected Expression value;
	protected Assignable assignable;

	/**
	 * Create an assignment instruction implementation from the assigned variable declaration
	 * and the assigned value.
	 * @param _declaration Assigned variable declaration.
	 * @param _value Assigned value.
	 */
	public AssignmentImpl(VariableDeclaration _declaration, Expression _value) {
		this.declaration = _declaration;
		this.value = _value;
	}

	/**
	 * Create an assignment instruction implementation from the assignable expression
	 * and the assigned value.
	 * @param _assignable Expression that can be assigned a value.
	 * @param _value Value assigned to the expression.
	 */
	public AssignmentImpl(Assignable _assignable, Expression _value) {
		this.assignable = _assignable;
		this.value = _value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ((this.declaration != null)
				?this.declaration.getName()
				:this.assignable) + " = " + this.value.toString() + ";\n";
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
		return (this.declaration != null) ? declaration.getType().equalsTo(value.getType()) :
											assignable.getType().equalsTo(value.getType());
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		return 0;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		if (this.declaration != null) {
			Fragment res = value.getCode(_factory);
			res.add(_factory.createStore(declaration.getRegister(), declaration.getOffset(), declaration.getType().length()));
			
			return res;
		} else {
			
			if (this.assignable instanceof VariableAssignmentImpl) {
				Fragment res = value.getCode(_factory);
				
				VariableDeclaration declaration = ((VariableAssignmentImpl) assignable).getDeclaration();
				
				res.add(_factory.createStore(declaration.getRegister(), declaration.getOffset(), declaration.getType().length()));
				return res;
				
			} else if (this.assignable instanceof FieldAssignmentImpl) {
				
				FieldAssignmentImpl fa = (FieldAssignmentImpl) assignable;
				
				Fragment res = value.getCode(_factory);
				res.add(_factory.createStore(fa.getRegister(), fa.getOffset(), fa.getLength()));
				return res;
			}
			
			throw new RuntimeException("Affectation non implémentée");
		}
	}

}
