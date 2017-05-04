/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.Optional;

import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.Expression;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Represents a ClasseInstance node in the Abstract Syntax Tree node for the Bloc language.
 * Declares the various semantics attributes for the node.
 *
 */
public class InstanceAccessImpl implements Expression {
	
	protected InstanceUseImpl use;
	protected String membreAccede;
	protected Type type;
	
	public InstanceAccessImpl(InstanceUseImpl _use) {
		this.use = _use;
		
		this.membreAccede = null;
		this.type = null;
	}
	
	public boolean setMembreAccede(String _nom) {
		
		//Est-ce un argument, une méthode ?
		Classe classe = this.use.getDeclaration().getInstance().getClasse();
		
		Optional<AttributImpl> attribut = classe.getAttribut(_nom);
		Optional<MethodImpl> methode = classe.getMethode(_nom);
		
		System.out.println(classe.getNom() + " : acces a " + _nom);
		
		if (attribut.isPresent()) {
			this.membreAccede = _nom;
			this.type = attribut.get().getType();
			return true;
		}
		else if (methode.isPresent()) {
			this.membreAccede = _nom;
			this.type = methode.get().getTypeRetour().isPresent() ? 
						methode.get().getTypeRetour().get() : null;
			return true;
		}
		
		return false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return use.toString() + "." + membreAccede;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		return this.type;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new RuntimeException("InstanceUseImpl getCode à implémenter");
	}
}
