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
	protected List<Expression> param_appels; //param appels constructeur.
	protected HashMap<AttributImpl, Integer> offsets; //offsets.
	protected int memAllouee_att, memAllouee_params, offset;
	
	public ClasseInstanceImpl(Classe _classe, List<Expression> appel_constructeur) {
		this.classe = _classe;
		this.appel = this.classe.getConstructeur(appel_constructeur).isPresent() ?
				this.classe.getConstructeur(appel_constructeur).get() : null;
		
		this.param_appels = appel_constructeur;
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
		this.offset = _offset;
		int local = _offset;
		//Allocation des attributs de classe.
		for (AttributImpl _att : this.classe.getAttributs()) {
			this.offsets.put(_att, local);
			local += _att.allocateMemory(_register, local);
		}
		
		this.memAllouee_att = local - _offset;
		
		//Allocation des paramètres du constructeur.
		for (Expression _param : param_appels) {
			local += _param.getType().length();
		}
		
		this.memAllouee_params = local - this.memAllouee_att;
		
		//Allocation de l'appel du constructeur.
		appel.allocateMemory(Register.LB, 3 + this.memAllouee_att);
		
		
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
		//On push les paramètres du constructeur.
		for (Expression _param : param_appels) {
			res.append(_param.getCode(_factory));
		}
		
		res.add( _factory.createCall(appel.getLabel(), this.offset) );
		
		Fragment res_constr = _factory.createFragment();
		res_constr.append(appel.getCode(_factory, memAllouee_params - 1, this.memAllouee_att));
		res_constr.addPrefix(appel.getLabel() + ":");
		res_constr.addComment("Appel du constructeur");
		
		res.append(res_constr);
		
		return res;
	}

}
