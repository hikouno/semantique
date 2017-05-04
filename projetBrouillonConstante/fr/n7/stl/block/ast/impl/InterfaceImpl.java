/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;
import java.util.Optional;

import fr.n7.stl.block.ast.Interface;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Constante;


import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Une interface.
 */
public class InterfaceImpl implements Interface {
	
	private class Signature {
		
		private Optional<Type> type;
		private String nom;
		private LinkedList<Argument> args;
		
		public Signature(Optional<Type> type, String nom, LinkedList<Argument> args) {
			this.type = type;
			this.nom = nom;
			this.args = args;
		}
		
		/** Renvoie true si on a deux signatures ambigues
		 * (même nom et types des paramètres dans l'ordre).
		 */
		public boolean match(Signature _signature) {
			
			LinkedList<Argument> args_fournis = _signature.getArguments();
			
			//1. Même nom.
			if (!this.nom.equals(_signature.getNom())) {
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
		
		public String getNom() { return this.nom; }
		public LinkedList<Argument> getArguments() { return this.args; }
		
		@Override
		public String toString() {
			String text = type.isPresent() ? type.get().toString() : "void";
			text += " " + this.nom + "(";
			
			for (int i = 0; i < args.size(); i++) {
				text += args.get(i).toString() + ((i != args.size() - 1) ? ", " : "");
			}
			
			text += ");";
			
			return text;
		}
	}
	
	protected String name;
	protected LinkedList<Signature> signatures;
	protected LinkedList<Constante> constantes;
	
	public InterfaceImpl(String name) {
		this.name = name;
		this.signatures = new LinkedList<Signature>();
		this.constantes = new LinkedList<Constante>();
	}
	
	/** Ajouter une signature. */
	public boolean ajouterSignature(Optional<Type> type, String nom, LinkedList<Argument> args) {
		Signature signature = new Signature(type, nom, args);
		
		for (Signature _sign : this.signatures) {
			if (signature.match(_sign))
					return false; //Une signature similaire existe déjà.
		}
		this.signatures.add( signature );
		return true;
	}
	
	/** Ajouter une constante. */
	public boolean ajouterConstante(Type type, String nom, Expression valeur) {
		Constante constante = new ConstanteImpl(type, nom, valeur);
		
		for (Constante _const : this.constantes) {
			if (nom.equals(_const.getNom())) {
					return false; //Une constante de même nom existe déjà.
				}
		}
		this.constantes.add( constante );
		return true;
	}
	
	/** Teste si une constante appartient dèjà à l'interface. */
	public boolean isPresentConstante(String nom) {		
		for (Constante _const : this.constantes) {
			if (nom.equals(_const.getNom())) {
					return true; //Une constante de même nom existe déjà.
				}
		}
		return false;
	}
	
	/** Renvoie la constante si elle est présente, null sinon. */
	public Expression getValueConstante(String nom) {		
		for (Constante _const : this.constantes) {
			if (nom.equals(_const.getNom())) {
					return _const.getValue(); //On a trouvé la constante.
				}
		}
		return null;
	}
	
	
	
	
	
	/**
	 * Renvoie le nom de l'interface.
	 * @return Le nom de l'interface.
	 */
	public String getNom() {
		return this.name;
	}
	
	/**
	 * Teste l'égalité de deux interfaces.
	 * @param _interface L'interface à comparer.
	 * @return L'égalité des deux interfaces ou non.
	 */
	public boolean equalsTo(Interface _interface) {
		return this.name.equals(_interface.getNom());
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		String text = "interface "+this.name+" {\n";
		
		for (Constante consta : this.constantes) {
			text += consta.toString() + "\n";
		}
		
		for (Signature sign : this.signatures) {
			text += sign + "\n";
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
