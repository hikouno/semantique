/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;
import java.util.Optional;

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
    
    @SuppressWarnings("unchecked")
    public LinkedList<AppelOuAcces> getCallHistory(AppelOuAcces _acces) {
        
        LinkedList<AppelOuAcces> history = (this.use != null) ? new LinkedList<AppelOuAcces>() :
                            (LinkedList<AppelOuAcces>) (this.access.getCallHistory().clone());
        
        history.add(_acces);
        return history;
    }
    
    public void setNomAcces(String _nom) {
        this.membreAccede.setNom(_nom);
    }
    
    public void setArgumentsAcces(LinkedList<Expression> _args) {
        this.membreAccede.setArguments(_args);
    }
    
    public boolean update() {
        LinkedList<AppelOuAcces> history = this.getCallHistory();
        
        Classe classe = this.getClasse();
        String elementAccede = history.get(0).getNom(); //Tableau de taille > 0
        int depth = 0;
        
        
        while (depth < history.size()) {
            Optional<AttributImpl> attribut = classe.getAttribut(elementAccede);
            Optional<MethodImpl> methode = classe.getMethode(elementAccede);
            
            //Last argument.
            if (depth == history.size() - 1) {
                if (attribut.isPresent()) {
                    
                    if (attribut.get().getDroitAcces() != DroitAcces.PUBLIC)
                        return false;
                    
                    this.type = attribut.get().getType();
                }
                else if (methode.isPresent()) {
                    
                    if (methode.get().getDroitAcces() != DroitAcces.PUBLIC)
                        return false;
                    
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
                    elementAccede = history.get(depth + 1).getNom();
                    
                } else if (methode.isPresent()) {
                    
                    Optional<Type> retour = methode.get().getTypeRetour();
                    if (!retour.isPresent() || !(retour.get() instanceof ClasseTypeImpl) || methode.get().getDroitAcces() != DroitAcces.PUBLIC)
                        return false;
                    
                    classe = ((ClasseTypeImpl) retour.get()).getClasse();
                    elementAccede = history.get(depth + 1).getNom();
                } else {
                    return false;
                }
            
            }
            
            depth++;
        }
        
        return true;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return (this.use != null) ? (use.toString() + "." + membreAccede.getNom()) : (access.toString() + "." + membreAccede.getNom());
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
