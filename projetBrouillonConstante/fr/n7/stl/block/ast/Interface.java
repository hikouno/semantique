/**
 * 
 */
package fr.n7.stl.block.ast;

import java.util.LinkedList;
import java.util.Optional;

import fr.n7.stl.block.ast.impl.Argument;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Une interface.
 */
public interface Interface {
	
	/**
	 * Ajoute une signature à l'interface.
	 */
	public boolean ajouterSignature(Optional<Type> type, String nom, LinkedList<Argument> args);
	
	/**
	 * Ajoute une constante à l'interface. */
	public boolean ajouterConstante(Type type, String nom, Expression valeur);
	
	/** Teste si une constante appartient dèjà à l'interface. */
	public boolean isPresentConstante(String nom);
	
	/** Renvoie la constante si elle est présente, null sinon. */
	public Expression getValueConstante(String nom);
	
	/**
	 * Renvoie le nom de l'interface.
	 * @return Le nom de l'interface.
	 */
	public String getNom();
	
	/**
	 * Teste l'égalité de deux interfaces.
	 * @param _interface L'interface à comparer.
	 * @return L'égalité des deux interfaces ou non.
	 */
	public boolean equalsTo(Interface _interface);
	
	/**
	 * Synthesized Semantics attribute to check that an instruction if well typed.
	 * @return Synthesized True if the instruction is well typed, False if not.
	 */	
	public boolean checkType();
	
	/**
	 * Inherited Semantics attribute to allocate memory for the variables declared in the instruction.
	 * Synthesized Semantics attribute that compute the size of the allocated memory. 
	 * @param _register Inherited Register associated to the address of the variables.
	 * @param _offset Inherited Current offset for the address of the variables.
	 * @return Synthesized Size of the memory allocated to the variables.
	 */	
	public int allocateMemory(Register _register, int _offset);
	
	/**
	 * Inherited Semantics attribute to build the nodes of the abstract syntax tree for the generated TAM code.
	 * Synthesized Semantics attribute that provide the generated TAM code.
	 * @param _factory Inherited Factory to build AST nodes for TAM code.
	 * @return Synthesized AST for the generated TAM code.
	 */
	public Fragment getCode(TAMFactory _factory);

}
