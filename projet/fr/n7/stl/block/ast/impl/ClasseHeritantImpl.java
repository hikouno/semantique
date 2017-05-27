/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.List;
import java.util.LinkedList;
import java.util.Optional;

import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.Interface;
import fr.n7.stl.block.ast.ClasseDeclaration;
import fr.n7.stl.block.ast.InterfaceDeclaration;

import fr.n7.stl.block.ast.impl.ClasseImpl;
import fr.n7.stl.block.ast.impl.ClasseImplementantImpl;


import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Une classe qui hérite d'une autre classe.
 * 
 */
 
 public class ClasseHeritantImpl extends ClasseImplementantImpl {
	 
	 protected Classe superClasse;
	 protected String unknownClasse;
	 
	 public ClasseHeritantImpl (String name, Classe superClasse, String unknownClasse) {
		 super(name);
		 this.superClasse = superClasse;
		 this.unknownClasse = unknownClasse;
	 }
	 
	 public ClasseHeritantImpl (String name, Classe superClasse, LinkedList<Interface> interfaces, String unknownClasse) {
		 super(name, interfaces);
		 this.superClasse = superClasse;
		 this.unknownClasse = unknownClasse;
	 }
	 
	 
	 /**
	 * Renvoie la superClasse de la classe.
	 * @return La superClasse de la classe.
	 */
	 public Classe getSuperClasse() {
		 return this.superClasse;
	 }
	 
	 /**
	 * Renvoie les attributs de la classe.
	 * @return Les attributs de la classe.
	 */
	 @Override
	public LinkedList<AttributImpl> getAttributs() {
		LinkedList<AttributImpl> newListe = new LinkedList<AttributImpl>(this.attributs);
		newListe.addAll(this.superClasse.getAttributs());
		return newListe;
	}
	
	
	/**
	 * Renvoie si il existe l'attribut de la classe associé au nom.
	 * @return Le résultat.
	 */
	 @Override
	public Optional<AttributImpl> getAttribut(String nom) {
		
		for (AttributImpl _att : this.getAttributs()) {
			if (_att.getNom().equals(nom))
				return Optional.of(_att);
		}
		
		return Optional.empty();
	}
	
	
	/** 
	 * Renvoie la liste des méthodes de la classe. 
	 * * @return Le résultat.
	 */
	public LinkedList<MethodImpl> getMethodes() {
		LinkedList<MethodImpl> newListe = new LinkedList<MethodImpl>(this.methods);
		newListe.addAll(this.superClasse.getMethodes());
		return newListe;
	}
	
	
	/**
	 * Renvoie si elle existe la méthode de la classe associée au nom.
	 * @return Le résultat.
	 */
	 @Override
	public List<MethodImpl> getMethode(String nom) {
		
		List<MethodImpl> methodes = new LinkedList<MethodImpl>();
		
		for (MethodImpl _method : this.getMethodes()) {
			if (_method.getNom().equals(nom))
				methodes.add(_method);
		}
		
		return methodes;	
	}
	
	
	/**
	 * Synthesized Semantics attribute to check if the AST is well formed according
	 * to the scope.
	 * @return The new AST with undeclared references replaces by actual ones.
	 */	
	 @Override
	public ScopeCheckResult scopeCheck(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes) {
		
		//Parcours des attributs
		String errorMsg = "";
		LinkedList<AttributImpl> nouv_attributs = new LinkedList<AttributImpl>();
		
		for (AttributImpl att : this.getAttributs()) {
			AttributImpl nouv_att;
			
			try {
				nouv_att = att.toDeclared(interfaces, classes, this);
			} catch (ToDeclaredException e) {
				errorMsg += e.getMessage() + "\n";
				nouv_att = att;
			}
			
			nouv_attributs.add(nouv_att);
		}
		
		this.attributs = nouv_attributs;
		
		//Parcours des méthodes
		LinkedList<MethodImpl> nouv_methodes = new LinkedList<MethodImpl>();
		
		for (MethodImpl methode : this.getMethodes()) {
			MethodImpl nouv_methode;
			
			try {
				nouv_methode = methode.toDeclared(interfaces, classes, this);
			} catch (ToDeclaredException e) {
				errorMsg += e.getMessage() + "\n";
				nouv_methode = methode;
			}
			
			nouv_methodes.add(nouv_methode);
		}
		
		this.methods = nouv_methodes;
		
		return new ScopeCheckResult(errorMsg.equals(""), errorMsg);
	}
	 
	 
	 /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		String text = "class "+ this.name;
		
		if (this.superClasse != null) {
			text += " extends " + this.superClasse.getNom();
		}
		
		if(this.interfacesImplementees.size() != 0) {
			
			text += " implements ";
		
			for (Interface interf : interfacesImplementees) {
				if(this.interfacesImplementees.indexOf(interf) == 
					this.interfacesImplementees.size()-1) {
						text += interf.getNom();
				} else {
					text += interf.getNom() + ", ";
				}
			}
		}
		text += " {\n";
		
		for (AttributImpl att : this.attributs) {
			text += att + "\n";
		}
		
		//Les attributs de la superClasse
		//Inutile apparement
		
		/*if(this.superClasse.getAttributs().size() != 0) {
			text += "\n"
					+ "--Attributs Hérités--" + "\n";
			for(AttributImpl att : this.superClasse.getAttributs()) {
				text += att + "\n";
			}
		}*/
		
		text += "\n";
		
		for (Constructeur constructeur : this.constructeurs) {
			text += constructeur;
		}
		
		text += "\n";
		
		for (MethodImpl method : this.methods) {
			text += method;
		}
		
		//Les methodes de la superClasse
		//Inutile apparement
		
		/*if(this.superClasse.getMethodes().size() != 0) {
			text += "\n"
					+ "--Méthodes Hérités--" + "\n";
			for(MethodImpl method : this.superClasse.getMethodes()) {
				text += method;
			}
		}*/
		
		text += "\n}";
		return text;
	}
	 
 }
	 
	 
