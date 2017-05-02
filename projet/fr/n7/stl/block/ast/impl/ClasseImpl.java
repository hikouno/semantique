/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;

import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.Type;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Une classe.
 * 
 * Cette implémentation garantit que la classe ne peut avoir deux constructeurs
 * de même signature (au niveau des types).
 */
public class ClasseImpl implements Classe {

	protected String name;
	
	protected LinkedList<Constructeur> constructeurs;
	protected LinkedList<AttributImpl> attributs;
	protected LinkedList<MethodImpl> methods;
	
	public ClasseImpl(String name) {
		this.name = name;
		
		this.constructeurs = new LinkedList<Constructeur>();
		this.attributs = new LinkedList<AttributImpl>();
		this.methods = new LinkedList<MethodImpl>();
	}
	
	public boolean ajouterConstructeur(Constructeur constructeur) {
		for (Constructeur _constr : this.constructeurs) {
			if (constructeur.match(_constr))
				return false; //Un constructeur similaire existe déjà.
		}
		
		this.constructeurs.add(constructeur);
		return true;
	}
	
	public boolean ajouterAttribut(AttributImpl attribut) {
		for (AttributImpl _att : this.attributs) {
			if (attribut.getNom().equals(_att.getNom()) && attribut.estStatique() == _att.estStatique())
				return false; //Un attribut de même nom et de même "staticité" existe déjà.
		}
		
		this.attributs.add(attribut);
		return true;
	}
	
	public boolean ajouterMethode(MethodImpl method) {
		for (MethodImpl _method : this.methods) {
			if (method.getNom().equals( _method.getNom()) &&  method.match(_method) &&
				method.estStatique() == _method.estStatique())
					return false; //Une méthode similaire existe déjà
		}
		
		this.methods.add(method);
		return true;
	}
	
	public String getNom() {
		return this.name;
	}
	
	/**
	 * Renvoie les constructeurs de la classe.
	 * @return Les constructeurs de la classe.
	 */
	public LinkedList<Constructeur> getConstructeurs() {
		return this.constructeurs;
	}
	
	/**
	 * Teste l'égalité de deux classes.
	 * @param _classe La classe à comparer.
	 * @return L'égalité des deux classes ou non.
	 */
	public boolean equalsTo(Classe _classe) {
		return this.getNom().equals(_classe.getNom());
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		String text = "class "+this.name+" {\n";
		
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

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#checkType()
	 */
	@Override
	public boolean checkType() {
		throw new RuntimeException("ClasseImpl checkType à implémenter");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		throw new RuntimeException("ClasseImpl allocateMemory à implémenter");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#generateCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new RuntimeException("ClasseImpl getCode à implémenter");
	}

}
