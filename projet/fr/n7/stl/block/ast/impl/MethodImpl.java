/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Method;
import fr.n7.stl.block.ast.Method.DroitAcces;
import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.Type;

import java.util.Optional;
import java.util.LinkedList;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * A class method.
 *
 */
public class MethodImpl implements Method {


	protected String name;
	protected LinkedList<Argument> args;
	protected Block corps;
	protected DroitAcces auth;
	
	protected Optional<Type> retour;
	
	
	public MethodImpl(String name, LinkedList<Argument> args, Block body, DroitAcces auth, Optional<Type> retour) {
		this.name = name;
		this.args = args;
		this.corps = body;
		this.auth = auth;
		
		this.retour = retour;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		String text = (auth == DroitAcces.PRIVATE) ? "private " : ( (auth == DroitAcces.PUBLIC) ? "public " : "protected " ) +
				this.name + " (";
		
		for (int i = 0; i < args.size(); i++) {
			text += arg + (i != args.size() - 1) ? ", " : "";
		}
		
		text += ")\n" + this.corps;
		
		return text;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#checkType()
	 */
	@Override
	public boolean checkType() {
		throw new RuntimeException("ProgramImpl checkType à implémenter");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		throw new RuntimeException("ProgramImpl allocateMemory à implémenter");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#generateCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new RuntimeException("ProgramImpl getCode à implémenter");
	}

}
