/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.List;
import java.util.LinkedList;
import java.util.Optional;

import fr.n7.stl.block.ast.ClasseDeclaration;
import fr.n7.stl.block.ast.InterfaceDeclaration;

import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Expression;
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
			if (constructeur.match_constr(_constr))
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
			if (method.equals(_method) && method.estStatique() == _method.estStatique())
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
	 * Renvoie les attributs de la classe.
	 * @return Les attributs de la classe.
	 */
	public LinkedList<AttributImpl> getAttributs() {
		return this.attributs;
	}
	
	/**
	 * Renvoie si il existe le constructeur correspondant aux arguments
	 * passés.
	 * @return Le résultat.
	 */
	public Optional<Constructeur> getConstructeur(List<Expression> args_passes) {
		
		LinkedList<Constructeur> candidats = this.constructeurs;
		
		for (Constructeur _constr : this.constructeurs) {
			if (_constr.match(args_passes))
				return Optional.of(_constr);
		}
		
		return Optional.empty();
	}
	
	/**
	 * Renvoie si il existe l'attribut de la classe associé au nom.
	 * @return Le résultat.
	 */
	public Optional<AttributImpl> getAttribut(String nom) {
		
		for (AttributImpl _att : this.attributs) {
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
		return this.methods;
	}
	
	
	/**
	 * Renvoie si elle existe la méthode de la classe associée au nom.
	 * @return Le résultat.
	 */
	public List<MethodImpl> getMethode(String nom) {
		
		List<MethodImpl> methodes = new LinkedList<MethodImpl>();
		
		for (MethodImpl _method : this.methods) {
			if (_method.getNom().equals(nom))
				methodes.add(_method);
		}
		
		return methodes;	
	}
	
	/**
	 * Renvoie si elle existe la méthode de la classe associée au nom et 
	 * matchant les arguments passés en paramètres.
	 * @return Le résultat.
	 */
	public Optional<MethodImpl> getMethode(String nom, List<Expression> args_passes) {
		
		List<MethodImpl> candidates = this.getMethode(nom);
		
		for (MethodImpl _methode : candidates) {
			if (_methode.match(args_passes))
				return Optional.of(_methode);
		}
		
		return Optional.empty();
		
	}
	
	protected static LinkedList<AttributImpl> declareAttributes(LinkedList<AttributImpl> atts, List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes, Classe classeMere) throws ToDeclaredException {
		String errorMsg = "";
		LinkedList<AttributImpl> nouv_attributs = new LinkedList<AttributImpl>();
		
		for (AttributImpl att : atts) {
			AttributImpl nouv_att;
			
			try {
				nouv_att = att.toDeclared(interfaces, classes, classeMere);
			} catch (ToDeclaredException e) {
				errorMsg += e.getMessage() + "\n";
				nouv_att = att;
			}
			
			nouv_attributs.add(nouv_att);
		}
		
		if (!errorMsg.equals(""))
			throw new ToDeclaredException(errorMsg);
		
		return nouv_attributs;
	}
	
	protected static LinkedList<MethodImpl> declareMethods(LinkedList<MethodImpl> meths, List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes, Classe classeMere) throws ToDeclaredException {
		String errorMsg = "";
		LinkedList<MethodImpl> nouv_methodes = new LinkedList<MethodImpl>();
		
		for (MethodImpl methode : meths) {
			MethodImpl nouv_methode;
			
			try {
				nouv_methode = methode.toDeclared(interfaces, classes, classeMere);
			} catch (ToDeclaredException e) {
				errorMsg += e.getMessage() + "\n";
				nouv_methode = methode;
			}
			
			nouv_methodes.add(nouv_methode);
		}
		
		if (!errorMsg.equals(""))
			throw new ToDeclaredException(errorMsg);
		
		return nouv_methodes;
	}
	
	/**
	 * Synthesized Semantics attribute to check if the AST is well formed according
	 * to the scope.
	 * @return The new AST with undeclared references replaces by actual ones.
	 */	
	public ScopeCheckResult scopeCheck(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes) {
		
		//Déclaration des attributs
		String errorMsg = "";
		
		try {
			this.attributs = ClasseImpl.declareAttributes(this.attributs, interfaces, classes, this);
		} catch (ToDeclaredException e) {
			errorMsg += e.getMessage() + "\n";
		}
		
		//Déclaration des méthodes
		try {
			this.methods = ClasseImpl.declareMethods(this.methods, interfaces, classes, this);
		} catch (ToDeclaredException e) {
			errorMsg += e.getMessage() + "\n";
		}
		
		//Parcours des constructeurs
		LinkedList<Constructeur> nouv_constrs = new LinkedList<Constructeur>();
		
		for (Constructeur constr : this.constructeurs) {
			Constructeur nouv_constr;
			
			try {
				nouv_constr = constr.toDeclared(interfaces, classes, this);
			} catch (ToDeclaredException e) {
				errorMsg += e.getMessage() + "\n";
				nouv_constr = constr;
			}
			
			nouv_constrs.add(nouv_constr);
		}
		
		this.constructeurs = nouv_constrs;
		
		return new ScopeCheckResult(errorMsg.equals(""), errorMsg);
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
		for(MethodImpl meth : this.methods){
			if(!meth.checkType()){
				return false;
			}
		}
		for(Constructeur constr : this.constructeurs){
			if(!constr.checkType()){
				return false;
			}
		}
		return true;		
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
