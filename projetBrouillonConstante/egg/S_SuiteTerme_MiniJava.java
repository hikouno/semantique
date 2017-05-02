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
public class S_SuiteTerme_MiniJava {
LEX_MiniJava scanner;
  S_SuiteTerme_MiniJava() {
	}
  S_SuiteTerme_MiniJava(LEX_MiniJava scanner, boolean eval) {
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
  private void regle91() throws Exception {

	//declaration
	S_Additif_MiniJava x_2 = new S_Additif_MiniJava(scanner,att_eval) ;
	S_Terme_MiniJava x_4 = new S_Terme_MiniJava(scanner,att_eval) ;
	S_SuiteTerme_MiniJava x_6 = new S_SuiteTerme_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_91(x_2, x_4, x_6);
	x_2.analyser() ;
if  (att_eval)	  action_tds_91(x_2, x_4, x_6);
	x_4.analyser() ;
if  (att_eval)	  action_ast_inh_91(x_2, x_4, x_6);
	x_6.analyser() ;
if  (att_eval)	  action_ast_syn_91(x_2, x_4, x_6);
  }
  private void regle92() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_92();
  }
private void action_ast_inh_91(S_Additif_MiniJava x_2, S_Terme_MiniJava x_4, S_SuiteTerme_MiniJava x_6) throws Exception {
try {
// instructions
x_6.att_gauche=this.att_factory.createBinaryExpression(this.att_gauche, x_2.att_bin_op, x_4.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast_inh","SuiteTerme -> Additif #tds Terme #ast_inh SuiteTerme1 #ast_syn ;", e });
}
  }
private void action_ast_92() throws Exception {
try {
// instructions
this.att_ast=this.att_gauche;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","SuiteTerme -> #ast ;", e });
}
  }
private void action_auto_inh_91(S_Additif_MiniJava x_2, S_Terme_MiniJava x_4, S_SuiteTerme_MiniJava x_6) throws Exception {
try {
// instructions
x_4.att_factory=this.att_factory;
x_6.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","SuiteTerme -> Additif #tds Terme #ast_inh SuiteTerme1 #ast_syn ;", e });
}
  }
private void action_tds_91(S_Additif_MiniJava x_2, S_Terme_MiniJava x_4, S_SuiteTerme_MiniJava x_6) throws Exception {
try {
// instructions
x_6.att_tds=this.att_tds;
x_4.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","SuiteTerme -> Additif #tds Terme #ast_inh SuiteTerme1 #ast_syn ;", e });
}
  }
private void action_ast_syn_91(S_Additif_MiniJava x_2, S_Terme_MiniJava x_4, S_SuiteTerme_MiniJava x_6) throws Exception {
try {
// instructions
this.att_ast=x_6.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast_syn","SuiteTerme -> Additif #tds Terme #ast_inh SuiteTerme1 #ast_syn ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_addition : // 64
        regle91 () ;
      break ;
      case LEX_MiniJava.token_soustraction : // 65
        regle91 () ;
      break ;
      case LEX_MiniJava.token_ou : // 66
        regle91 () ;
      break ;
      case LEX_MiniJava.token_egalite : // 62
        regle92 () ;
      break ;
      case LEX_MiniJava.token_different : // 63
        regle92 () ;
      break ;
      case LEX_MiniJava.token_inferieur : // 54
        regle92 () ;
      break ;
      case LEX_MiniJava.token_inferieur_egal : // 56
        regle92 () ;
      break ;
      case LEX_MiniJava.token_superieur : // 55
        regle92 () ;
      break ;
      case LEX_MiniJava.token_superieur_egal : // 57
        regle92 () ;
      break ;
      case LEX_MiniJava.token_crochet_fermant : // 51
        regle92 () ;
      break ;
      case LEX_MiniJava.token_point_virgule : // 59
        regle92 () ;
      break ;
      case LEX_MiniJava.token_parenthese_fermante : // 53
        regle92 () ;
      break ;
      case LEX_MiniJava.token_virgule : // 60
        regle92 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
