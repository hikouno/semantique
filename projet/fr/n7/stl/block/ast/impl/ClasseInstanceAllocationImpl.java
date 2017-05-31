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
import fr.n7.stl.block.ast.Block;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a class instance allocation.
 */
public class ClasseInstanceAllocationImpl implements Expression {

	protected Classe classe;
	protected LinkedList<Expression> arguments;
	
	public ClasseInstanceAllocationImpl(Classe _classe, LinkedList<Expression> _arguments) {
		this.classe = _classe;
		this.arguments = _arguments;
	}
	
	
	/** Renvoie true si le constructeur que l'on essaie d'appeler existe. */
	public boolean estCorrect() {
		
		return this.classe.getConstructeur(this.arguments).isPresent();
	}
	
	public List<Expression> getArgs() {
		return arguments;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String text = "new " + this.classe.getNom() + "(";
		
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
	public Expression toDeclared(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes, Classe classeMere, MethodImpl methodeMere, Block blocPere) throws ToDeclaredException {
		LinkedList<Expression> nouvListe = new LinkedList<Expression>();
		for(Expression expr : this.arguments){
			nouvListe.add(expr.toDeclared(interfaces, classes, classeMere, methodeMere, blocPere));
		}
		
		return new ClasseInstanceAllocationImpl(this.classe, nouvListe);
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		return new ClasseTypeImpl(this.classe);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new SemanticsUndefinedException("getCode à implémenter pour ClasseInstanceAllocationImpl.");
	}

}
