/**
 * 
 */
package fr.n7.stl.block.ast.impl;


/**
 * Représente le résultat du deuxième passage sur l'AST avec
 * la table des symboles complète.
 *
 */
public class ScopeCheckResult {
    
    
    protected boolean wasSuccessful; /** Was the check successful ? */
    protected String result; /** New AST or error text. */
    
    
    public ScopeCheckResult(boolean success, String result) {
        this.wasSuccessful = success;
        this.result = result;
    }
    
    public boolean wasSuccessful() {
        return this.wasSuccessful;
    }
    
    public String getResult() {
        return this.result;
    }
    
}
