/**
 * 
 */
package fr.n7.stl.block.ast;

import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.tam.ast.Fragment;


public interface Constante extends Expression{
	
	public String getNom();
	public Expression getValue();
	
	public Type getType();
	
	public Fragment getCode(TAMFactory _factory);

}
