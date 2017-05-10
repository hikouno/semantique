/**
 * 
 */
package fr.n7.stl.block.ast;

import java.util.LinkedList;
import java.util.Optional;

import fr.n7.stl.block.ast.impl.InstanceUseImpl;
import fr.n7.stl.block.ast.impl.InstanceAccessImpl;
import fr.n7.stl.block.ast.impl.UndeclaredAccessImpl;
import fr.n7.stl.block.ast.impl.UndeclaredVariableUseImpl;

/**
 * Combines the various factories for the Bloc language.
 * @author Marc Pantel
 *
 */
public interface BlockFactory extends ExpressionFactory, InstructionFactory, TypeFactory {
    
    /**
	 * Create an Abstract Syntax Tree node for the InterfaceDeclaration type.
	 * @return Abstract Syntax Tree node for the InterfaceDeclaration type.
	 */
	public InterfaceDeclaration createInterfaceDeclaration(Interface interf);
    
    /**
	 * Create an Abstract Syntax Tree node for the ClasseDeclaration type.
	 * @return Abstract Syntax Tree node for the ClasseDeclaration type.
	 */
	public ClasseDeclaration createClasseDeclaration(Classe classe);
	
	/**
	 * Create an Abstract Syntax Tree node for the ClasseInstanceDeclaration type.
	 * @return Abstract Syntax Tree node for the ClasseInstanceDeclaration type.
	 */
	public ClasseInstanceDeclaration createClasseInstanceDeclaration(String nom, Type type, Expression value);
    
    /**
	 * Create an Abstract Syntax Tree node for the ClasseInstanceAllocation type.
	 * @return Abstract Syntax Tree node for the ClasseInstanceAllocation type.
	 */
    public Expression createClasseInstanceAllocation(Classe classe, LinkedList<Expression> args);
    
    /**
     * Create a node for an undeclared variable use expression in the Abstract Syntax Tree.
     * with resolving the reference with the Symbol Table.   
     * @return Abstract Syntax Tree node for the access to a variable.
     */
    public Expression createUndeclaredVariableUse(String _decName);
    
    /**
	 * Create a node for a variable use expression in the Abstract Syntax Tree.
	 * with resolving the reference with the Symbol Table.	 
	 * @param _declaration Abstract Syntax Tree node for the declaration of the variable.
	 * @return Abstract Syntax Tree node for the access to a variable.
	 */
	public Expression createInstanceUse(ClasseInstanceDeclaration _declaration);
	
	/**
	 * Create a node for a variable use expression in the Abstract Syntax Tree.
	 * with resolving the reference with the Symbol Table.	 
	 * @return Abstract Syntax Tree node for the access to a variable.
	 */
	public Optional<Expression> createInstanceAccess_use(InstanceUseImpl _use, String nom);
	
	/**
	 * Create a node for a variable use expression in the Abstract Syntax Tree.
	 * with resolving the reference with the Symbol Table.	 
	 * @return Abstract Syntax Tree node for the access to a variable.
	 */
	public Optional<Expression> createInstanceAccess_access(InstanceAccessImpl _access, String nom);
	
	/**
	* Create a node for a variable use expression in the Abstract Syntax Tree.
	* with resolving the reference with the Symbol Table.	 
	* @return Abstract Syntax Tree node for the access to a variable.
	*/
	public Expression createUndeclaredAccess_use(UndeclaredVariableUseImpl _use, String nom);

	/**
	* Create a node for a variable use expression in the Abstract Syntax Tree.
	* with resolving the reference with the Symbol Table.	 
	* @return Abstract Syntax Tree node for the access to a variable.
	*/
	public Expression createUndeclaredAccess_access(UndeclaredAccessImpl _access, String nom);
	
	/**
	 * Create a node for a return in the Abstract Syntax Tree 
	 * @return ReturnImpl instruction.
	 */
	public Instruction createReturn(Expression expr);
    
    
}
