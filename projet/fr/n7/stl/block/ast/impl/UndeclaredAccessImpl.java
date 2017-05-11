/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;

import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.Expression;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Represents a ClasseInstance node in the Abstract Syntax Tree node for the Bloc language.
 * Declares the various semantics attributes for the node.
 *
 */
public class UndeclaredAccessImpl implements Expression {
    
    private class AppelOuAcces {
        
        private String nom;
        private LinkedList<Expression> arguments;
        
        public AppelOuAcces() {
            this.nom = null;
            this.arguments = null;
        }
        
        public void setNom(String _nom) {
            this.nom = _nom;
        }
        
        public String getNom() {
            return nom;
        }
        
        public void setArguments(LinkedList<Expression> _args) {
            this.arguments = _args;
        }
        
        public LinkedList<Expression> getArguments() {
            return arguments;
        }
    }
    
    protected UndeclaredInstanceUseImpl use;
    protected UndeclaredAccessImpl access;
    
    protected AppelOuAcces membreAccede;
    
    public UndeclaredAccessImpl(UndeclaredInstanceUseImpl _use) {
        this.use = _use;
        this.access = null;
        
        this.membreAccede = new AppelOuAcces();
    }
    
    public UndeclaredAccessImpl(UndeclaredAccessImpl _access) {
        this.access = _access;
        this.use = null;
        
        this.membreAccede = new AppelOuAcces();
    }
    
    public void setNomAcces(String _nom) {
        this.membreAccede.setNom(_nom);
    }
    
    public void setArgumentsAcces(LinkedList<Expression> _args) {
        this.membreAccede.setArguments(_args);
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String text = (this.use != null) ? use.toString() : access.toString();
        text += "." + membreAccede.getNom();
        
        if (membreAccede.getArguments() != null) {
            text += "(";
            
            for (int i = 0; i < membreAccede.getArguments().size(); i++) {
                text += membreAccede.getArguments().get(i);
                text += (i < membreAccede.getArguments().size() - 1) ? ", " : "";
            }
            
            text += ")";
        }
        
        
        return text;
    }

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.Expression#getType()
     */
    @Override
    public Type getType() {
        throw new RuntimeException("UndeclaredAccessImpl getType ne devrait pas être appelé");
    }

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
     */
    @Override
    public Fragment getCode(TAMFactory _factory) {
        throw new RuntimeException("UndeclaredAccessImpl getCode ne devrait pas être appelé");
    }
}
