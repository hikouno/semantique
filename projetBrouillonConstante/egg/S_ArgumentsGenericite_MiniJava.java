package egg;
import java.util.*;
import fr.n7.stl.block.ast.*;
import fr.n7.stl.block.ast.impl.*;
import fr.n7.stl.util.*;
import fr.n7.stl.block.ast.MembreClasse.DroitAcces;
import mg.egg.eggc.runtime.libjava.lex.*;
import mg.egg.eggc.runtime.libjava.*;
import mg.egg.eggc.runtime.libjava.messages.*;
import mg.egg.eggc.runtime.libjava.problem.IProblem;
import java.util.Vector;
public class S_ArgumentsGenericite_MiniJava {
LEX_MiniJava scanner;
  S_ArgumentsGenericite_MiniJava() {
	}
  S_ArgumentsGenericite_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  boolean att_eval;
  LEX_MiniJava att_scanner;
  private void regle36() throws Exception {

	//declaration
	S_ArgumentGenericite_MiniJava x_2 = new S_ArgumentGenericite_MiniJava(scanner,att_eval) ;
	S_SuiteArgumentsGenericite_MiniJava x_3 = new S_SuiteArgumentsGenericite_MiniJava(scanner,att_eval) ;
	//appel
	x_2.analyser() ;
	x_3.analyser() ;
  }
  public void analyser () throws Exception {
    regle36 () ;
  }
  }