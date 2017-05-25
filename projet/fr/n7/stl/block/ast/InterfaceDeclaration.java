/**
 * 
 */
package fr.n7.stl.block.ast;

import java.util.List;


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
	
	
	/**
	 * Return InterfaceDeclaration from what typeNom comes. (?)
	 */
	public static InterfaceDeclaration appartient(String typeNom, List<InterfaceDeclaration> interfaces) {
		for(InterfaceDeclaration interfDec : interfaces) {
			if(interfDec.getInterface().getNom().equals(typeNom)) {
				return interfDec;
			}
		}
		return null;
	}

}
