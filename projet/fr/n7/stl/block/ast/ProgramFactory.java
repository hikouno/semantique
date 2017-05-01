/**
 * 
 */
package fr.n7.stl.block.ast;

import java.util.LinkedList;
import java.util.Optional;

import fr.n7.stl.block.ast.impl.MethodImpl;
import fr.n7.stl.block.ast.impl.Argument;

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
	 * @param name The name of the class.
	 * @return Abstract Syntax Tree node for the Classe type.
	 */
	public Classe createClasse(String name);
	
	/**
	 * Create an Abstract Syntax Tree node for the Method type.
	 * @return Abstract Syntax Tree node for the Method type.
	 */
	public MethodImpl createMethode(String name, LinkedList<Argument> args, Block body, MembreClasse.DroitAcces auth, boolean statique, Optional<Type> retour);
	
	/**
	 * Create an Abstract Syntax Tree node for the method Argument type.
	 * @return Abstract Syntax Tree node for the method Argument type.
	 */
	public Argument createArgument(Type type, String name);

}
