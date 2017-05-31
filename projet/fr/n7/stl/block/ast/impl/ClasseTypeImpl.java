/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.List;

import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.ClasseDeclaration;
import fr.n7.stl.block.ast.InterfaceDeclaration;
import fr.n7.stl.block.ast.Interface;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.Type;

/**
 * Type d'instance de classe.
 */
public class ClasseTypeImpl implements Type {

	private Classe classe;

	public ClasseTypeImpl(Classe _classe) {
		this.classe = _classe;
	}
	
	public Classe getClasse() {
		return this.classe;
	}
	
	/**
	 * Synthesized Semantics attribute to compute the type of an expression.
	 * @return Synthesized Type of the expression.
	 */
	public Type toDeclared(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes, Classe classeMere) throws ToDeclaredException {
		return this;
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#equalsTo(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean equalsTo(Type _other) {
		if (_other instanceof ClasseTypeImpl) {
			return this.classe.equalsTo( ((ClasseTypeImpl) _other).getClasse() );
		} else {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#compatibleWith(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean compatibleWith(Type _other) {
		boolean compatible = false;
		if (_other instanceof ClasseTypeImpl) {
			Classe autreClasse = ((ClasseTypeImpl) _other).getClasse();
			if(autreClasse.equalsTo(this.getClasse())){
				compatible = true;
			}
			else if(this.getClasse() instanceof ClasseHeritantImpl){
				compatible = ((ClasseHeritantImpl)this.getClasse()).herite(autreClasse);				
			}
		}
		else if(_other instanceof InterfaceTypeImpl && this.getClasse() instanceof ClasseImplementantImpl){
			Interface interf = ((InterfaceTypeImpl) _other).getInterface();
			if(this.getClasse() instanceof ClasseHeritantImpl){
				compatible = ((ClasseHeritantImpl)this.getClasse()).implemente(interf);
			}
			else{
				compatible = ((ClasseImplementantImpl)this.getClasse()).implemente(interf);
			}
		}
		return compatible;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#merge(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public Type merge(Type _other) {
		if (_other instanceof ClasseTypeImpl) {
			throw new SemanticsUndefinedException("Semantics merge is not implemented in ClasseTypeImpl.");
		} else {
			return AtomicType.ErrorType;
		}
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#length(int)
	 */
	@Override
	public int length() {
		int length = 0;
		for (AttributImpl _atts : this.classe.getAttributs()) {
			length += _atts.getType().length();
		}
		
		return length;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.classe.getNom();
	}

}
