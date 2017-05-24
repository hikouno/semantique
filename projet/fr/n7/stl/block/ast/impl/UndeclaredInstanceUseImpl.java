/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.List;

import fr.n7.stl.block.ast.UndeclaredInstanceDeclaration;

import fr.n7.stl.block.ast.ClasseDeclaration;
import fr.n7.stl.block.ast.InterfaceDeclaration;

import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.Block;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a variable use expression.
 * @author Marc Pantel
 *
 */
public class UndeclaredInstanceUseImpl implements Expression {

	protected UndeclaredInstanceDeclaration declaration;
	
	/**
	 * Creates a variable use expression Abstract Syntax Tree node.
	 */
	public UndeclaredInstanceUseImpl(UndeclaredInstanceDeclaration _declaration) {
		this.declaration = _declaration;
	}
	
	public UndeclaredInstanceDeclaration getDeclaration() {
		return declaration;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ("@???{" + this.declaration.getName() + "}");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#toDeclared()
	 */
	@Override
	public Expression toDeclared(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes, Classe classeMere, MethodImpl methodeMere, Block blocPere) throws ToDeclaredException {
		
		if (!blocPere.postScope_knows( this.declaration.getName() )) {
			throw new ToDeclaredException("UndeclaredInstanceUse : " + this.declaration.getName() + " non déclarée précédemment.");
		}
		
		ClasseInstanceDeclarationImpl dec;
		try {
			dec = (ClasseInstanceDeclarationImpl) blocPere.postScope_get( this.declaration.getName() ).get();
		} catch (Exception e) {
			throw new ToDeclaredException("UndeclaredInstanceUse " + this.declaration.getName() + ": " + e.getMessage());
		}
		
		return new InstanceUseImpl(dec);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		throw new RuntimeException("getType pour UndeclarationInstanceUseImpl");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new RuntimeException("getCode pour UndeclarationInstanceUseImpl");
	}

}
