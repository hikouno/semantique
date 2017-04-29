/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Type;

/**
 * A class method.
 *
 */
public class Argument {

	protected Type type;
	protected String name;
	
	public Argument(Type type, String name) {
		this.type = type;
		this.name = name;
	}
	
	public String getName() {
		return this.type;
	}
	
	public Type getType() {
		return this.type;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.type + " " + this.name;
	}
}
