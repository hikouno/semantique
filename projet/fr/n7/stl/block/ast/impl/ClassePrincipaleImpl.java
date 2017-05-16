/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.ClassePrincipale;
import fr.n7.stl.block.ast.ClasseDeclaration;
import fr.n7.stl.block.ast.Interface;
import fr.n7.stl.block.ast.Block;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

import java.util.LinkedList;

/**
 * Une classe principale MiniJava
 *
 */
public class ClassePrincipaleImpl implements ClassePrincipale {
	
	
	protected String name;
	protected Block methodePrinc;
	
	
	/**
	 * Constructor for a MiniJava program.
	 */
	public ClassePrincipaleImpl(String name, Block methodePrinc) {
		this.name = name;
		this.methodePrinc = methodePrinc;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "public class "+this.name+" {\n" +
				"public static void main(String args[])\n" + 
					this.methodePrinc +
				"\n}";
	}

	@Override
	public ScopeCheckResult scopeCheck(LinkedList<Interface> interfaces, LinkedList<ClasseDeclaration> classes) {
		return this.methodePrinc.scopeCheck(interfaces, classes);
		
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#checkType()
	 */
	@Override
	public boolean checkType() {
		throw new RuntimeException("ClassePrincipaleImpl checkType à implémenter");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		throw new RuntimeException("ClassePrincipaleImpl allocateMemory à implémenter");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#generateCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new RuntimeException("ClassePrincipaleImpl getCode à implémenter");
	}

}
