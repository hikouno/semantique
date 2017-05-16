/**
 * 
 */
package fr.n7.stl.block.ast;

import fr.n7.stl.tam.ast.Register;

/**
 *
 */
public interface UndeclaredInstanceDeclaration extends VariableDeclaration {

	/**
	 * Provide the value associated to a name in a type declaration.
	 * @return Value from the declaration.
	 */
	public String getUndeclaredTypeNom();

	public Expression getValue();
	

}
