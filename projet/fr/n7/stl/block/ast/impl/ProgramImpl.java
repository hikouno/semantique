/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.List;
import java.util.LinkedList;

import fr.n7.stl.block.ast.Program;
import fr.n7.stl.block.ast.ClassePrincipale;
import fr.n7.stl.block.ast.ClasseDeclaration;
import fr.n7.stl.block.ast.InterfaceDeclaration;
import fr.n7.stl.block.ast.Interface;
import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Un programme MiniJava.
 *
 */
public class ProgramImpl implements Program {
	
	/**
	 * Interfaces contained in the program.
	 */
	protected LinkedList<Interface> interfaces;
	
	/**
	 * Classes contained in the program.
	 */
	protected LinkedList<Classe> classes;
	
	/**
	 * Classe principale.
	 */
	protected ClassePrincipale principale;
	
	/**
	 * Constructor for a MiniJava program.
	 */
	public ProgramImpl(ClassePrincipale principale, LinkedList<Interface> interfaces, LinkedList<Classe> classes) {
		this.principale = principale;
		this.interfaces = interfaces;
		this.classes = classes;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String text = "";
		for (Interface inter : this.interfaces) {
			text += inter + "\n";
		}
		
		text += "\n";
		
		for (Classe classe : this.classes) {
			text += classe + "\n";
		}
		
		text += "\n";
		
		text += this.principale;
		return text;
	}
	
	@Override
	public ScopeCheckResult scopeCheck() {
		
		List<InterfaceDeclaration> interfacesDec = this.getInterfaceDecs();
		List<ClasseDeclaration> classesDec = this.getClasseDecs();
		
		/** Parcours des interfaces */
		for (Interface interf : this.interfaces) {
			//ScopeCheckResult res = interf.scopeCheck(interfacesDec, classesDec);
			
			//if (!res.wasSuccessful()) {
			//	return res;
			//}
			continue;
		}
		
		/** Parcours des classes */
		for (Classe classe : this.classes) {
			//ScopeCheckResult res = classe.scopeCheck(interfacesDec, classesDec);
			
			//if (!res.wasSuccessful()) {
			//	return res;
			//}
			continue;
		}
		
		/** Parcours de la méthode principale */
		ScopeCheckResult res = this.principale.scopeCheck(interfacesDec, classesDec);
		if (!res.wasSuccessful()) {
			return res;
		}
		
		return new ScopeCheckResult(true, this.toString());
	}
	
	private List<ClasseDeclaration> getClasseDecs() {
		
		LinkedList<ClasseDeclaration> classesDec = new LinkedList<ClasseDeclaration>();
		
		for(Classe classe : this.classes)
			classesDec.add(new ClasseDeclarationImpl(classe));
		
		return classesDec;
	}
	
	private List<InterfaceDeclaration> getInterfaceDecs() {
		LinkedList<InterfaceDeclaration> interfacesDec = new LinkedList<InterfaceDeclaration>();
		
		for(Interface interf : this.interfaces)
			interfacesDec.add(new InterfaceDeclarationImpl(interf));
		
		return interfacesDec;
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#checkType()
	 */
	@Override
	public boolean checkType() {
		throw new RuntimeException("ProgramImpl checkType à implémenter");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		throw new RuntimeException("ProgramImpl allocateMemory à implémenter");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#generateCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new RuntimeException("ProgramImpl getCode à implémenter");
	}

}
