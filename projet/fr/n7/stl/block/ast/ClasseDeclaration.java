/**
 * 
 */
package fr.n7.stl.block.ast;

import java.util.List;

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
	
	/**
	 * Return ClasseDeclaration from what typeNom comes. (?)
	 */
	public static ClasseDeclaration appartient(String typeNom, List<ClasseDeclaration> classes) {
		for(ClasseDeclaration classeDec : classes) {
			if(classeDec.getClasse().getNom().equals(typeNom)) {
				return classeDec;
			}
		}
		return null;
	}

}
