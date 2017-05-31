/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import fr.n7.stl.block.ast.Interface;
import fr.n7.stl.block.ast.InterfaceDeclaration;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Constante;
import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.ClasseDeclaration;

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

		public Signature toDeclared(List<InterfaceDeclaration> interfacesDec, List<ClasseDeclaration> classesDec) throws ToDeclaredException{
			LinkedList<Argument> newArg = new LinkedList<Argument>();
			for(Argument arg : this.args){
				newArg.add(arg.toDeclared(interfacesDec, classesDec, null));
			}
			return new Signature(this.type.isPresent()?Optional.of(this.type.get().toDeclared(interfacesDec, classesDec, null)):this.type,
			 	this.nom,
				 newArg);
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
	protected LinkedList<Interface> interfaces;
	protected LinkedList<String> unknownInterfaces;

	
	public InterfaceImpl(String name, LinkedList<Interface> interfaces, LinkedList<String> unknownInterfaces) {
		this.name = name;
		this.signatures = new LinkedList<Signature>();
		this.constantes = new LinkedList<Constante>();
		this.interfaces = interfaces;
		this.unknownInterfaces = unknownInterfaces;
	}

	public ScopeCheckResult scopeCheck(List<InterfaceDeclaration> interfacesDec, List<ClasseDeclaration> classesDec, List<String> listePrecInterfaces) {
		for(String nomInterface : listePrecInterfaces){
			if(this.name.equals(nomInterface)){
				return new ScopeCheckResult(false, this.name + " s'implémente lui même");
			}
		}
		listePrecInterfaces.add(this.name);
		try {
			LinkedList<Signature> newSignatures = new LinkedList<Signature>();
			for(Signature sign : this.signatures){
				newSignatures.add(sign.toDeclared(interfacesDec, classesDec));
			}
			this.signatures = newSignatures;
			LinkedList<Constante> newConstantes = new LinkedList<Constante>();
			for(Constante cons : this.constantes){
				newConstantes.add((Constante) cons.toDeclared(interfacesDec, classesDec, null, null, null));
			}
			this.constantes = newConstantes;
			ScopeCheckResult result;
			for(Interface interf : interfaces){
				result = interf.scopeCheck(interfacesDec, classesDec, listePrecInterfaces);
				if(!result.wasSuccessful()){
					return result;
				}
			}
			InterfaceDeclaration interf;
			for(String nomInter : this.unknownInterfaces) {
				interf = appartient(nomInter, interfacesDec);
				if(interf != null) {
					this.interfaces.add(interf.getInterface());
				} else {
					return new ScopeCheckResult(false, "L'Interface " + nomInter + " n'existe pas. ");
				}
			}
		} catch (ToDeclaredException e) {
			return new ScopeCheckResult(false, e.getMessage());
		}
		return new ScopeCheckResult(true, this.toString());
		
	}
	
	
	/* Vérifie si une interface de la liste passée en paramètre a pour nom
	 * la String passée en paramètre.
	 */
	 private InterfaceDeclaration appartient(String nomInter, List<InterfaceDeclaration> interfacesDec) {
		 for(InterfaceDeclaration _interf : interfacesDec) {
			 if (_interf.getName().equals(nomInter)) {
				 return _interf;
			 }
		 }
		 return null;
	 }
	
	public boolean ajouterSignature(Optional<Type> type, String nom, LinkedList<Argument> args) {
		Signature signature = new Signature(type, nom, args);
		
		for (Signature _sign : this.signatures) {
			if (signature.match(_sign))
					return false; //Une signature similaire existe déjà.
		}
		
		this.signatures.add( signature );
		return true;
	}

	/** 
	 * verifier que cette classe implemente interfAImplementer
	 */
	public boolean implemente(Interface interfAImplementer){
		if(this.equalsTo(interfAImplementer)){
			return true;
		}
		for(Interface interf : this.interfaces){
			if(interf.implemente(interfAImplementer)){
				return true;
			}
		}
		return false;
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
		
		String text = "interface "+this.name;
		
		if(this.interfaces.size() != 0) {
			
			text += " extends ";
		
			for (Interface _interf : this.interfaces) {
				if(this.interfaces.indexOf(_interf) == 
					this.interfaces.size()-1) {
						text += _interf.getNom();
				} else {
					text += _interf.getNom() + ", ";
				}
			}
		}
		
		text += " {\n";

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
