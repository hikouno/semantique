/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;
import java.util.Optional;
import java.io.PrintWriter;

import fr.n7.stl.block.ast.MembreClasse.DroitAcces;
import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.ClasseInstanceDeclaration;

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
    
    protected String membreAccede;
    protected Type type;
    
    public InstanceAccessImpl(InstanceUseImpl _use) {
        this.use = _use;
        this.access = null;
        
        this.membreAccede = null;
        this.type = null;
    }
    
    public InstanceAccessImpl(InstanceAccessImpl _access) {
        this.access = _access;
        this.use = null;
        
        this.membreAccede = null;
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
    public LinkedList<String> getCallHistory() {
        
        LinkedList<String> history = (this.use != null) ? new LinkedList<String>() :
                            (LinkedList<String>) this.access.getCallHistory().clone();
        
        history.add(membreAccede);
        return history;
    }
    
    @SuppressWarnings("unchecked")
    public LinkedList<String> getCallHistory(String _nom) {
        
        LinkedList<String> history = (this.use != null) ? new LinkedList<String>() :
                            (LinkedList<String>) (this.access.getCallHistory().clone());
        
        history.add(_nom);
        return history;
    }
    
    public boolean setMembreAccede(String _nom) {
        
        LinkedList<String> history = this.getCallHistory(_nom);
        
        
        Classe classe = this.getClasse();
        String elementAccede = history.get(0); //Tableau de taille > 0
        int depth = 0;
        
        
        while (depth < history.size()) {
            Optional<AttributImpl> attribut = classe.getAttribut(elementAccede);
            Optional<MethodImpl> methode = classe.getMethode(elementAccede);
            
            //Last argument.
            if (depth == history.size() - 1) {
                if (attribut.isPresent()) {
                    
                    if (attribut.get().getDroitAcces() != DroitAcces.PUBLIC)
                        return false;
                    
                    this.membreAccede = _nom;
                    this.type = attribut.get().getType();
                }
                else if (methode.isPresent()) {
                    
                    if (methode.get().getDroitAcces() != DroitAcces.PUBLIC)
                        return false;
                    
                    this.membreAccede = _nom;
                    this.type = methode.get().getTypeRetour().isPresent() ? 
                                methode.get().getTypeRetour().get() : null;
                } else {
                    return false;
                }
            
            } else { //Browsing access history.
            
                if (attribut.isPresent()) {
                    
                    if (!(attribut.get().getType() instanceof ClasseTypeImpl) || attribut.get().getDroitAcces() != DroitAcces.PUBLIC)
                        return false;
                    
                    classe = ((ClasseTypeImpl) attribut.get().getType()).getClasse();
                    elementAccede = history.get(depth + 1);
                    
                } else if (methode.isPresent()) {
                    
                    Optional<Type> retour = methode.get().getTypeRetour();
                    if (!retour.isPresent() || !(retour.get() instanceof ClasseTypeImpl) || methode.get().getDroitAcces() != DroitAcces.PUBLIC)
                        return false;
                    
                    classe = ((ClasseTypeImpl) retour.get()).getClasse();
                    elementAccede = history.get(depth + 1);
                } else {
                    return false;
                }
            
            }
            
            depth++;
        }
        
        try {
            PrintWriter out = new PrintWriter("debug.txt");
            out.println(this.type.toString());
            out.close();
        } catch (Exception e) {
        }
        
        return true;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return (this.use != null) ? (use.toString() + "." + membreAccede) : (access.toString() + "." + membreAccede);
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
