/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.List;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

import fr.n7.stl.block.ast.UndeclaredInstanceDeclaration;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.InterfaceDeclaration;
import fr.n7.stl.block.ast.ClasseDeclaration;
import fr.n7.stl.block.ast.Instruction;
import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Block;




/**
 *
 */
public class UndeclaredInstanceDeclarationImpl implements UndeclaredInstanceDeclaration {

	protected String typeNom;
	protected String nom;
	protected Expression value;
	
	/**
	 * Creates an undeclared-type instance declaration instruction node for the Abstract Syntax Tree.
	 */
	public UndeclaredInstanceDeclarationImpl(String _nom, String _typeNom, Expression _value) {
		this.nom = _nom;
		this.typeNom = _typeNom;
		this.value = _value;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "???" + this.typeNom + " " + this.nom + " = " + this.value + ";\n";
	}
	
	/**
	 * Provide the value associated to a name in a type declaration.
	 * @return Value from the declaration.
	 */
	@Override
	public String getUndeclaredTypeNom() {
		return this.typeNom;
	}

	/**
	 * Provide the value of the expression
	 * @return Value
	 */
	@Override
	public Expression getValue() {
		return this.value;
	}


	
	/* (non-Javadoc)
	 * @see fr.n7.block.ast.Declaration#getName()
	 */
	@Override
	public String getName() {
		return this.nom;
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		throw new RuntimeException("getType ne doit pas être appelé pour UndeclaredInstanceDeclarationImpl");
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.VariableDeclaration#getRegister()
	 */
	@Override
	public Register getRegister() {
		throw new RuntimeException("UndeclaredInstanceDeclarationImpl getRegister ne doit pas être appelé");
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.VariableDeclaration#getOffset()
	 */
	@Override
	public int getOffset() {
		throw new RuntimeException("UndeclaredInstanceDeclarationImpl getOffset ne doit pas être appelé");
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
		throw new RuntimeException("UndeclaredInstanceDeclarationImpl checkType ne doit pas être appelé");
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#toDeclared()
	 */
	public Instruction toDeclared(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes, Classe classeMere, MethodImpl methodeMere, Block blocPere) throws ToDeclaredException {
		
		ClasseInstanceDeclarationImpl declared;
		
		ClasseDeclaration dec = ClasseDeclaration.appartient(this.typeNom, classes);
		if (dec != null) {
			declared = new ClasseInstanceDeclarationImpl(this.nom, new ClasseTypeImpl(dec.getClasse()),
							this.value.toDeclared(interfaces, classes, classeMere, methodeMere, blocPere));
			
			try {
					blocPere.postScope_register(declared);
			} catch (Exception e) {
			}
			
		} else {
			throw new ToDeclaredException("Ligne " + "???" + this.typeNom + " " + this.nom + " = " + this.value + ": " + this.typeNom + " inconnu.");
		}
		
		return declared;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		throw new RuntimeException("UndeclaredInstanceDeclarationImpl allocateMemory ne doit pas être appelé");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new RuntimeException("UndeclaredInstanceDeclarationImpl getCode ne doit pas être appelé");
	}

}
