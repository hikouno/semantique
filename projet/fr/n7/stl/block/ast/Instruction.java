/**
 * 
 */
package fr.n7.stl.block.ast;

import java.util.List;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

import fr.n7.stl.block.ast.impl.MethodImpl;
import fr.n7.stl.block.ast.impl.ToDeclaredException;

/**
 * Represents an Instruction node in the Abstract Syntax Tree node for the Bloc language.
 * Declares the various semantics attributes for the node.
 * @author Marc Pantel
 *
 */
public interface Instruction {
	
	/**
	 * Synthesized Semantics attribute to check that an instruction if well typed.
	 * @return Synthesized True if the instruction is well typed, False if not.
	 */
	public boolean checkType();
	
	
	/**
	 * Return the instruction if it is well declared.
	 * @return the instruction if it is well declared.
	 */
	public Instruction toDeclared(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes, Classe classeMere, MethodImpl methodeMere, Block blocPere) throws ToDeclaredException;
	
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
