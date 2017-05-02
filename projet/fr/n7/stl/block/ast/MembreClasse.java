/**
 * 
 */
package fr.n7.stl.block.ast;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Un membre de classe (!= constructeur) : un argument ou une méthode.
 *
 */
public abstract class MembreClasse {
	
	public enum DroitAcces { PUBLIC, PRIVATE, PROTECTED };
	
	protected String name;
	protected DroitAcces auth;
	protected boolean statique;
	
	public MembreClasse(String name, DroitAcces auth, boolean statique) {
		this.name = name;
		this.auth = auth;
		this.statique = statique;
	}
	
	public String getNom() {
		return this.name;
	}
	
	public boolean estStatique() {
		return this.statique;
	}
	
	/**
	 * Synthesized Semantics attribute to check that an instruction if well typed.
	 * @return Synthesized True if the instruction is well typed, False if not.
	 */	
	public abstract boolean checkType();
	
	/**
	 * Inherited Semantics attribute to allocate memory for the variables declared in the instruction.
	 * Synthesized Semantics attribute that compute the size of the allocated memory. 
	 * @param _register Inherited Register associated to the address of the variables.
	 * @param _offset Inherited Current offset for the address of the variables.
	 * @return Synthesized Size of the memory allocated to the variables.
	 */	
	public abstract int allocateMemory(Register _register, int _offset);
	
	/**
	 * Inherited Semantics attribute to build the nodes of the abstract syntax tree for the generated TAM code.
	 * Synthesized Semantics attribute that provide the generated TAM code.
	 * @param _factory Inherited Factory to build AST nodes for TAM code.
	 * @return Synthesized AST for the generated TAM code.
	 */
	public abstract Fragment getCode(TAMFactory _factory);

}
