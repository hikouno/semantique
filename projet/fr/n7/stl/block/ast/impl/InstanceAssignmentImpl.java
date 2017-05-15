/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Assignable;
import fr.n7.stl.block.ast.ClasseInstanceDeclaration;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;


public class InstanceAssignmentImpl extends InstanceAccessImpl implements Assignable {

	/**
	 * Creates a variable assignment expression Abstract Syntax Tree node.
	 */
	public InstanceAssignmentImpl(InstanceAssignmentImpl _assignement) {
		super(_assignement);
	}
	
	public InstanceAssignmentImpl(ClasseInstanceDeclaration _declaration) {
		super( new InstanceUseImpl(_declaration) );
	}
	
	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new SemanticsUndefinedException("InstanceAssignmentImpl getCode à implémenter");
	}

}
