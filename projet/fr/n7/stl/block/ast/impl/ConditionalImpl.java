/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.List;
import java.util.Optional;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Instruction;
import fr.n7.stl.block.ast.InterfaceDeclaration;
import fr.n7.stl.block.ast.ClasseDeclaration;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a conditional instruction.
 * @author Marc Pantel
 *
 */
public class ConditionalImpl implements Instruction {

	protected Expression condition;
	protected Block thenBranch;
	protected Optional<Block> elseBranch;

	public ConditionalImpl(Expression _condition, Block _then, Block _else) {
		this.condition = _condition;
		this.thenBranch = _then;
		this.elseBranch = Optional.of(_else);
	}

	public ConditionalImpl(Expression _condition, Block _then) {
		this.condition = _condition;
		this.thenBranch = _then;
		this.elseBranch = Optional.empty();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "if (" + this.condition + " )" + this.thenBranch + ((this.elseBranch.isPresent())?(" else " + this.elseBranch.get()):"");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
		if (!elseBranch.isPresent())
			return thenBranch.checkType();
		
		return (thenBranch.checkType() && elseBranch.get().checkType());
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#toDeclared()
	 */
	public Instruction toDeclared(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes) {
		return this;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		thenBranch.allocateMemory(_register, _offset);
		if (elseBranch.isPresent()) elseBranch.get().allocateMemory(_register, _offset);
		return 0;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		
		if (elseBranch.isPresent())
		{
			int id = _factory.createLabelNumber();
			
			Fragment _then = condition.getCode(_factory);
			_then.add(_factory.createJumpIf("else_if" + id, 0));
			_then.append(thenBranch.getCode(_factory));
			_then.add(_factory.createJump("end_if" + id));
			
			Fragment _else = _factory.createFragment();
			_else.append(elseBranch.get().getCode(_factory));
			_else.addPrefix("else_if"+id+":");

			_then.append(_else);
			_then.addSuffix("end_if"+id+":");
			
			return _then;
		}
		else
		{
			int id = _factory.createLabelNumber();
			
			Fragment res = condition.getCode(_factory);
			res.add(_factory.createJumpIf("end_if"+id, 0));
			res.append(thenBranch.getCode(_factory));
			res.addSuffix("end_if"+id+":");
			
			return res;
		}
	}

}
