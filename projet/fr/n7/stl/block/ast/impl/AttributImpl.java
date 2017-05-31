/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.List;

import fr.n7.stl.block.ast.MembreClasse;
import fr.n7.stl.block.ast.MembreClasse.DroitAcces;
import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.ClasseDeclaration;
import fr.n7.stl.block.ast.InterfaceDeclaration;
import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.Type;

import java.util.Optional;
import java.util.LinkedList;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * A class method.
 *
 */
public class AttributImpl extends MembreClasse {

	protected Type type;
	
	public AttributImpl(Classe classe, Type type, String name, DroitAcces auth, boolean statique) {
		super(classe, name, auth, statique);
		
		this.type = type;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		String text = (this.auth == DroitAcces.PRIVATE) ? "private " : ( (this.auth == DroitAcces.PUBLIC) ? "public " : "protected " );
		
		text += (this.statique) ? "static " : "";
		text += this.type.toString() + " " + this.name + ";";		
		
		return text;
	}
	
	public Type getType() {
		return this.type;
	}
	
	/**
	 * Synthesized Semantics attribute to compute the type of an expression.
	 * @return Synthesized Type of the expression.
	 */
	public AttributImpl toDeclared(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes, Classe classeMere) throws ToDeclaredException {
		
		AttributImpl att_declared;
		
		try {
			att_declared = new AttributImpl(classeMere,
								this.getType().toDeclared(interfaces, classes, classeMere),
								this.getNom(), this.getDroitAcces(), this.estStatique());
		} catch (ToDeclaredException e) {
			throw new ToDeclaredException("Classe " + classeMere.getNom() + ", Attribut " + this.getNom() +
									": " + e.getMessage());
		}
		
		return att_declared;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#checkType()
	 */
	@Override
	public boolean checkType() {
		throw new RuntimeException("AttributImpl checkType à implémenter");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		return this.type.length();
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#generateCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	public Fragment getCode(TAMFactory _factory) {
		throw new RuntimeException("AttributImpl getCode à implémenter");
	}

}
