/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.MembreClasse.DroitAcces;

import java.util.LinkedList;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * A class method.
 *
 */
public class Constructeur {

	protected Classe classe; //La classe associée au constructeur.
	protected DroitAcces auth;
	
	protected LinkedList<Argument> args;
	protected Block corps;
	
	
	public Constructeur(Classe classe, DroitAcces auth, LinkedList<Argument> args, Block corps) {
		this.classe = classe;
		
		this.auth = auth;
		
		this.args = args;
		this.corps = corps;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		String text = (this.auth == DroitAcces.PRIVATE) ? "private " : ( (this.auth == DroitAcces.PUBLIC) ? "public " : "protected " );
		text += this.classe.getNom() + " (";
		
		for (int i = 0; i < args.size(); i++) {
			text += args.get(i).toString() + ((i != args.size() - 1) ? ", " : "");
		}
		
		text += ")\n" + this.corps;
		
		return text;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#checkType()
	 */

	public boolean checkType() {
		throw new RuntimeException("Constructeur checkType à implémenter");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */

	public int allocateMemory(Register _register, int _offset) {
		throw new RuntimeException("Constructeur allocateMemory à implémenter");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#generateCode(fr.n7.stl.tam.ast.TAMFactory)
	 */

	public Fragment getCode(TAMFactory _factory) {
		throw new RuntimeException("Constructeur getCode à implémenter");
	}

}
