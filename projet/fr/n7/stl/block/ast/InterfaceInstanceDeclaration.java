/**
 * 
 */
package fr.n7.stl.block.ast;

import fr.n7.stl.tam.ast.Register;

/**
 *
 */
public interface InterfaceInstanceDeclaration extends VariableDeclaration {

	/**
	 * Provide the value associated to a name in a type declaration.
	 * @return Value from the declaration.
	 */
	//public InterfaceInstance getInstance();
	
	/**
	 * Synthesized semantics attribute for the type of the declared variable.
	 * @return Type of the declared variable.
	 */
	public Type getType();
	
	/**
	 * Synthesized semantics attribute for the register used to compute the address of the variable.
	 * @return Register used to compute the address where the declared variable will be stored.
	 */
	public Register getRegister();
	
	/**
	 * Synthesized semantics attribute for the offset used to compute the address of the variable.
	 * @return Offset used to compute the address where the declared variable will be stored.
	 */
	public int getOffset();

}