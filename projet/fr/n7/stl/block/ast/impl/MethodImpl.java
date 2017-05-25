/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.List;

import fr.n7.stl.block.ast.MembreClasse;
import fr.n7.stl.block.ast.MembreClasse.DroitAcces;
import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.ClasseDeclaration;
import fr.n7.stl.block.ast.InterfaceDeclaration;
import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.Expression;

import java.util.Optional;
import java.util.LinkedList;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * A class method.
 *
 */
public class MethodImpl extends MembreClasse {

	protected LinkedList<Argument> args;
	protected Block corps;
	
	protected Optional<Type> retour;
	
	
	public MethodImpl(Classe classe, String name, LinkedList<Argument> args, Block body, DroitAcces auth, boolean statique, Optional<Type> retour) {
		super(classe, name, auth, statique);
		
		this.args = args;
		this.corps = body;
		this.retour = retour;
	}
	
	
	/**
	 * Teste si la signature du constructeur correspond à celle du
	 * constructeur passé en argument (équivalence des types et même nom).
	 */
	public boolean equals(MethodImpl _method) {
		
		LinkedList<Argument> args_fournis = _method.getArguments();
		
		//1. Même nom.
		if (!this.getNom().equals(_method.getNom())) {
			return false;
		}
		
		//2. Même nombre d'arguments
		if (args_fournis.size() != this.args.size())
			return false;
		
		//3. Arguments de même type.
		for (int i = 0; i < this.args.size(); i++) {
			if ( !this.args.get(i).getType().equalsTo(args_fournis.get(i).getType()) )
				return false;
		}
		
		return true;
	}
	
	/**
	 * Teste si la signature du constructeur correspond à celle du
	 * constructeur passé en argument (équivalence des types et même nom).
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
	
	public LinkedList<Argument> getArguments() {
		return this.args;
	}
	
	public Optional<Type> getTypeRetour() {
		return this.retour;
	}
	
	/**
	 * Synthesized Semantics attribute to compute the type of an expression.
	 * @return Synthesized Type of the expression.
	 */
	public MethodImpl toDeclared(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes, Classe classeMere) throws ToDeclaredException {
		
		MethodImpl method_declared;
		
		//DÉCLARATION DU TYPE
		Optional<Type> nouv_opt_type;
		
		if (this.getTypeRetour().isPresent()) {
			
			Type nouv_type;
			
			try {
				nouv_type = this.getTypeRetour().get().toDeclared(interfaces, classes, classeMere);
			} catch (ToDeclaredException e) {
				throw new ToDeclaredException("Classe " + classeMere.getNom() + ", Méthode " + this.getNom() +
										": " + e.getMessage());
			}
			
			nouv_opt_type = Optional.of( nouv_type );
		
		} else {
			nouv_opt_type = getTypeRetour();
		}
		
		//DÉCLARATION DES ARGUMENTS
		LinkedList<Argument> nouv_arguments = Argument.toDeclared_list(interfaces, classes, classeMere,
						"Classe " + classeMere.getNom() + ", Méthode " + this.getNom() + ": ", this.args);
		
		//DÉCLARATION DE LA MÉTHODE
		method_declared = new MethodImpl(classeMere, getNom(), nouv_arguments,
											corps.toDeclared(interfaces, classes, classeMere, this),
											this.getDroitAcces(), this.estStatique(), nouv_opt_type);
		
		return method_declared;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		String text = (this.auth == DroitAcces.PRIVATE) ? "private " : ( (this.auth == DroitAcces.PUBLIC) ? "public " : "protected " );
		
		text += (this.statique) ? "static " : "";
		
		text += (retour.isPresent()) ? retour.get().toString() : "void";
		text += " " + this.name + " (";
		
		for (int i = 0; i < args.size(); i++) {
			text += args.get(i).toString() + ((i != args.size() - 1) ? ", " : "");
		}
		
		text += ")\n" + this.corps;
		
		return text;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#checkType()
	 */
	@Override
	public boolean checkType() {
		throw new RuntimeException("MethodImpl checkType à implémenter");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		throw new RuntimeException("MethodImpl allocateMemory à implémenter");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#generateCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new RuntimeException("MethodImpl getCode à implémenter");
	}

}
