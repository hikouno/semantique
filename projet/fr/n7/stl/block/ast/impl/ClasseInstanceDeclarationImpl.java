/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.ClasseInstanceDeclaration;
import fr.n7.stl.block.ast.ClasseInstance;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Type;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a class instance declaration instruction.
 *
 */
public class ClasseInstanceDeclarationImpl implements ClasseInstanceDeclaration {

	private String nom;
	protected Type type;
	protected Expression value;
	
	protected ClasseInstance instance;
	
	/**
	 * Creates a class declaration instruction node for the Abstract Syntax Tree.
	 */
	public ClasseInstanceDeclarationImpl(String _nom, Type _type, Expression _value) {
		this.nom = _nom;
		this.type = _type;
		
		if (!(_type instanceof ClasseTypeImpl))
			throw new RuntimeException("ClasseInstanceDeclaration demande un type ClasseType");
		
		this.value = _value;
		
		//Génération de l'instance de classe.
		this.instance = new ClasseInstanceImpl( ((ClasseTypeImpl) _type).getClasse() );
	}
	
	/**
	 * Provide the value associated to a name in a type declaration.
	 * @return Value from the declaration.
	 */
	public ClasseInstance getInstance() {
		return this.instance;
	}
	
	/*public ClasseInstanceDeclarationImpl getDeclaration(String nom) {
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
		throw new RuntimeException("ClasseInstanceDeclarationImpl getType à implémenter");
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.VariableDeclaration#getRegister()
	 */
	@Override
	public Register getRegister() {
		throw new RuntimeException("ClasseInstanceDeclarationImpl getRegister à implémenter");
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.VariableDeclaration#getOffset()
	 */
	@Override
	public int getOffset() {
		throw new RuntimeException("ClasseInstanceDeclarationImpl getOffset à implémenter");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
		throw new RuntimeException("ClasseInstanceDeclarationImpl checkType à implémenter");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		throw new RuntimeException("ClasseInstanceDeclarationImpl allocateMemory à implémenter");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new RuntimeException("ClasseInstanceDeclarationImpl getCode à implémenter");
	}
	
}
