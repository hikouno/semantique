/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.List;

import fr.n7.stl.block.ast.InterfaceInstanceDeclaration;
import fr.n7.stl.block.ast.Interface;
import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.InterfaceDeclaration;
import fr.n7.stl.block.ast.ClasseDeclaration;
import fr.n7.stl.block.ast.Instruction;
import fr.n7.stl.block.ast.Block;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a class instance declaration instruction.
 *
 */
public class InterfaceInstanceDeclarationImpl implements InterfaceInstanceDeclaration {

	private String nom;
	protected Type type;
	protected Expression value;
	
	// protected InterfaceInstance instance = null;
	
	/**
	 * Creates a class declaration instruction node for the Abstract Syntax Tree.
	 */
	public InterfaceInstanceDeclarationImpl(String _nom, Type _type, Expression _value) {
		this.nom = _nom;
		this.type = _type;
		
		if (!(_type instanceof InterfaceTypeImpl))
			throw new RuntimeException("InterfaceInstanceDeclaration demande un type InterfaceType");
		
		this.value = _value;
	}
	
	/*public void declareInstance() {
		//Génération de l'instance d'interface.
		List<Expression> appel_constructeur;
		if (this.value instanceof InterfaceInstanceAllocationImpl) {
			appel_constructeur = ((InterfaceInstanceAllocationImpl) this.value).getArgs();
			this.instance = new InterfaceInstanceImpl( ((InterfaceTypeImpl) this.type).getInterface(), appel_constructeur );
		}
	}*/
	
	/**
	 * Provide the value associated to a name in a type declaration.
	 * @return Value from the declaration.
	 */
	/*public InterfaceInstance getInstance() {
		return this.instance;
	}*/
	
	/*public InterfaceInstanceDeclarationImpl getDeclaration(String nom) {
		return this.instance.getDeclaration(nom);
	}*/

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.type + " " + this.nom + " = " + this.value + ";\n";
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.block.ast.VariableDeclaration#getName()
	 */
	@Override
	public String getName() {
		return this.nom;
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.block.ast.VariableDeclaration#getType()
	 */
	@Override
	public Type getType() {
		throw new RuntimeException("InterfaceInstanceDeclarationImpl getType à implémenter");
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.VariableDeclaration#getRegister()
	 */
	@Override
	public Register getRegister() {
		throw new RuntimeException("InterfaceInstanceDeclarationImpl getRegister à implémenter");
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.VariableDeclaration#getOffset()
	 */
	@Override
	public int getOffset() {
		throw new RuntimeException("InterfaceInstanceDeclarationImpl getOffset à implémenter");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
		return ((this.value.getType()).compatibleWith(this.type));
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#toDeclared()
	 */
	public Instruction toDeclared(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes, Classe classeMere, MethodImpl methodeMere, Block blocPere) throws ToDeclaredException {
		
		InterfaceInstanceDeclarationImpl declared = new InterfaceInstanceDeclarationImpl(this.nom, this.type.toDeclared(interfaces, classes, classeMere),
												this.value.toDeclared(interfaces, classes, classeMere, methodeMere, blocPere));
		
		//declared.declareInstance();
		return declared;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		throw new RuntimeException("InterfaceInstanceDeclarationImpl: getCode non implémenté");
		//return this.instance.allocateMemory(_register, _offset);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new RuntimeException("InterfaceInstanceDeclarationImpl: getCode non implémenté");
		//return this.instance.getCode_allocation(_factory);
	}
	
}
