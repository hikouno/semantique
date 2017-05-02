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
public class S_SuiteAttributOuMethode_MiniJava {
LEX_MiniJava scanner;
  S_SuiteAttributOuMethode_MiniJava() {
	}
  S_SuiteAttributOuMethode_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tds;
  boolean att_eval;
  LEX_MiniJava att_scanner;
  LinkedList<Argument> att_methode_arguments;
  Block att_methode_corps;
  private void regle52() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_Parametres_MiniJava x_4 = new S_Parametres_MiniJava(scanner,att_eval) ;
	T_MiniJava x_5 = new T_MiniJava(scanner ) ;
	S_Bloc_MiniJava x_7 = new S_Bloc_MiniJava(scanner,att_eval) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_parenthese_ouvrante);
if  (att_eval)	  action_tds_52(x_4, x_7);
	x_4.analyser() ;
	x_5.analyser(LEX_MiniJava.token_parenthese_fermante);
if  (att_eval)	  action_inh_52(x_4, x_7);
	x_7.analyser() ;
if  (att_eval)	  action_ast_52(x_4, x_7);
  }
  private void regle51() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_point_virgule);
if  (att_eval)	  action_ast_51();
  }
private void action_tds_52(S_Parametres_MiniJava x_4, S_Bloc_MiniJava x_7) throws Exception {
try {
// instructions
x_4.att_tds=this.att_tds;
x_7.att_tds= new SymbolTable(this.att_tds);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","SuiteAttributOuMethode -> parenthese_ouvrante #tds Parametres parenthese_fermante #inh Bloc #ast ;", e });
}
  }
private void action_inh_52(S_Parametres_MiniJava x_4, S_Bloc_MiniJava x_7) throws Exception {
try {
// instructions
x_7.att_factory= new BlockFactoryImpl();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#inh","SuiteAttributOuMethode -> parenthese_ouvrante #tds Parametres parenthese_fermante #inh Bloc #ast ;", e });
}
  }
private void action_ast_51() throws Exception {
try {
// instructions
this.att_methode_corps=null;
this.att_methode_arguments=null;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","SuiteAttributOuMethode -> point_virgule #ast ;", e });
}
  }
private void action_ast_52(S_Parametres_MiniJava x_4, S_Bloc_MiniJava x_7) throws Exception {
try {
// instructions
this.att_methode_corps=x_7.att_ast;
this.att_methode_arguments=x_4.att_args;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","SuiteAttributOuMethode -> parenthese_ouvrante #tds Parametres parenthese_fermante #inh Bloc #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_point_virgule : // 59
        regle51 () ;
      break ;
      case LEX_MiniJava.token_parenthese_ouvrante : // 52
        regle52 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
