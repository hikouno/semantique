/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.List;
import java.util.LinkedList;

import fr.n7.stl.block.ast.ClasseDeclaration;
import fr.n7.stl.block.ast.InterfaceDeclaration;

import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.impl.AccessTools.AppelOuAcces;
import fr.n7.stl.block.ast.Block;


import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Represents a ClasseInstance node in the Abstract Syntax Tree node for the Bloc language.
 * Declares the various semantics attributes for the node.
 *
 */
public class MembreClasseAccessImpl implements Expression {
    
    protected String PREFIX = "";
    
    protected boolean verified = false;
    
    public enum Identifier {THIS, SUPER, ARGUMENT, UNKNOWN};
    
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
    
    public void setVerified(boolean _verified) {
        this.verified = _verified;
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
    
    public String getNomAcces() {
        return this.membreAccede.getNom();
    }
    
    public LinkedList<Expression> getArgumentsAcces() {
        return this.membreAccede.getArguments();
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String text = PREFIX;
        
        if (this.base != null) {
            text += ((!this.verified) ? "(???) " : "") + identifierToString(this.base);
        } else {
            text += access.toString() + ".";
        }
        
        if (membreAccede.getNom() != null) text += membreAccede.getNom();
        
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
    
    private String identifierToString(Identifier id) {
        if (id == Identifier.THIS) return "this.";
        else if (id == Identifier.SUPER) return "super.";
        else if (id == Identifier.ARGUMENT) return "[arg]";
        else return "";
    }
    
    /** Declare return Type and method access arguments. */
    public void declare(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes, Classe classeMere, MethodImpl methodeMere, Block blocPere) throws ToDeclaredException {
        
        //Déclaration des arguments.
        if (membreAccede.getArguments() != null) {
            
            LinkedList<Expression> nouv_expr = new LinkedList<Expression>();
            for (Expression expr : membreAccede.getArguments()) {
                nouv_expr.add( expr.toDeclared( interfaces, classes, classeMere, methodeMere, blocPere ) );
            }
        
            membreAccede.setArguments(nouv_expr);
        }
        
        //Déclaration du type.
        //if (type != null) {
        //   this.type = type.toDeclared(interfaces, classes, classeMere);
        //}
    }
    
    /* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#toDeclared()
	 */
	@Override
	public Expression toDeclared(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes, Classe classeMere, MethodImpl methodeMere, Block blocPere) throws ToDeclaredException {
		
        MembreClasseAccessImpl declared;
        
        if (this.base != null) {
            
            Identifier _base = this.base;
            String rootName = membreAccede.getNom();
        
            if (_base == Identifier.UNKNOWN) {
                //Can be a THIS (or a super ?) or a Parameter access.
                //As the prefix this. was not given, parameters are prioritized.
                if (knownInMethod(methodeMere, rootName)) {
                    _base = Identifier.ARGUMENT;
                } else if (knownInClass(classeMere, rootName)) { //Trying to find it as a class member or method.
                    _base = Identifier.THIS;
                } else {
                    throw new ToDeclaredException("\""+rootName+"\" n'est ni un paramètre de la méthode " + methodeMere.getNom() +
                                                    " ni un membre de la classe " + classeMere.getNom() + ".");
                }
            } else if (base == Identifier.THIS && !knownInClass(classeMere, rootName)) {
                throw new ToDeclaredException("\""+rootName+"\" n'est pas un membre de la classe " + classeMere.getNom() + ".");
            }
            
            declared = new MembreClasseAccessImpl(_base);
        } else {
            declared = new MembreClasseAccessImpl((MembreClasseAccessImpl) this.access.toDeclared(interfaces, classes, classeMere, methodeMere, blocPere));
        }
        
        
        declared.setNomAcces(this.getNomAcces());
        declared.setArgumentsAcces(this.getArgumentsAcces());
        
        declared.declare(interfaces, classes, classeMere, methodeMere, blocPere);
        declared.setVerified(true);
        
        return declared;
	}
    
    /** Renvoie true si nom est un nom d'attribut ou de méthode de la classe. */
    private boolean knownInClass(Classe classe, String nom) {
        return (classe.getAttribut(nom).isPresent() || classe.getMethode(nom).isPresent());
    }
    
    /** Renvoie true si nom est un nom d'argument de la méthode. */
    private boolean knownInMethod(MethodImpl methode, String nom) {
        LinkedList<Argument> _args = methode.getArguments();
        for (Argument _arg : _args) {
            if (_arg.getName().equals(nom))
                return true;
        }
        
        return false;
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
