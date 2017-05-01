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
 * A class.
 *
 */
public class ClasseImpl implements Classe {

	
	protected String name;
	protected LinkedList<MethodImpl> methods;
	
	public ClasseImpl(String name) {
		this.name = name;
		this.methods = new LinkedList<MethodImpl>();
	}
	
	
	public void ajouterMethode(MethodImpl method) {
		this.methods.add(method);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		String text = "class "+this.name+" {\n";
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
