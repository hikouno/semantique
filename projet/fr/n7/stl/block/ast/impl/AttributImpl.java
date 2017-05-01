/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.MembreClasse;
import fr.n7.stl.block.ast.MembreClasse.DroitAcces;
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
public class AttributImpl extends MembreClasse {

	protected Type type;
	
	public AttributImpl(Type type, String name, DroitAcces auth, boolean statique) {
		super(name, auth, statique);
		
		this.type = type;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		String text = (this.auth == DroitAcces.PRIVATE) ? "private " : ( (this.auth == DroitAcces.PUBLIC) ? "public " : "protected " );
		
		text += (this.statique) ? "static " : "";
		text += this.type.toString() + " " + this.name + ";";		
		
		return text;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#checkType()
	 */
	@Override
	public boolean checkType() {
		throw new RuntimeException("AttributImpl checkType à implémenter");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		throw new RuntimeException("AttributImpl allocateMemory à implémenter");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#generateCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new RuntimeException("AttributImpl getCode à implémenter");
	}

}