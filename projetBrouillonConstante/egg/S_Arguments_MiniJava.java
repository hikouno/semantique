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
public class S_Arguments_MiniJava {
LEX_MiniJava scanner;
  S_Arguments_MiniJava() {
	}
  S_Arguments_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  LinkedList<Expression> att_args;
  SymbolTable att_tds;
  boolean att_eval;
  LEX_MiniJava att_scanner;
  private void regle111() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_parenthese_ouvrante);
	x_3.analyser(LEX_MiniJava.token_parenthese_fermante);
if  (att_eval)	  action_args_111();
  }
  private void regle112() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_Expressions_MiniJava x_4 = new S_Expressions_MiniJava(scanner,att_eval) ;
	T_MiniJava x_5 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_parenthese_ouvrante);
if  (att_eval)	  action_tds_112(x_4);
	x_4.analyser() ;
	x_5.analyser(LEX_MiniJava.token_parenthese_fermante);
if  (att_eval)	  action_args_112(x_4);
  }
private void action_tds_112(S_Expressions_MiniJava x_4) throws Exception {
try {
// instructions
x_4.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","Arguments -> parenthese_ouvrante #tds Expressions parenthese_fermante #args ;", e });
}
  }
private void action_args_111() throws Exception {
try {
// instructions
this.att_args= new LinkedList<Expression>();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#args","Arguments -> parenthese_ouvrante parenthese_fermante #args ;", e });
}
  }
private void action_args_112(S_Expressions_MiniJava x_4) throws Exception {
try {
// instructions
this.att_args=x_4.att_expressions;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#args","Arguments -> parenthese_ouvrante #tds Expressions parenthese_fermante #args ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_parenthese_ouvrante : // 52
        scanner.lit ( 2 ) ;
        switch ( scanner.fenetre[1].code ) {
          case LEX_MiniJava.token_parenthese_fermante : // 53
            regle111 () ;
          break ;
          case LEX_MiniJava.token_soustraction : // 65
            regle112 () ;
          break ;
          case LEX_MiniJava.token_negation : // 71
            regle112 () ;
          break ;
          case LEX_MiniJava.token_nouveau : // 78
            regle112 () ;
          break ;
          case LEX_MiniJava.token_entier : // 102
            regle112 () ;
          break ;
          case LEX_MiniJava.token_vrai : // 73
            regle112 () ;
          break ;
          case LEX_MiniJava.token_faux : // 74
            regle112 () ;
          break ;
          case LEX_MiniJava.token_identificateur : // 103
            regle112 () ;
          break ;
          default :
            	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[1].getNom()});
scanner.accepter_sucre(LEX_MiniJava.token_parenthese_ouvrante);
        }
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
