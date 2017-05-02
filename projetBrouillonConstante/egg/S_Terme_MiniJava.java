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
public class S_Terme_MiniJava {
LEX_MiniJava scanner;
  S_Terme_MiniJava() {
	}
  S_Terme_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  Expression att_ast;
  LEX_MiniJava att_scanner;
  private void regle96() throws Exception {

	//declaration
	S_Facteur_MiniJava x_3 = new S_Facteur_MiniJava(scanner,att_eval) ;
	S_SuiteFacteur_MiniJava x_5 = new S_SuiteFacteur_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_96(x_3, x_5);
if  (att_eval)	  action_tds_96(x_3, x_5);
	x_3.analyser() ;
if  (att_eval)	  action_ast_inh_96(x_3, x_5);
	x_5.analyser() ;
if  (att_eval)	  action_ast_syn_96(x_3, x_5);
  }
private void action_tds_96(S_Facteur_MiniJava x_3, S_SuiteFacteur_MiniJava x_5) throws Exception {
try {
// instructions
x_3.att_tds=this.att_tds;
x_5.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","Terme -> #tds Facteur #ast_inh SuiteFacteur #ast_syn ;", e });
}
  }
private void action_auto_inh_96(S_Facteur_MiniJava x_3, S_SuiteFacteur_MiniJava x_5) throws Exception {
try {
// instructions
x_3.att_factory=this.att_factory;
x_5.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Terme -> #tds Facteur #ast_inh SuiteFacteur #ast_syn ;", e });
}
  }
private void action_ast_syn_96(S_Facteur_MiniJava x_3, S_SuiteFacteur_MiniJava x_5) throws Exception {
try {
// instructions
this.att_ast=x_5.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast_syn","Terme -> #tds Facteur #ast_inh SuiteFacteur #ast_syn ;", e });
}
  }
private void action_ast_inh_96(S_Facteur_MiniJava x_3, S_SuiteFacteur_MiniJava x_5) throws Exception {
try {
// instructions
x_5.att_gauche=x_3.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast_inh","Terme -> #tds Facteur #ast_inh SuiteFacteur #ast_syn ;", e });
}
  }
  public void analyser () throws Exception {
    regle96 () ;
  }
  }
