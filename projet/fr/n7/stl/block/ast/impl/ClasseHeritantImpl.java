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
import fr.n7.stl.block.ast.impl.ClasseImplementantImpl;


import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Une classe qui hérite d'une autre classe.
 * 
 */
 
 public classe ClasseHeritantImpl extends ClasseImplementantImpl {
	 
	 protected ClasseImpl superClasse;
	 
	 public ClasseHeritantImpl (String name, ClasseImpl superClasse) {
		 super(name);
		 this.superClasse = superClasse;
	 }
	 
	 
	 /**
	 * Renvoie la superClasse de la classe.
	 * @return La superClasse de la classe.
	 */
	 public ClasseImpl getSuperClasse() {
		 return this.superClasse;
	 }
	 
 }
	 
	 
