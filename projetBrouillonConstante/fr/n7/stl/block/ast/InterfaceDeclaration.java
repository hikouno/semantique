/**
 * 
 */
package fr.n7.stl.block.ast;

/**
 * AST node for the interface declaration instruction.
 *
 */
public interface InterfaceDeclaration extends Declaration {
	
	/**
	 * Provide the value associated to a name in a type declaration.
	 * @return Value from the declaration.
	 */
	public Interface getInterface();

}
