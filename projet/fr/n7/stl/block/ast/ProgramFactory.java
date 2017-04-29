/**
 * 
 */
package fr.n7.stl.block.ast;

import java.util.LinkedList;

/**
 * Factory to create nodes for programs, structural elements.
 *
 */
public interface ProgramFactory {

	/**
	 * Create an Abstract Syntax Tree node for the Program type.
	 * @param princ La classe principale.
	 * @return Abstract Syntax Tree node for the Program type.
	 */
	public Program createProgram(ClassePrincipale princ, LinkedList<Classe> classes);
	
	/**
	 * Create an Abstract Syntax Tree node for the ClassePrincipale type.
	 * @param nom La nom de la classe.
	 * @param bloc Le bloc de la méthode principale.
	 * @return Abstract Syntax Tree node for the ClassePrincipale type.
	 */
	public ClassePrincipale createPrincipale(String nom, Block bloc);
	
	/**
	 * Create an Abstract Syntax Tree node for the Classe type.
	 * @return Abstract Syntax Tree node for the Classe type.
	 */
	public Classe createClasse(String name);

}
