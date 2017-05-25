/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.MembreClasse.DroitAcces;

import java.util.LinkedList;
import java.util.List;

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
	
	/**
	 * Teste si un jeu d'expressions fourni correspond à la signature
	 * du constructeur.
	 */
	public boolean match(List<Expression> args_fournis) {
		
		//1. Même nombre d'arguments
		if (args_fournis.size() != this.args.size())
			return false;
		
		//2. Arguments de même type.
		for (int i = 0; i < this.args.size(); i++) {
			if ( !this.args.get(i).getType().equalsTo(args_fournis.get(i).getType()) )
				return false;
		}
		
		return true;
	}
	
	/**
	 * Teste si la signature du constructeur correspond à celle du
	 * constructeur passé en argument (équivalence des types).
	 */
	public boolean match(Constructeur _constructeur) {
		
		LinkedList<Argument> args_fournis = _constructeur.getArguments();
		
		//1. Même nombre d'arguments
		if (args_fournis.size() != this.args.size())
			return false;
		
		//2. Arguments de même type.
		for (int i = 0; i < this.args.size(); i++) {
			if ( !this.args.get(i).getType().equalsTo(args_fournis.get(i).getType()) )
				return false;
		}
		
		return true;
	}
	
	public LinkedList<Argument> getArguments() {
		return this.args;
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
