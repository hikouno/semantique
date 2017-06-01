/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.List;

import fr.n7.stl.block.ast.ClasseDeclaration;
import fr.n7.stl.block.ast.InterfaceDeclaration;

import fr.n7.stl.block.ast.Assignable;
import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.impl.MembreClasseAccessImpl.Identifier;
import fr.n7.stl.block.ast.Type;

import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Expression;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;


public class MembreClasseAccessAssignmentImpl extends MembreClasseAccessImpl implements Assignable {

	
	public MembreClasseAccessAssignmentImpl(Identifier _base) {
		super( _base );
	}
	
	public MembreClasseAccessAssignmentImpl(MembreClasseAccessImpl _access, boolean copy) {
		super( _access, copy );
	}
	
	
	//Redéfinition du toDeclared
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#toDeclared()
	 */
	@Override
	public Expression toDeclared(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes, Classe classeMere, MethodImpl methodeMere, Block blocPere) throws ToDeclaredException {
		
        MembreClasseAccessImpl declared = (MembreClasseAccessImpl) super.toDeclared(interfaces, classes, classeMere, methodeMere, blocPere);
        
        MembreClasseAccessAssignmentImpl dec_assign = new MembreClasseAccessAssignmentImpl(declared, true);
        dec_assign.setVerified(true);
        dec_assign.setType(declared.getType());
        
        return dec_assign;
	}

	private void setType(Type nouvType){
		super.type = nouvType;
	}


	
	
	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new SemanticsUndefinedException("InstanceAssignmentImpl getCode à implémenter");
	}

}
