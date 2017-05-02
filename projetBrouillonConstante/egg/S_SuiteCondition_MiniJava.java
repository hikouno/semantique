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
public class S_SuiteCondition_MiniJava {
LEX_MiniJava scanner;
  S_SuiteCondition_MiniJava() {
	}
  S_SuiteCondition_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  Expression att_ast;
  Expression att_gauche;
  LEX_MiniJava att_scanner;
  private void regle83() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_83();
  }
  private void regle82() throws Exception {

	//declaration
	S_Comparatif_MiniJava x_3 = new S_Comparatif_MiniJava(scanner,att_eval) ;
	S_Condition_MiniJava x_4 = new S_Condition_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_82(x_3, x_4);
if  (att_eval)	  action_tds_82(x_3, x_4);
	x_3.analyser() ;
	x_4.analyser() ;
if  (att_eval)	  action_ast_82(x_3, x_4);
  }
private void action_ast_82(S_Comparatif_MiniJava x_3, S_Condition_MiniJava x_4) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createBinaryExpression(this.att_gauche, x_3.att_bin_op, x_4.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","SuiteCondition -> #tds Comparatif Condition #ast ;", e });
}
  }
private void action_ast_83() throws Exception {
try {
// instructions
this.att_ast=this.att_gauche;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","SuiteCondition -> #ast ;", e });
}
  }
private void action_auto_inh_82(S_Comparatif_MiniJava x_3, S_Condition_MiniJava x_4) throws Exception {
try {
// instructions
x_4.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","SuiteCondition -> #tds Comparatif Condition #ast ;", e });
}
  }
private void action_tds_82(S_Comparatif_MiniJava x_3, S_Condition_MiniJava x_4) throws Exception {
try {
// instructions
x_4.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","SuiteCondition -> #tds Comparatif Condition #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_egalite : // 62
        regle82 () ;
      break ;
      case LEX_MiniJava.token_different : // 63
        regle82 () ;
      break ;
      case LEX_MiniJava.token_inferieur : // 54
        regle82 () ;
      break ;
      case LEX_MiniJava.token_inferieur_egal : // 56
        regle82 () ;
      break ;
      case LEX_MiniJava.token_superieur : // 55
        regle82 () ;
      break ;
      case LEX_MiniJava.token_superieur_egal : // 57
        regle82 () ;
      break ;
      case LEX_MiniJava.token_crochet_fermant : // 51
        regle83 () ;
      break ;
      case LEX_MiniJava.token_point_virgule : // 59
        regle83 () ;
      break ;
      case LEX_MiniJava.token_parenthese_fermante : // 53
        regle83 () ;
      break ;
      case LEX_MiniJava.token_virgule : // 60
        regle83 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
