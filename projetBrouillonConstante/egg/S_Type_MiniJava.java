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
public class S_Type_MiniJava {
LEX_MiniJava scanner;
  S_Type_MiniJava() {
	}
  S_Type_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  Type att_ast;
  LEX_MiniJava att_scanner;
  private void regle60() throws Exception {

	//declaration
	S_TypeAtomique_MiniJava x_3 = new S_TypeAtomique_MiniJava(scanner,att_eval) ;
	S_SuiteTypeAtomique_MiniJava x_5 = new S_SuiteTypeAtomique_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_60(x_3, x_5);
if  (att_eval)	  action_tds_60(x_3, x_5);
	x_3.analyser() ;
if  (att_eval)	  action_calcul_prof_60(x_3, x_5);
	x_5.analyser() ;
if  (att_eval)	  action_ast_60(x_3, x_5);
  }
private void action_calcul_prof_60(S_TypeAtomique_MiniJava x_3, S_SuiteTypeAtomique_MiniJava x_5) throws Exception {
try {
// instructions
x_5.att_calcul_profondeur=0;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#calcul_prof","Type -> #tds TypeAtomique #calcul_prof SuiteTypeAtomique #ast ;", e });
}
  }
private void action_ast_60(S_TypeAtomique_MiniJava x_3, S_SuiteTypeAtomique_MiniJava x_5) throws Exception {
try {
// instructions
this.att_ast=x_3.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Type -> #tds TypeAtomique #calcul_prof SuiteTypeAtomique #ast ;", e });
}
  }
private void action_auto_inh_60(S_TypeAtomique_MiniJava x_3, S_SuiteTypeAtomique_MiniJava x_5) throws Exception {
try {
// instructions
x_3.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Type -> #tds TypeAtomique #calcul_prof SuiteTypeAtomique #ast ;", e });
}
  }
private void action_tds_60(S_TypeAtomique_MiniJava x_3, S_SuiteTypeAtomique_MiniJava x_5) throws Exception {
try {
// instructions
x_3.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","Type -> #tds TypeAtomique #calcul_prof SuiteTypeAtomique #ast ;", e });
}
  }
  public void analyser () throws Exception {
    regle60 () ;
  }
  }