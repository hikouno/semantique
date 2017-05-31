/**
 * 
 */
package fr.n7.stl.block.ast;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import fr.n7.stl.block.ast.impl.MethodImpl;
import fr.n7.stl.block.ast.impl.ToDeclaredException;

import fr.n7.stl.util.SymbolTable;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Represents a Block node in the Abstract Syntax Tree node for the Bloc language.
 * Declares the various semantics attributes for the node.
 * 
 * A block contains declarations. It is thus a Scope even if a separate SymbolTable is used in
 * the attributed semantics in order to manage declarations.
 * @author Marc Pantel
 *
 */
public interface Block { 
	
	/**
	 * Add an instruction at then end of a block.
	 * @param _instruction Instruction node in the AST added to the block node.
	 */
	public void add(Instruction _instruction);
	
	/**
	 * Add a sequence of instruction in a block.
	 * @param _instructions Sequence of instruction nodes in the AST added to the block node.
	 */
	public void addAll(Iterable<Instruction> _instructions);
	
	/**
	 * Synthesized Semantics attribute to check if the AST is well formed according
	 * to the scope.
	 * @return The new AST with undeclared references replaces by actual ones.
	 */	
	public Block toDeclared(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes, Classe classeMere, MethodImpl methodeMere) throws ToDeclaredException;
	
	public SymbolTable getPostScope();
	
	public void postScope_register(Declaration _declaration) throws ForbiddenDeclarationException;
	
	public boolean postScope_knows(String _name);
	
	public boolean postScope_contains(String _name);
	
	public Optional<Declaration> postScope_get(String _name);
	
	public boolean returnCheck();
	
	public boolean returnPresent();
	
	public boolean returnPresent_base();
	
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
