/**
 * 
 */
package fr.n7.stl.block.ast.impl;


import fr.n7.stl.block.ast.ConstantDeclaration;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.block.ast.Interface;


/**
 * Implementation of the Abstract Syntax Tree node for a constant declaration instruction.
 * @author Francois Alexis
 *
 */
 
 
public class ConstantDeclarationImpl implements ConstantDeclaration {
	
	private String name;
	protected Type type;
	protected Expression value;
	protected Interface interf;
	
	public ConstantDeclarationImpl(String _name, Type _type, Expression _value,
			Interface _interf) {
		this.name = _name;
		this.type = _type;
		this.value = _value;
		this.interf = _interf;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "const " + this.type + " " + this.name + " = " + this.value + ";\n";
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Declaration#getName()
	 */
	@Override
	public String getName() {
		return this.interf.getNom() + "." + this.name;
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.ConstantDeclaration#getValue()
	 */
	@Override
	public Expression getValue() {
		return this.value;
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.ConstantDeclaration#getInterface()
	 */
	@Override
	public Interface getInterface() {
		return this.interf;
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
		return value.getType().equalsTo(type);
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
		return _factory.createFragment(); //Sera remplacé directement dans le code.
	}
	
	
	
	
	
}
