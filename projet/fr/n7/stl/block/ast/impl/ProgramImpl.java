/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;

import fr.n7.stl.block.ast.Program;
import fr.n7.stl.block.ast.ClassePrincipale;
import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Un programme MiniJava.
 *
 */
public class ProgramImpl implements Program {

	/**
	 * Interfaces contained in the program.
	 */
	//protected List<Interfaces> interfaces;
	
	/**
	 * Classes contained in the program.
	 */
	protected LinkedList<Classe> classes;
	
	/**
	 * Classe principale.
	 */
	protected ClassePrincipale principale;
	
	/**
	 * Constructor for a MiniJava program.
	 */
	public ProgramImpl(ClassePrincipale principale, LinkedList<Classe> classes) {
		this.principale = principale;
		this.classes = classes;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String text = "";
		for (Classe classe : this.classes) {
			text += classe + "\n";
		}
		
		text += this.principale;
		return text;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#checkType()
	 */
	@Override
	public boolean checkType() {
		throw new RuntimeException("ProgramImpl checkType à implémenter");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		throw new RuntimeException("ProgramImpl allocateMemory à implémenter");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#generateCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new RuntimeException("ProgramImpl getCode à implémenter");
	}

}
