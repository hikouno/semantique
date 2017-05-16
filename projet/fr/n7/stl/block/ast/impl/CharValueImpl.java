/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.List;

import fr.n7.stl.block.ast.ClasseDeclaration;
import fr.n7.stl.block.ast.InterfaceDeclaration;

import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.IntegerValue;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.CharValue;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for an integer constant expression.
 * @author AlexisDuSale EpiDeMais
 *
 */
public class CharValueImpl implements CharValue {

	private char value;
	
	/**
	 * Builds an String value expression implementation from a textual representation of the String.
	 * @param _text Textual representation of the String value.
	 */
	public CharValueImpl(String _text) {
	  if(!(_text.length() == 3)) {
	    throw new RuntimeException("un seul caractère attendu et reçu: "+ _text);
	  }
	  value = _text.charAt(1);

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\'" + this.value + "\'";
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#toDeclared()
	 */
	@Override
	public Expression toDeclared(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes) {
		return this;
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		return AtomicType.CharacterType;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new RuntimeException("Pas implemanté");
	}

}
