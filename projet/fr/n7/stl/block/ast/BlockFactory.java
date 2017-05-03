/**
 * 
 */
package fr.n7.stl.block.ast;

import java.util.LinkedList;

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
	public ClasseInstanceDeclaration createClasseInstanceDeclaration(Classe classe, String nom);
    
    /**
	 * Create an Abstract Syntax Tree node for the ClasseInstanceAllocation type.
	 * @return Abstract Syntax Tree node for the ClasseInstanceAllocation type.
	 */
    public Expression createClasseInstanceAllocation(Classe classe, LinkedList<Expression> args);
    
    
}
