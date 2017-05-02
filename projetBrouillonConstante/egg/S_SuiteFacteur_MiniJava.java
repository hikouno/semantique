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
public class S_SuiteFacteur_MiniJava {
LEX_MiniJava scanner;
  S_SuiteFacteur_MiniJava() {
	}
  S_SuiteFacteur_MiniJava(LEX_MiniJava scanner, boolean eval) {
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
  private void regle98() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_98();
  }
  private void regle97() throws Exception {

	//declaration
	S_Multiplicatif_MiniJava x_2 = new S_Multiplicatif_MiniJava(scanner,att_eval) ;
	S_Facteur_MiniJava x_4 = new S_Facteur_MiniJava(scanner,att_eval) ;
	S_SuiteFacteur_MiniJava x_6 = new S_SuiteFacteur_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_97(x_2, x_4, x_6);
	x_2.analyser() ;
if  (att_eval)	  action_tds_97(x_2, x_4, x_6);
	x_4.analyser() ;
if  (att_eval)	  action_ast_inh_97(x_2, x_4, x_6);
	x_6.analyser() ;
if  (att_eval)	  action_ast_syn_97(x_2, x_4, x_6);
  }
private void action_ast_syn_97(S_Multiplicatif_MiniJava x_2, S_Facteur_MiniJava x_4, S_SuiteFacteur_MiniJava x_6) throws Exception {
try {
// instructions
this.att_ast=x_6.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast_syn","SuiteFacteur -> Multiplicatif #tds Facteur #ast_inh SuiteFacteur1 #ast_syn ;", e });
}
  }
private void action_auto_inh_97(S_Multiplicatif_MiniJava x_2, S_Facteur_MiniJava x_4, S_SuiteFacteur_MiniJava x_6) throws Exception {
try {
// instructions
x_4.att_factory=this.att_factory;
x_6.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","SuiteFacteur -> Multiplicatif #tds Facteur #ast_inh SuiteFacteur1 #ast_syn ;", e });
}
  }
private void action_ast_inh_97(S_Multiplicatif_MiniJava x_2, S_Facteur_MiniJava x_4, S_SuiteFacteur_MiniJava x_6) throws Exception {
try {
// instructions
x_6.att_gauche=this.att_factory.createBinaryExpression(this.att_gauche, x_2.att_bin_op, x_4.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast_inh","SuiteFacteur -> Multiplicatif #tds Facteur #ast_inh SuiteFacteur1 #ast_syn ;", e });
}
  }
private void action_tds_97(S_Multiplicatif_MiniJava x_2, S_Facteur_MiniJava x_4, S_SuiteFacteur_MiniJava x_6) throws Exception {
try {
// instructions
x_4.att_tds=this.att_tds;
x_6.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","SuiteFacteur -> Multiplicatif #tds Facteur #ast_inh SuiteFacteur1 #ast_syn ;", e });
}
  }
private void action_ast_98() throws Exception {
try {
// instructions
this.att_ast=this.att_gauche;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","SuiteFacteur -> #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_multiplication : // 67
        regle97 () ;
      break ;
      case LEX_MiniJava.token_division : // 68
        regle97 () ;
      break ;
      case LEX_MiniJava.token_modulo : // 69
        regle97 () ;
      break ;
      case LEX_MiniJava.token_et : // 72
        regle97 () ;
      break ;
      case LEX_MiniJava.token_addition : // 64
        regle98 () ;
      break ;
      case LEX_MiniJava.token_soustraction : // 65
        regle98 () ;
      break ;
      case LEX_MiniJava.token_ou : // 66
        regle98 () ;
      break ;
      case LEX_MiniJava.token_egalite : // 62
        regle98 () ;
      break ;
      case LEX_MiniJava.token_different : // 63
        regle98 () ;
      break ;
      case LEX_MiniJava.token_inferieur : // 54
        regle98 () ;
      break ;
      case LEX_MiniJava.token_inferieur_egal : // 56
        regle98 () ;
      break ;
      case LEX_MiniJava.token_superieur : // 55
        regle98 () ;
      break ;
      case LEX_MiniJava.token_superieur_egal : // 57
        regle98 () ;
      break ;
      case LEX_MiniJava.token_crochet_fermant : // 51
        regle98 () ;
      break ;
      case LEX_MiniJava.token_point_virgule : // 59
        regle98 () ;
      break ;
      case LEX_MiniJava.token_parenthese_fermante : // 53
        regle98 () ;
      break ;
      case LEX_MiniJava.token_virgule : // 60
        regle98 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
