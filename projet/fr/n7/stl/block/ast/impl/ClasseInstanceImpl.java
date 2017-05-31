/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.HashMap;
import java.util.List;

import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.ClasseInstance;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Represents a ClasseInstance node in the Abstract Syntax Tree node for the Bloc language.
 * Declares the various semantics attributes for the node.
 *
 */
public class ClasseInstanceImpl implements ClasseInstance {
	
	/** CLASSE QUI CONTIENT UNE LISTE DES VALEURS DES ARGUMENTS
	 * EFFECTIFS LIÉS À L'INSTANCE DE CLASSE. */
	
	protected Classe classe;
	protected Constructeur appel; //appel constructeur.
	protected HashMap<AttributImpl, Integer> offsets; //offsets
	protected int memAllouee;
	
	public ClasseInstanceImpl(Classe _classe, List<Expression> appel_constructeur) {
		this.classe = _classe;
		this.appel = this.classe.getConstructeur(appel_constructeur).isPresent() ?
				this.classe.getConstructeur(appel_constructeur).get() : null;
		
		this.offsets = new HashMap<AttributImpl, Integer>();
	}
	
	public int getLocalOffset(AttributImpl _att) {
		return this.offsets.get(_att);
	}
	
	/**
	 * Renvoie la classe associée.
	 * @return La classe associée.
	 */
	public Classe getClasse() {
		return this.classe;
	}
	
	/**
	 * Synthesized Semantics attribute to check that an instruction if well typed.
	 * @return Synthesized True if the instruction is well typed, False if not.
	 */	
	public boolean checkType() {
		throw new RuntimeException("ClasseInstanceImpl checkType à implémenter");
	}
	
	/**
	 * Inherited Semantics attribute to allocate memory for the variables declared in the instruction.
	 * Synthesized Semantics attribute that compute the size of the allocated memory. 
	 * @param _register Inherited Register associated to the address of the variables.
	 * @param _offset Inherited Current offset for the address of the variables.
	 * @return Synthesized Size of the memory allocated to the variables.
	 */	
	public int allocateMemory(Register _register, int _offset) {
		int local = _offset;
		for (AttributImpl _att : this.classe.getAttributs()) {
			this.offsets.put(_att, local);
			local += _att.allocateMemory(_register, local);
		}
		
		this.memAllouee = local - _offset;
		return local - _offset;
	}
	
	/**
	 * Inherited Semantics attribute to build the nodes of the abstract syntax tree for the generated TAM code.
	 * Synthesized Semantics attribute that provide the generated TAM code.
	 * @param _factory Inherited Factory to build AST nodes for TAM code.
	 * @return Synthesized AST for the generated TAM code.
	 */
	public Fragment getCode_allocation(TAMFactory _factory) {
		Fragment res = _factory.createFragment();
		res.add(_factory.createPush(memAllouee));
		//res.append(appel.getCode(_factory));
		
		return res;
	}

}
