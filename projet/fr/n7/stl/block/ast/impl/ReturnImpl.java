/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.List;

import fr.n7.stl.block.ast.Assignable;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Instruction;
import fr.n7.stl.block.ast.VariableDeclaration;
import fr.n7.stl.block.ast.InterfaceDeclaration;
import fr.n7.stl.block.ast.ClasseDeclaration;
import fr.n7.stl.block.ast.Classe;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for an array type.
 * @author Marc Pantel
 *
 */
public class ReturnImpl implements Instruction {

  	protected Expression value;

	/**
	 * Create an assignment instruction implementation from the assignable expression
	 * and the assigned value.
	 * @param _expr Value assigned to the expression.
	 */
	public ReturnImpl(Expression _expr) {
		this.value = _expr;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ("return " + this.value.toString() + ";\n");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#toDeclared()
	 */
	public Instruction toDeclared(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes, Classe classeMere) throws ToDeclaredException{
		return new ReturnImpl(this.value.toDeclared(interfaces, classes, classeMere));
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
		throw new RuntimeException("Non implémentée");
	}

}
