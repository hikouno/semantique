/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;

import fr.n7.stl.block.ast.ProgramFactory;
import fr.n7.stl.block.ast.Program;
import fr.n7.stl.block.ast.ClassePrincipale;
import fr.n7.stl.block.ast.Classe;
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

}
