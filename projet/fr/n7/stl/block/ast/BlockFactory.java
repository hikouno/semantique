/**
 * 
 */
package fr.n7.stl.block.ast;

/**
 * Combines the various factories for the Bloc language.
 * @author Marc Pantel
 *
 */
public interface BlockFactory extends ExpressionFactory, InstructionFactory, TypeFactory {
    
    /**
	 * Create an Abstract Syntax Tree node for the ClasseDeclaration type.
	 * @return Abstract Syntax Tree node for the ClasseDeclaration type.
	 */
	public ClasseDeclaration createClasseDeclaration(Classe classe);
    
    
}
