/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.List;
import java.util.LinkedList;
import java.util.Optional;

import fr.n7.stl.block.ast.ClasseDeclaration;
import fr.n7.stl.block.ast.InterfaceDeclaration;

import fr.n7.stl.block.ast.MembreClasse.DroitAcces;
import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.ClasseInstanceDeclaration;
import fr.n7.stl.block.ast.impl.AccessTools.AppelOuAcces;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Represents a ClasseInstance node in the Abstract Syntax Tree node for the Bloc language.
 * Declares the various semantics attributes for the node.
 *
 */
public class InstanceAccessImpl implements Expression {
    
    protected InstanceUseImpl use;
    protected InstanceAccessImpl access;
    
    protected AppelOuAcces membreAccede;
    protected Type type;
    
    public InstanceAccessImpl(InstanceUseImpl _use) {
        this.use = _use;
        this.access = null;
        
        this.membreAccede = new AppelOuAcces();
        this.type = null;
    }
    
    public InstanceAccessImpl(InstanceAccessImpl _access) {
        this.access = _access;
        this.use = null;
        
        this.membreAccede = new AppelOuAcces();
        this.type = null;
    }
    
    public ClasseInstanceDeclaration getDeclaration() {
        return (this.use != null) ? use.getDeclaration() : this.access.getDeclaration();
    }
    
    public Classe getClasse() {
        
        return (this.use != null) ? this.use.getDeclaration().getInstance().getClasse() :
                                    this.access.getClasse();
    }
    
    @SuppressWarnings("unchecked")
    public LinkedList<AppelOuAcces> getCallHistory() {
        
        LinkedList<AppelOuAcces> history = (this.use != null) ? new LinkedList<AppelOuAcces>() :
                            (LinkedList<AppelOuAcces>) this.access.getCallHistory().clone();
        
        history.add(membreAccede);
        return history;
    }
    
    public void setNomAcces(String _nom) {
        this.membreAccede.setNom(_nom);
    }
    
    public void setArgumentsAcces(LinkedList<Expression> _args) {
        this.membreAccede.setArguments(_args);
    }
    
    public String getNomAcces() {
        return this.membreAccede.getNom();
    }
    
    public LinkedList<Expression> getArgumentsAcces() {
        return this.membreAccede.getArguments();
    }
    
    /** Declare return Type & method access arguments. */
    private void declare(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes, Classe classeMere) throws ToDeclaredException {
        
        //Déclaration des arguments.
        if (membreAccede.getArguments() != null) {
            
            LinkedList<Expression> nouv_expr = new LinkedList<Expression>();
            for (Expression expr : membreAccede.getArguments()) {
                nouv_expr.add( expr.toDeclared( interfaces, classes, classeMere ) );
            }
        
            membreAccede.setArguments(nouv_expr);
        }
        
        //Déclaration du type.
         if (type != null) {
            this.type = type.toDeclared(interfaces, classes, classeMere);
        }
    }
    
    public boolean update(boolean fullCheck) {
        
        Optional<Type> _type = AccessTools.getType(this.getClasse(), 
                                                    this.getCallHistory(), 
                                                    fullCheck,
                                                    false);
        
        if (_type.isPresent()) {
            this.type = _type.get();
            return true;
        }
        
        return false;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String text = (this.use != null) ? use.toString() : access.toString();
        
        if (membreAccede.getNom() != null)
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
     * @see fr.n7.stl.block.ast.Expression#toDeclared()
     */
    @Override
    public Expression toDeclared(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes, Classe classeMere, Block blocPere) throws ToDeclaredException {
        
        InstanceAccessImpl declared = (this.use != null) ?
        new InstanceAccessImpl((InstanceUseImpl) this.use.toDeclared(interfaces, classes, classeMere, Block blocPere)) :
        new InstanceAccessImpl((InstanceAccessImpl) this.access.toDeclared(interfaces, classes, classeMere, , Block blocPere));
        
        declared.setNomAcces(this.getNomAcces());
        declared.setArgumentsAcces(this.getArgumentsAcces());
        
        declared.declare(interfaces, classes, classeMere);
        return declared;
    }
    
    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.Expression#getType()
     */
    @Override
    public Type getType() {
        return this.type;
    }

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
     */
    @Override
    public Fragment getCode(TAMFactory _factory) {
        throw new RuntimeException("InstanceUseImpl getCode à implémenter");
    }
}
