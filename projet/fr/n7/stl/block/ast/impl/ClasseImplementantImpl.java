
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
import fr.n7.stl.block.ast.impl.InterfaceImpl;
import fr.n7.stl.block.ast.impl.InterfaceImpl.Signature;

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
	 * verifier que cette classe implemente interfAImplementer
	 */
	public boolean implemente(Interface interfAImplementer){
		for(Interface interf : this.getInterfacesImplementees()){
			if(interf.implemente(interfAImplementer)){
				return true;
			}
		}
		return false;
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
	public List<Interface> getInterfacesImplementees() {
		return this.interfacesImplementees;
	}
	
	
	/**
	 * Synthesized Semantics attribute to check if the AST is well formed according
	 * to the scope.
	 * @return The new AST with undeclared references replaces by actual ones.
	 */	
	 @Override
	public ScopeCheckResult scopeCheck(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes) {
		String errorMsg = "";
		
		//Déclaration des constructeurs
		try {
			super.constructeurs = ClasseImpl.declareConstructeurs(super.constructeurs, interfaces, classes, this);
		} catch (ToDeclaredException e) {
			errorMsg += e.getMessage() + "\n";
		}
		
		//Déclaration des attributs
		try {
			super.attributs = ClasseImpl.declareAttributes(super.attributs, interfaces, classes, this);
		} catch (ToDeclaredException e) {
			errorMsg += e.getMessage() + "\n";
		}
		
		//Déclaration des méthodes
		try {
			super.methods = ClasseImpl.declareMethods(super.methods, interfaces, classes, this);
		} catch (ToDeclaredException e) {
			errorMsg += e.getMessage() + "\n";
		}
		
		//Parcours des interfaces implémentées
		for(Interface interf : this.interfacesImplementees) {
			if (interf instanceof InterfaceImpl) {
				InterfaceImpl interImpl = (InterfaceImpl) interf;
				for(Signature sign : interImpl.getSignatures()) {
					if (!this.existe(sign, this.getMethodes())) {
						errorMsg += "La méthode " + sign.toString() 
						+ " n'est pas implémentée dans la classe : " 
						+ this.getNom() + "\n";
					}
				}
			}
		}
		return new ScopeCheckResult(errorMsg.equals(""), errorMsg);
	}
	
	
	/** Static method
	 * return true if Signature sign is in the List of methods.
	 */
	 public boolean existe(Signature sign, LinkedList<MethodImpl> methodes) {

		 for(MethodImpl meth : methodes) {
			 
			 if(sign.getType().equals(meth.getTypeRetour())
			 && sign.getNom().equals(meth.getNom())
			 && ClasseImplementantImpl.equArg(sign.getArguments(), meth.getArguments())) {
				 return true;
			 }
		 }
		 return false;
	 }
	 
	 
	 private static boolean equArg(LinkedList<Argument> l1, LinkedList<Argument> l2) {
		 if(l1.size() == l2.size()) {
			 for(int i = 0; i < l1.size(); i++) {
				 if(!(l1.get(i).getType().equals(l2.get(i).getType()))) {
					 return false;
				 }
			 }
			 return true;
		 } else {
			 return false;
		 }
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
