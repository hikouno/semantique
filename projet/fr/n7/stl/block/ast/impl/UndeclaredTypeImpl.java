	/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.List;

import fr.n7.stl.block.ast.ClasseDeclaration;
import fr.n7.stl.block.ast.InterfaceDeclaration;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.Classe;

/**
 * Type d'instance de classe.
 */
public class UndeclaredTypeImpl implements Type {

	private String nom;

	public UndeclaredTypeImpl(String _nom) {
		this.nom = _nom;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	/**
	 * Synthesized Semantics attribute to compute the type of an expression.
	 * @return Synthesized Type of the expression.
	 */
	public Type toDeclared(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes, Classe classeMere) throws ToDeclaredException {
		
		Type type_declared;
		InterfaceDeclaration interf = InterfaceDeclaration.appartient(this.nom, interfaces);
		if (interf != null) {
			
			//On reconstruit un nouveau type bien déclaré cette fois.
			type_declared = new InterfaceTypeImpl(interf.getInterface());
			
		} else {
			ClasseDeclaration dec = ClasseDeclaration.appartient(this.nom, classes);
			if (dec != null) {
				
				//On reconstruit un nouveau type bien déclaré cette fois.
				type_declared = new ClasseTypeImpl(dec.getClasse());
			} else {
				throw new ToDeclaredException("Le type " + this.nom + " est inconnu !");
			}
		}		
		return type_declared;
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#equalsTo(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean equalsTo(Type _other) {
		throw new SemanticsUndefinedException("Semantics equalsTo should not be implemented in UndeclaredTypeImpl.");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#compatibleWith(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean compatibleWith(Type _other) {
		throw new SemanticsUndefinedException("Semantics compatibleWith should not be implemented in UndeclaredTypeImpl.");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#merge(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public Type merge(Type _other) {
		throw new SemanticsUndefinedException("Semantics merge should not be implemented in UndeclaredTypeImpl.");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#length(int)
	 */
	@Override
	public int length() {
		throw new SemanticsUndefinedException("Semantics length should not be implemented in UndeclaredTypeImpl.");
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "???" + this.nom;
	}

}
