/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Assignable;
import fr.n7.stl.block.ast.impl.MembreClasseAccessImpl.Identifier;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;


public class MembreClasseAccessAssignmentImpl extends MembreClasseAccessImpl implements Assignable {

	
	public MembreClasseAccessAssignmentImpl(Identifier _base) {
		super( _base );
	}
	
	public MembreClasseAccessAssignmentImpl(MembreClasseAccessImpl _access) {
		super( _access );
	}
	
	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new SemanticsUndefinedException("InstanceAssignmentImpl getCode à implémenter");
	}

}
