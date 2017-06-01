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

/**
 * Represents a ClasseInstance node in the Abstract Syntax Tree node for the Bloc language.
 * Declares the various semantics attributes for the node.
 *
 */
public abstract class AccessTools {
    
    public static class AppelOuAcces {
        
        private String nom;
        private LinkedList<Expression> arguments;
        
        public AppelOuAcces() {
            this.nom = null;
            this.arguments = null;
        }
        
        public AppelOuAcces(String _nom, LinkedList<Expression> _args) {
            this.nom = _nom;
            this.arguments = _args;
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
    
    /*public static Optional<Type> getType(Classe _classe, LinkedList<AppelOuAcces> _acces, boolean checkMethods, boolean checkAuth) {
        LinkedList<AppelOuAcces> history = _acces;
        
        Classe classe = _classe;
        AppelOuAcces elementAccede = history.get(0); //Tableau de taille > 0
        int depth = 0;
        
        boolean echec = false;
        Type obtainedType = null;
        
        while (depth < history.size() && !echec) {
            Optional<AttributImpl> attribut = classe.getAttribut(elementAccede.getNom());
            Optional<MethodImpl> methode = classe.getMethode(elementAccede.getNom());
            
            //Last argument.
            if (depth == history.size() - 1) {
                if (attribut.isPresent() && elementAccede.getArguments() == null) {
                    
                    if (attribut.get().getDroitAcces() != DroitAcces.PUBLIC && checkAuth) {
                        echec = true;
                        break;
                    }
                    
                    obtainedType = attribut.get().getType();
                }
                else if (methode.isPresent() && (!checkMethods || elementAccede.getArguments() != null)) {
                    
                    if (methode.get().getDroitAcces() != DroitAcces.PUBLIC && checkAuth) {
                        echec = true;
                        break;
                    }
                    
                    obtainedType = methode.get().getTypeRetour().isPresent() ? 
                                methode.get().getTypeRetour().get() : null;
                } else {
                    echec = true;
                }
            
            } else { //Browsing access history.
            
                if (attribut.isPresent() && elementAccede.getArguments() == null) {
                    
                    if (!(attribut.get().getType() instanceof ClasseTypeImpl) || (attribut.get().getDroitAcces() != DroitAcces.PUBLIC && checkAuth)) {
                        echec = true;
                        break;
                    }
                    
                    classe = ((ClasseTypeImpl) attribut.get().getType()).getClasse();
                    elementAccede = history.get(depth + 1);
                    
                } else if (methode.isPresent() && (!checkMethods || elementAccede.getArguments() != null)) {
                    
                    Optional<Type> retour = methode.get().getTypeRetour();
                    if (!retour.isPresent() || !(retour.get() instanceof ClasseTypeImpl) || (methode.get().getDroitAcces() != DroitAcces.PUBLIC && checkAuth)) {
                        echec = true;
                        break;
                    }
                    
                    classe = ((ClasseTypeImpl) retour.get()).getClasse();
                    elementAccede = history.get(depth + 1);
                } else {
                    echec = true;
                }
            
            }
            
            depth++;
        }
        
        if (echec)
            return Optional.empty();
        
        return Optional.of(obtainedType);
    }*/
}
