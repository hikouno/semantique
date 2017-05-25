/**
 * 
 */
package fr.n7.stl.block.ast;

import java.util.List;
import java.util.LinkedList;
import java.util.Optional;

import fr.n7.stl.block.ast.impl.Constructeur;
import fr.n7.stl.block.ast.impl.AttributImpl;
import fr.n7.stl.block.ast.impl.MethodImpl;
import fr.n7.stl.block.ast.impl.ScopeCheckResult;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Represents a Block node in the Abstract Syntax Tree node for the Bloc language.
 * Declares the various semantics attributes for the node.
 * 
 * A block contains declarations. It is thus a Scope even if a separate SymbolTable is used in
 * the attributed semantics in order to manage declarations.
 * @author Marc Pantel
 *
 */
public interface Classe {
	
	/**
	 * Ajoute un constructeur à la classe.
	 * @param constructeur Constructeur à ajouter.
	 */
	public boolean ajouterConstructeur(Constructeur constructeur);
	
	/**
	 * Ajoute un attribut à la classe.
	 * @param attribut Attribut à ajouter.
	 */
	public boolean ajouterAttribut(AttributImpl attribut);
	
	/**
	 * Ajoute une méthode à la classe.
	 * @param method Méthode à ajouter.
	 */
	public boolean ajouterMethode(MethodImpl method);
	
	/**
	 * Renvoie le nom de la classe.
	 * @return Le nom de la classe.
	 */
	public String getNom();
	
	/**
	 * Renvoie les constructeurs de la classe.
	 * @return Les constructeurs de la classe.
	 */
	public LinkedList<Constructeur> getConstructeurs();
	
	/**
	 * Renvoie les attributs de la classe.
	 * @return Les attributs de la classe.
	 */
	public LinkedList<AttributImpl> getAttributs();
	
	/**
	 * Renvoie si il existe le constructeur correspondant aux arguments
	 * passés.
	 * @return Le résultat.
	 */
	public Optional<Constructeur> getConstructeur(List<Expression> args_passes);
	
	/**
	 * Renvoie si il existe l'attribut de la classe associé au nom.
	 * @return Le résultat.
	 */
	public Optional<AttributImpl> getAttribut(String nom);
	
	/**
	 * Renvoie si elle existe la méthode de la classe associée au nom.
	 * @return Le résultat.
	 */
	public Optional<MethodImpl> getMethode(String nom);
	
	/**
	 * Synthesized Semantics attribute to check if the AST is well formed according
	 * to the scope.
	 * @return The new AST with undeclared references replaces by actual ones.
	 */	
	public ScopeCheckResult scopeCheck(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes);
	
	/**
	 * Teste l'égalité de deux classes.
	 * @param _classe La classe à comparer.
	 * @return L'égalité des deux classes ou non.
	 */
	public boolean equalsTo(Classe _classe);
	
	
	/**
	 * Synthesized Semantics attribute to check that an instruction if well typed.
	 * @return Synthesized True if the instruction is well typed, False if not.
	 */	
	public boolean checkType();
	
	/**
	 * Inherited Semantics attribute to allocate memory for the variables declared in the instruction.
	 * Synthesized Semantics attribute that compute the size of the allocated memory. 
	 * @param _register Inherited Register associated to the address of the variables.
	 * @param _offset Inherited Current offset for the address of the variables.
	 * @return Synthesized Size of the memory allocated to the variables.
	 */	
	public int allocateMemory(Register _register, int _offset);
	
	/**
	 * Inherited Semantics attribute to build the nodes of the abstract syntax tree for the generated TAM code.
	 * Synthesized Semantics attribute that provide the generated TAM code.
	 * @param _factory Inherited Factory to build AST nodes for TAM code.
	 * @return Synthesized AST for the generated TAM code.
	 */
	public Fragment getCode(TAMFactory _factory);

}
