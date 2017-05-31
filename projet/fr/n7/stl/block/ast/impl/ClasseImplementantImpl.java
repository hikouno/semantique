
/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.Interface;
import fr.n7.stl.block.ast.ClasseDeclaration;
import fr.n7.stl.block.ast.InterfaceDeclaration;


import fr.n7.stl.block.ast.impl.ClasseImpl;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Une classe qui peut éventuellement implémenter d'autres classes.
 * 
 */

public class ClasseImplementantImpl extends ClasseImpl {
	
	
	protected List<Interface> interfacesImplementees;
	
	public ClasseImplementantImpl(String name) {
		super(name);
		this.interfacesImplementees = new LinkedList<Interface>();
	}
	
	public ClasseImplementantImpl(String name, LinkedList<Interface> interfaces) {
		super(name);
		this.interfacesImplementees = interfaces;
	}
	
	/** 
	 * Ajouter une interface implémentée à la classe.
	 */
	public boolean ajouterInterface(InterfaceImpl interfac) {
		for (Interface _interf : this.interfacesImplementees) {
			if (interfac.getNom().equals(_interf.getNom()) )
					return false; //Une interface similaire existe déjà
		}
		
		this.interfacesImplementees.add(interfac);
		return true;
	}
	
	
	
	/**
	 * Renvoie les interfaces de la classe.
	 * @return Les interfaces de la classe.
	 */
	public List<Interface> getClassesImplementees() {
		return this.interfacesImplementees;
	}
	
	
	/**
	 * Synthesized Semantics attribute to check if the AST is well formed according
	 * to the scope.
	 * @return The new AST with undeclared references replaces by actual ones.
	 */	
	 @Override
	public ScopeCheckResult scopeCheck(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes) {
		return super.scopeCheck(interfaces, classes);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		String text = "class "+ this.name;
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
