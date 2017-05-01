/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;
import java.util.Optional;

import fr.n7.stl.block.ast.Interface;
import fr.n7.stl.block.ast.Type;

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
		
		@Override
		public String toString() {
			String text = type.isPresent() ? type.get().toString() : "void";
			text += " " + name + "(";
			
			for (int i = 0; i < args.size(); i++) {
				text += args.get(i).toString() + ((i != args.size() - 1) ? ", " : "");
			}
			
			text += ");";
			
			return text;
		}
	}
	
	protected String name;
	protected LinkedList<Signature> signatures;
	
	public InterfaceImpl(String name) {
		this.name = name;
		this.signatures = new LinkedList<Signature>();
	}
	
	public void ajouterSignature(Optional<Type> type, String nom, LinkedList<Argument> args) {
		this.signatures.add( new Signature(type, nom, args) );
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		String text = "interface "+this.name+" {\n";
		
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
