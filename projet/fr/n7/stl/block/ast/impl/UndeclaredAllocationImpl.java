/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.List;
import java.util.LinkedList;

import fr.n7.stl.block.ast.ClasseDeclaration;
import fr.n7.stl.block.ast.InterfaceDeclaration;

import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a class instance allocation.
 */
public class UndeclaredAllocationImpl implements Expression {

	protected String nom;
	protected LinkedList<Expression> arguments;
	
	public UndeclaredAllocationImpl(String _nom, LinkedList<Expression> _arguments) {
		this.nom = _nom;
		this.arguments = _arguments;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String text = "new ???" + this.nom + "(";
		
		for (int i = 0; i < this.arguments.size(); i++) {
			text += this.arguments.get(i).toString() + ((i != this.arguments.size() - 1) ? ", " : "");
		}
		
		text += ")";
		
		return text;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#toDeclared()
	 */
	@Override
	public Expression toDeclared(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes, Classe classeMere) {
		return this;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		return new UndeclaredTypeImpl(this.nom);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new SemanticsUndefinedException("getCode ne devrait pas être appelé pour UndeclaredAllocationImpl.");
	}

}
