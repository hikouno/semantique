/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.List;
import java.util.LinkedList;
import java.util.Optional;

import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.ClasseDeclaration;
import fr.n7.stl.block.ast.InterfaceDeclaration;
import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.MembreClasse.DroitAcces;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * A class method.
 *
 */
public class Constructeur extends MethodImpl {
	
	public Constructeur(Classe classe, DroitAcces auth, LinkedList<Argument> args, Block corps) {
		super(classe, classe.getNom(), args, corps, auth, false, Optional.empty());
	}
	
	/**
	 * Teste si un jeu d'expressions fourni correspond à la signature
	 * du constructeur.
	 */
	@Override
	public boolean match(List<Expression> args_fournis) {
		
		//1. Même nombre d'arguments
		if (args_fournis.size() != super.args.size())
			return false;
		
		//2. Arguments de même type.
		for (int i = 0; i < super.args.size(); i++) {
			if ( !super.args.get(i).getType().equalsTo(args_fournis.get(i).getType()) )
				return false;
		}
		
		return true;
	}
	
	/**
	 * Teste si la signature du constructeur correspond à celle du
	 * constructeur passé en argument (équivalence des types).
	 */
	public boolean match_constr(Constructeur _constructeur) {
		
		LinkedList<Argument> args_fournis = _constructeur.getArguments();
		
		//1. Même nombre d'arguments
		if (args_fournis.size() != super.args.size())
			return false;
		
		//2. Arguments de même type.
		for (int i = 0; i < super.args.size(); i++) {
			if ( !super.args.get(i).getType().equalsTo(args_fournis.get(i).getType()) )
				return false;
		}
		
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		String text = (super.auth == DroitAcces.PRIVATE) ? "private " : ( (super.auth == DroitAcces.PUBLIC) ? "public " : "protected " );
		text += super.classe.getNom() + " (";
		
		for (int i = 0; i < args.size(); i++) {
			text += super.args.get(i).toString() + ((i != super.args.size() - 1) ? ", " : "");
		}
		
		text += ")\n" + super.corps;
		
		return text;
	}
	
	/**
	 * Synthesized Semantics attribute to compute the type of an expression.
	 * @return Synthesized Type of the expression.
	 */
	@Override
	public Constructeur toDeclared(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes, Classe classeMere) throws ToDeclaredException {
		Constructeur constr_declared;
		
		//DÉCLARATION DES ARGUMENTS
		LinkedList<Argument> nouv_arguments = Argument.toDeclared_list(interfaces, classes, classeMere,
						"Classe " + classeMere.getNom() + ", Constructeur : ", this.args);
		
		//DÉCLARATION DU CONSTRUCTEUR
		constr_declared = new Constructeur(classeMere, super.getDroitAcces(), nouv_arguments,
											corps.toDeclared(interfaces, classes, classeMere, this));
		constr_declared.returnCheck();
		
		return constr_declared;
	}
	
	/** Renvoie une exception si on trouve une mauvaise utilisation des return. */
	@Override
	public void returnCheck() throws ToDeclaredException {
		
		if (corps.returnPresent()) {
			throw new ToDeclaredException("Classe " + super.classe.getNom() + ", un return a été détecté dans un des constructeurs.");
		}
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#checkType()
	 */

	public boolean checkType() {
		return this.corps.checkType();
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
