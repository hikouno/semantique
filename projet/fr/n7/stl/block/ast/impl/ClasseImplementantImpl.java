
/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;
import java.util.Optional;

import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.Type;

import fr.n7.stl.block.ast.impl.ClasseImpl;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Une classe qui peut éventuellement implémenter d'autres classes.
 * 
 */

public class ClasseImplementantImpl extends ClasseImpl {
	
	
	protected LinkedList<InterfaceImpl> interfacesImplementees;
	
	
	public ClasseImplementantImpl(String name) {
		super(name);
		this.interfacesImplementees = new LinkedList<InterfaceImpl>();
	}
	
	/** 
	 * Ajouter une interface implémentée à la classe.
	 */
	public boolean ajouterInterface(InterfaceImpl interfac) {
		for (InterfaceImpl _interf : this.interfacesImplementees) {
			if (interfac.getNom().equalsTo(_interf.getNom()) )
					return false; //Une interface similaire existe déjà
		}
		
		this.interfacesImplementees.add(interfac);
		return true;
	}
	
	
	
	/**
	 * Renvoie les interfaces de la classe.
	 * @return Les interfaces de la classe.
	 */
	public LinkedList<Classe> getClassesImplementees() {
		return this.classesImplementees;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		String text = "class "+ this.name;
		if(this.interfacesImplementees.size() != 0) {
			
			text += " implements ";
		
			for (InterfaceImpl interf : interfacesImplementees) {
				if(this.interfacesImplementees.indexOf(interf) == 
					this.interfacesImplementees.length()-1) {
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
