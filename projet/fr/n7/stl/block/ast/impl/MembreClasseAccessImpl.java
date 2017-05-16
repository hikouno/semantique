/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.List;
import java.util.LinkedList;

import fr.n7.stl.block.ast.ClasseDeclaration;
import fr.n7.stl.block.ast.InterfaceDeclaration;

import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.impl.AccessTools.AppelOuAcces;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Represents a ClasseInstance node in the Abstract Syntax Tree node for the Bloc language.
 * Declares the various semantics attributes for the node.
 *
 */
public class MembreClasseAccessImpl implements Expression {
    
    public enum Identifier {THIS, SUPER};
    
    protected Identifier base;
    protected MembreClasseAccessImpl access;
    
    protected AppelOuAcces membreAccede;
    
    public MembreClasseAccessImpl(Identifier _base) {
        this.base = _base;
        this.access = null;
        
        this.membreAccede = new AppelOuAcces();
    }
    
    public MembreClasseAccessImpl(MembreClasseAccessImpl _access) {
        this.access = _access;
        this.base = null;
        
        this.membreAccede = new AppelOuAcces();
    }
    
    public void setNomAcces(String _nom) {
        this.membreAccede.setNom(_nom);
    }
    
    public boolean isNameDeclared() {
        return this.membreAccede.getNom() != null;
    }
    
    public void setArgumentsAcces(LinkedList<Expression> _args) {
        this.membreAccede.setArguments(_args);
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String text = (this.base != null) ? ((this.base == Identifier.THIS) ? "(???) this" : "(???) super") : access.toString();
        if (membreAccede.getNom() != null) text += "." + membreAccede.getNom();
        
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
	 * @see fr.n7.stl.block.ast.Expression#toDeclared()
	 */
	@Override
	public Expression toDeclared(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes) {
		return this;
	}
    
    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.Expression#getType()
     */
    @Override
    public Type getType() {
        throw new RuntimeException("MembreClasseAccessImpl getType non implémentée");
    }

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
     */
    @Override
    public Fragment getCode(TAMFactory _factory) {
        throw new RuntimeException("MembreClasseAccessImpl getCode non implémentée");
    }
}
