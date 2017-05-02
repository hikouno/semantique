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
public class S_Bloc_MiniJava {
LEX_MiniJava scanner;
  S_Bloc_MiniJava() {
	}
  S_Bloc_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  Block att_ast;
  LEX_MiniJava att_scanner;
  private void regle59() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_Instructions_MiniJava x_4 = new S_Instructions_MiniJava(scanner,att_eval) ;
	T_MiniJava x_5 = new T_MiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_59(x_4);
	x_2.analyser(LEX_MiniJava.token_accolade_ouvrante);
if  (att_eval)	  action_ast_59(x_4);
	x_4.analyser() ;
	x_5.analyser(LEX_MiniJava.token_accolade_fermante);
  }
private void action_ast_59(S_Instructions_MiniJava x_4) throws Exception {
try {
// locales
Block loc_b;
// instructions
loc_b=this.att_factory.createBlock();
this.att_ast=loc_b;
x_4.att_blocParent=loc_b;
x_4.att_tds= new SymbolTable(this.att_tds);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Bloc -> accolade_ouvrante #ast Instructions accolade_fermante ;", e });
}
  }
private void action_auto_inh_59(S_Instructions_MiniJava x_4) throws Exception {
try {
// instructions
x_4.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Bloc -> accolade_ouvrante #ast Instructions accolade_fermante ;", e });
}
  }
  public void analyser () throws Exception {
    regle59 () ;
  }
  }
