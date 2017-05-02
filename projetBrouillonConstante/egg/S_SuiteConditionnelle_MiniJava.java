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
public class S_SuiteConditionnelle_MiniJava {
LEX_MiniJava scanner;
  S_SuiteConditionnelle_MiniJava() {
	}
  S_SuiteConditionnelle_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  LEX_MiniJava att_scanner;
  Block att_suite_cond_bloc;
  private void regle77() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_suite_cond_bloc_77();
  }
  private void regle78() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_Bloc_MiniJava x_4 = new S_Bloc_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_78(x_4);
	x_2.analyser(LEX_MiniJava.token_sinon);
if  (att_eval)	  action_tds_78(x_4);
	x_4.analyser() ;
if  (att_eval)	  action_suite_cond_bloc_78(x_4);
  }
private void action_suite_cond_bloc_77() throws Exception {
try {
// instructions
this.att_suite_cond_bloc=null;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#suite_cond_bloc","SuiteConditionnelle -> #suite_cond_bloc ;", e });
}
  }
private void action_tds_78(S_Bloc_MiniJava x_4) throws Exception {
try {
// instructions
x_4.att_tds= new SymbolTable(this.att_tds);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","SuiteConditionnelle -> sinon #tds Bloc #suite_cond_bloc ;", e });
}
  }
private void action_auto_inh_78(S_Bloc_MiniJava x_4) throws Exception {
try {
// instructions
x_4.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","SuiteConditionnelle -> sinon #tds Bloc #suite_cond_bloc ;", e });
}
  }
private void action_suite_cond_bloc_78(S_Bloc_MiniJava x_4) throws Exception {
try {
// instructions
this.att_suite_cond_bloc=x_4.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#suite_cond_bloc","SuiteConditionnelle -> sinon #tds Bloc #suite_cond_bloc ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_type_bool : // 82
        regle77 () ;
      break ;
      case LEX_MiniJava.token_type_int : // 81
        regle77 () ;
      break ;
      case LEX_MiniJava.token_type_char : // 84
        regle77 () ;
      break ;
      case LEX_MiniJava.token_type_float : // 83
        regle77 () ;
      break ;
      case LEX_MiniJava.token_type_String : // 85
        regle77 () ;
      break ;
      case LEX_MiniJava.token_identificateur_type : // 104
        regle77 () ;
      break ;
      case LEX_MiniJava.token_parenthese_ouvrante : // 52
        regle77 () ;
      break ;
      case LEX_MiniJava.token_identificateur : // 103
        regle77 () ;
      break ;
      case LEX_MiniJava.token_si : // 75
        regle77 () ;
      break ;
      case LEX_MiniJava.token_tant_que : // 79
        regle77 () ;
      break ;
      case LEX_MiniJava.token_afficher : // 77
        regle77 () ;
      break ;
      case LEX_MiniJava.token_accolade_fermante : // 49
        regle77 () ;
      break ;
      case LEX_MiniJava.token_sinon : // 76
        regle78 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
