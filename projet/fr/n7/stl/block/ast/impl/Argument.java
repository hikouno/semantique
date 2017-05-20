/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.List;
import java.util.LinkedList;

import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.ClasseDeclaration;
import fr.n7.stl.block.ast.InterfaceDeclaration;

/**
 * A class method.
 *
 */
public class Argument {

	protected Type type;
	protected String name;
	
	public Argument(Type type, String name) {
		this.type = type;
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Type getType() {
		return this.type;
	}
	
	/**
	 * Synthesized Semantics attribute to compute the type of an expression.
	 * @return Synthesized Type of the expression.
	 */
	public Argument toDeclared(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes, Classe classeMere) throws ToDeclaredException {
		
		Argument argument_declared;
		
		if (this.type instanceof UndeclaredTypeImpl) {
			
			String nomType = ((UndeclaredTypeImpl) this.type).getNom();
			ClasseDeclaration dec = ClasseDeclaration.appartient(nomType, classes);
			if (dec != null) {
				
				//On reconstruit un nouvel argument bien déclaré cette fois.
				argument_declared = new Argument(new ClasseTypeImpl(dec.getClasse()), name);
				
			} else {
				throw new ToDeclaredException("Argument " + this.getName() +
									": Le type " + nomType + " est inconnu !");
			}
		
		} else {
			argument_declared = this;
		}
		
		return argument_declared;
	}
	
	/**
	 * toDeclared() for a list of Arguments.
	 */
	public static LinkedList<Argument> toDeclared_list(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes, Classe classeMere,
														String errorPrefix, LinkedList<Argument> args) throws ToDeclaredException {
		
		String errorMsg = "";
		LinkedList<Argument> nouv_args = new LinkedList<Argument>();
		
		for (Argument arg : args) {
			
			try {
				nouv_args.add(arg.toDeclared(interfaces, classes, classeMere));
			} catch (ToDeclaredException e) {
				errorMsg += errorPrefix + " " + e.getMessage() + "\n";
			}
		}
		
		if (!errorMsg.equals(""))
			throw new ToDeclaredException(errorMsg);
		
		return nouv_args;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.type.toString() + " " + this.name;
	}
}
