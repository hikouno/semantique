package fr.n7.stl.block.ast.impl;

import java.util.List;

import fr.n7.stl.block.ast.ClasseDeclaration;
import fr.n7.stl.block.ast.InterfaceDeclaration;

import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.tam.ast.Fragment;

import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Constante;
import fr.n7.stl.block.ast.Block;


public class ConstanteImpl implements Constante {
		private Type type;
		private String nom;
		private Expression valeur;
		
		public ConstanteImpl(Type type, String nom, Expression valeur) {
			this.type = type;
			this.nom = nom;
			this.valeur = valeur;
		}
		
		public String getNom() { return this.nom ;}
		public Expression getValue() {return this.valeur;}
		
		@Override
		public String toString() {
			return "final static " + this.type + " " + this.nom + " = " + this.valeur + ";";
		}
		
		/* (non-Javadoc)
		 * @see fr.n7.stl.block.ast.Expression#toDeclared()
		 */
		@Override
		public Expression toDeclared(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes, Classe classeMere,  Block blocPere) throws ToDeclaredException {
			return (new ConstanteImpl(this.type.toDeclared(interfaces, classes, classeMere), this.nom, this.valeur.toDeclared(interfaces, classes, classeMere, blocPere) ));
		}
		
		/* (non-Javadoc)
		 * @see fr.n7.stl.block.ast.Block#getType()
		 */
		@Override
		public Type getType() {
			throw new RuntimeException("ClasseImpl getType à implémenter");
		}
		
		/* (non-Javadoc)
		 * @see fr.n7.stl.block.ast.Block#generateCode(fr.n7.stl.tam.ast.TAMFactory)
		 */
		@Override
		public Fragment getCode(TAMFactory _factory) {
			throw new RuntimeException("MethodImpl getCode à implémenter");
		}
	
	
}
	
	
