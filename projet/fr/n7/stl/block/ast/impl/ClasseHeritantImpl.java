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
import fr.n7.stl.block.ast.MembreClasse.DroitAcces;
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
	 protected LinkedList<MethodImpl> methodesHeritees;	
	 protected LinkedList<AttributImpl> attributsHerites;

	 
	 
	 public ClasseHeritantImpl (String name, Classe superClasse, String unknownClasse) {
		 super(name);
		 this.superClasse = superClasse;
		 this.unknownClasse = unknownClasse;
		 if(this.superClasse != null) {
			 this.methodesHeritees.addAll(triMeth(this.superClasse.getMethodes()));
			 this.attributsHerites.addAll(triAttr(this.superClasse.getAttributs()));
		 }
	 }
	 
	 public ClasseHeritantImpl (String name, Classe superClasse, LinkedList<Interface> interfaces, String unknownClasse) {
		 super(name, interfaces);
		 this.superClasse = superClasse;
		 this.unknownClasse = unknownClasse;
		 if(this.superClasse != null) {
			 this.methodesHeritees.addAll(triMeth(this.superClasse.getMethodes()));
			 this.attributsHerites.addAll(triAttr(this.superClasse.getAttributs()));
		 }
	 }
	 
	 
	 /** Retourne la liste des attributs de la liste qui ne sont pas privés.
	  */
	  private static LinkedList<AttributImpl> triAttr(LinkedList<AttributImpl> source) {
		  LinkedList<AttributImpl> result = new LinkedList<AttributImpl>();
		  for(AttributImpl mbClasse : source) {
			  if(!(mbClasse.getDroitAcces() == DroitAcces.PRIVATE)) {
				  result.add(mbClasse);
			  }
		  }
		  return result;
	  }
	  
	  /** Retourne la liste des attributs de la liste qui ne sont pas privés.
	  */
	  private static LinkedList<MethodImpl> triMeth(LinkedList<MethodImpl> source) {
		  LinkedList<MethodImpl> result = new LinkedList<MethodImpl>();
		  for(MethodImpl mbClasse : source) {
			  if(!(mbClasse.getDroitAcces() == DroitAcces.PRIVATE)) {
				  result.add(mbClasse);
			  }
		  }
		  return result;
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
		if(this.superClasse != null) {
			newListe.addAll(this.superClasse.getAttributs());
		}
		return newListe;
	}
	
	/** Renvoie les attributs hérités seulement de la classe.
	 */
	 public LinkedList<AttributImpl> getAttributsHerites() {
		 return this.triAttr(this.superClasse.getAttributs());
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
		if(this.superClasse != null) {
			newListe.addAll(this.superClasse.getMethodes());
		}
		return newListe;
	}
	
	/** Renvoie les méthodes hérités seulement de la classe.
	 */
	 public LinkedList<MethodImpl> getMethodesHeritees() {
		 return this.triMeth(this.superClasse.getMethodes());
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
	
	
	/* Vérifie si une classe de la liste passée en paramètre a pour nom
	 * la String passée en paramètre.
	 */
	 private ClasseDeclaration appartient(String nomClasse, List<ClasseDeclaration> classeDec) {
		 for(ClasseDeclaration _classe : classeDec) {
			 if (_classe.getName().equals(nomClasse)) {
				 return _classe;
			 }
		 }
		 return null;
	 }
	
	
	/**
	 * Synthesized Semantics attribute to check if the AST is well formed according
	 * to the scope.
	 * @return The new AST with undeclared references replaces by actual ones.
	 */	
	 @Override
	public ScopeCheckResult scopeCheck(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes) {
		super.scopeCheck(interfaces, classes);
		
		String errorMsg = "";
		
		// La superClasse
		if(this.unknownClasse != null) {
			ClasseDeclaration res = appartient(this.unknownClasse, classes);
			if(res != null) {
				this.superClasse = res.getClasse();
			} else {
				errorMsg += "La classe " + this.unknownClasse + " n'existe pas. \n";
			}
		}


		//Parcours des attributs hérités
		if(this.superClasse != null) {
			LinkedList<AttributImpl> new_attributs = new LinkedList<AttributImpl>();
			
			for (AttributImpl att : this.getAttributsHerites()) {
				AttributImpl nouv_att;
				
				try {
					nouv_att = att.toDeclared(interfaces, classes, this);
				} catch (ToDeclaredException e) {
					errorMsg += e.getMessage() + "\n";
					nouv_att = att;
				}
				
				new_attributs.add(nouv_att);
			}
			this.attributsHerites = new_attributs;
		}
		
		//Parcours des méthodes heritées
		if(this.superClasse != null) {
			LinkedList<MethodImpl> new_methodes = new LinkedList<MethodImpl>();
			
			for (MethodImpl methode : this.getMethodesHeritees()) {
				MethodImpl nouv_methode;
				
				try {
					nouv_methode = methode.toDeclared(interfaces, classes, this);
				} catch (ToDeclaredException e) {
					errorMsg += e.getMessage() + "\n";
					nouv_methode = methode;
				}			
				new_methodes.add(nouv_methode);
			}		
			this.methodesHeritees = new_methodes;
		}
		
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
		} else if (this.unknownClasse != null) {
			text += " extends ???" + this.unknownClasse;
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
		if(this.superClasse != null && this.getAttributsHerites().size() != 0) {
			text += "\n"
					+ "--Attributs Hérités--" + "\n";
			for(AttributImpl att : this.getAttributsHerites()) {
				text += att + "\n";
			}
		}
		
		text += "\n";
		
		for (Constructeur constructeur : this.constructeurs) {
			text += constructeur;
		}
		
		text += "\n";
		
		for (MethodImpl method : this.methods) {
			text += method;
		}
		
		//Les methodes de la superClasse
		if(this.superClasse != null && this.getMethodesHeritees().size() != 0) {
			text += "\n"
					+ "--Méthodes Hérités--" + "\n";
			for(MethodImpl method : this.getMethodesHeritees()) {
				text += method;
			}
		}
		
		text += "\n}";
		return text;
	}
	 
 }
	 
	 
