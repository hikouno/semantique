/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Assignable;
import fr.n7.stl.block.ast.VariableDeclaration;
import fr.n7.stl.block.ast.InterfaceDeclaration;
import fr.n7.stl.block.ast.ClasseDeclaration;
import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Expression;

import fr.n7.stl.block.ast.Block;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

import java.util.List;

/**
 * @author Marc Pantel
 *
 */
public class VariableAssignmentImpl extends VariableUseImpl implements Assignable {

	/**
	 * Creates a variable assignment expression Abstract Syntax Tree node.
	 * @param _declaration Declaration of the assigned variable.
	 */
	public VariableAssignmentImpl(VariableDeclaration _declaration) {
		super(_declaration);
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.impl.VariableUseImpl#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment res = declaration.getCode(_factory);
		res.add(_factory.createStore(declaration.getRegister(), declaration.getOffset(), declaration.getType().length()));
		return res;
	}

	@Override
	public Expression toDeclared(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes, Classe classeMere, MethodImpl methodeMere, Block blocPere) throws ToDeclaredException {
		return new VariableAssignmentImpl((VariableDeclaration) this.declaration.toDeclared(interfaces, classes, classeMere, methodeMere, blocPere));
	}

}
