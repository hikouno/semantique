/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Assignable;
import fr.n7.stl.block.ast.UndeclaredInstanceDeclaration;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;


public class UndeclaredAccessAssignmentImpl extends UndeclaredAccessImpl implements Assignable {

	public UndeclaredAccessAssignmentImpl(UndeclaredInstanceDeclaration _dec) {
		super( _access );
	}
	
	public UndeclaredAccessAssignmentImpl(UndeclaredAccessImpl _base) {
		super( _base );
	}
	
	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new SemanticsUndefinedException("InstanceAssignmentImpl getCode à implémenter");
	}

}
