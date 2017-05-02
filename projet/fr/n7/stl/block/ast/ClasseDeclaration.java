/**
 * 
 */
package fr.n7.stl.block.ast;

/**
 * AST node for the class declaration instruction.
 *
 */
public interface ClasseDeclaration extends Declaration {
	
	/**
	 * Provide the value associated to a name in a type declaration.
	 * @return Value from the declaration.
	 */
	public Classe getClasse();

}
