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
public class S_Acces_MiniJava {
LEX_MiniJava scanner;
  S_Acces_MiniJava() {
	}
  S_Acces_MiniJava(LEX_MiniJava scanner, boolean eval) {
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
  Expression att_support;
  private void regle119() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_119();
  }
  private void regle120() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_Expression_MiniJava x_4 = new S_Expression_MiniJava(scanner,att_eval) ;
	T_MiniJava x_5 = new T_MiniJava(scanner ) ;
	S_Acces_MiniJava x_7 = new S_Acces_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_120(x_4, x_7);
	x_2.analyser(LEX_MiniJava.token_crochet_ouvrant);
if  (att_eval)	  action_tds_120(x_4, x_7);
	x_4.analyser() ;
	x_5.analyser(LEX_MiniJava.token_crochet_fermant);
if  (att_eval)	  action_inh_120(x_4, x_7);
	x_7.analyser() ;
if  (att_eval)	  action_ast_120(x_4, x_7);
  }
private void action_auto_inh_120(S_Expression_MiniJava x_4, S_Acces_MiniJava x_7) throws Exception {
try {
// instructions
x_4.att_factory=this.att_factory;
x_7.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Acces -> crochet_ouvrant #tds Expression crochet_fermant #inh Acces1 #ast ;", e });
}
  }
private void action_ast_119() throws Exception {
try {
// instructions
this.att_ast=this.att_support;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Acces -> #ast ;", e });
}
  }
private void action_tds_120(S_Expression_MiniJava x_4, S_Acces_MiniJava x_7) throws Exception {
try {
// instructions
x_7.att_tds=this.att_tds;
x_4.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","Acces -> crochet_ouvrant #tds Expression crochet_fermant #inh Acces1 #ast ;", e });
}
  }
private void action_ast_120(S_Expression_MiniJava x_4, S_Acces_MiniJava x_7) throws Exception {
try {
// instructions
this.att_ast=x_7.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Acces -> crochet_ouvrant #tds Expression crochet_fermant #inh Acces1 #ast ;", e });
}
  }
private void action_inh_120(S_Expression_MiniJava x_4, S_Acces_MiniJava x_7) throws Exception {
try {
// instructions
x_7.att_support=this.att_factory.createArrayAccess(this.att_support, x_4.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#inh","Acces -> crochet_ouvrant #tds Expression crochet_fermant #inh Acces1 #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_multiplication : // 67
        regle119 () ;
      break ;
      case LEX_MiniJava.token_division : // 68
        regle119 () ;
      break ;
      case LEX_MiniJava.token_modulo : // 69
        regle119 () ;
      break ;
      case LEX_MiniJava.token_et : // 72
        regle119 () ;
      break ;
      case LEX_MiniJava.token_addition : // 64
        regle119 () ;
      break ;
      case LEX_MiniJava.token_soustraction : // 65
        regle119 () ;
      break ;
      case LEX_MiniJava.token_ou : // 66
        regle119 () ;
      break ;
      case LEX_MiniJava.token_egalite : // 62
        regle119 () ;
      break ;
      case LEX_MiniJava.token_different : // 63
        regle119 () ;
      break ;
      case LEX_MiniJava.token_inferieur : // 54
        regle119 () ;
      break ;
      case LEX_MiniJava.token_inferieur_egal : // 56
        regle119 () ;
      break ;
      case LEX_MiniJava.token_superieur : // 55
        regle119 () ;
      break ;
      case LEX_MiniJava.token_superieur_egal : // 57
        regle119 () ;
      break ;
      case LEX_MiniJava.token_crochet_fermant : // 51
        regle119 () ;
      break ;
      case LEX_MiniJava.token_point_virgule : // 59
        regle119 () ;
      break ;
      case LEX_MiniJava.token_parenthese_fermante : // 53
        regle119 () ;
      break ;
      case LEX_MiniJava.token_virgule : // 60
        regle119 () ;
      break ;
      case LEX_MiniJava.token_crochet_ouvrant : // 50
        regle120 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
