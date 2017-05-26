/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;
import java.util.Optional;

import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.Interface;

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
	 
	 public ClasseHeritantImpl (String name, Classe superClasse) {
		 super(name);
		 this.superClasse = superClasse;
	 }
	 
	 public ClasseHeritantImpl (String name, Classe superClasse, LinkedList<Interface> interfaces) {
		 super(name, interfaces);
		 this.superClasse = superClasse;
	 }
	 
	 
	 /**
	 * Renvoie la superClasse de la classe.
	 * @return La superClasse de la classe.
	 */
	 public Classe getSuperClasse() {
		 return this.superClasse;
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
		
		for (AttributImpl att : attributs) {
			text += att + "\n";
		}
		
		text += "\n";
		
		for (Constructeur constructeur : constructeurs) {
			text += constructeur;
		}
		
		text += "\n";
		
		for (MethodImpl method : methods) {
			text += method;
		}
		
		text += "\n}";
		return text;
	}
	 
 }
	 
	 
