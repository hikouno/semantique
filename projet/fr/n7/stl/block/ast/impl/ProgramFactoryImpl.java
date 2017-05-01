/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;
import java.util.Optional;

import fr.n7.stl.block.ast.ProgramFactory;
import fr.n7.stl.block.ast.Program;
import fr.n7.stl.block.ast.ClassePrincipale;
import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.MembreClasse.DroitAcces;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.Block;

/**
 * Factory to create nodes for programs, structural elements.
 *
 */
public class ProgramFactoryImpl implements ProgramFactory {

	/**
	 * Create an Abstract Syntax Tree node for the Program type.
	 * @param princ La classe principale.
	 * @return Abstract Syntax Tree node for the Program type.
	 */
	public Program createProgram(ClassePrincipale princ, LinkedList<Classe> classes) {
	    return new ProgramImpl(princ, classes);
	}
	
	/**
	 * Create an Abstract Syntax Tree node for the ClassePrincipale type.
	 * @param nom La nom de la classe.
	 * @param bloc Le bloc de la méthode principale.
	 * @return Abstract Syntax Tree node for the ClassePrincipale type.
	 */
	public ClassePrincipale createPrincipale(String nom, Block bloc) {
	    return new ClassePrincipaleImpl(nom, bloc);
	}
	
	/**
	 * Create an Abstract Syntax Tree node for the Classe type.
	 * @return Abstract Syntax Tree node for the Classe type.
	 */
	public Classe createClasse(String name) {
	    return new ClasseImpl(name);
	}
	
	/**
	 * Create an Abstract Syntax Tree node for the Constructeur type.
	 * @return Abstract Syntax Tree node for the Constructeur type.
	 */
	public Constructeur createConstructeur(Classe classe, DroitAcces auth, LinkedList<Argument> args, Block corps) {
	    return new Constructeur(classe, auth, args, corps);
	}
	
	/**
	 * Create an Abstract Syntax Tree node for the Attribut type.
	 * @return Abstract Syntax Tree node for the Attribut type.
	 */
	public AttributImpl createAttribut(Type type, String name, DroitAcces auth, boolean statique) {
	    return new AttributImpl(type, name, auth, statique);
	}
	
	/**
	 * Create an Abstract Syntax Tree node for the Method type.
	 * @return Abstract Syntax Tree node for the Method type.
	 */
	public MethodImpl createMethode(String name, LinkedList<Argument> args, Block body, DroitAcces auth, boolean statique, Optional<Type> retour) {
	    return new MethodImpl(name, args, body, auth, statique, retour);
	}
	
	/**
	 * Create an Abstract Syntax Tree node for the method Argument type.
	 * @return Abstract Syntax Tree node for the method Argument type.
	 */
	public Argument createArgument(Type type, String name) {
	    return new Argument(type, name);
	}

}
