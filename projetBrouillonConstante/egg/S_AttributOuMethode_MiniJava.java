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
public class S_AttributOuMethode_MiniJava {
LEX_MiniJava scanner;
  S_AttributOuMethode_MiniJava() {
	}
  S_AttributOuMethode_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tds;
  boolean att_eval;
  LEX_MiniJava att_scanner;
  LinkedList<Argument> att_methode_arguments;
  Optional<Type> att_type;
  String att_nom;
  Block att_methode_corps;
  private void regle50() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	T_MiniJava x_4 = new T_MiniJava(scanner ) ;
	S_Parametres_MiniJava x_6 = new S_Parametres_MiniJava(scanner,att_eval) ;
	T_MiniJava x_7 = new T_MiniJava(scanner ) ;
	S_Bloc_MiniJava x_9 = new S_Bloc_MiniJava(scanner,att_eval) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_vide);
	x_3.analyser(LEX_MiniJava.token_identificateur);
	x_4.analyser(LEX_MiniJava.token_parenthese_ouvrante);
if  (att_eval)	  action_tds_50(x_3, x_6, x_9);
	x_6.analyser() ;
	x_7.analyser(LEX_MiniJava.token_parenthese_fermante);
if  (att_eval)	  action_inh_50(x_3, x_6, x_9);
	x_9.analyser() ;
if  (att_eval)	  action_ast_50(x_3, x_6, x_9);
  }
  private void regle49() throws Exception {

	//declaration
	S_Type_MiniJava x_4 = new S_Type_MiniJava(scanner,att_eval) ;
	T_MiniJava x_5 = new T_MiniJava(scanner ) ;
	S_SuiteAttributOuMethode_MiniJava x_6 = new S_SuiteAttributOuMethode_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_49(x_4, x_5, x_6);
if  (att_eval)	  action_tds_49(x_4, x_5, x_6);
if  (att_eval)	  action_inh_49(x_4, x_5, x_6);
	x_4.analyser() ;
	x_5.analyser(LEX_MiniJava.token_identificateur);
	x_6.analyser() ;
if  (att_eval)	  action_ast_49(x_4, x_5, x_6);
  }
private void action_ast_49(S_Type_MiniJava x_4, T_MiniJava x_5, S_SuiteAttributOuMethode_MiniJava x_6) throws Exception {
try {
// instructions
this.att_type=Optional.of(x_4.att_ast);
this.att_nom=x_5.att_txt;
this.att_methode_corps=x_6.att_methode_corps;
this.att_methode_arguments=x_6.att_methode_arguments;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","AttributOuMethode -> #tds #inh Type identificateur SuiteAttributOuMethode #ast ;", e });
}
  }
private void action_tds_49(S_Type_MiniJava x_4, T_MiniJava x_5, S_SuiteAttributOuMethode_MiniJava x_6) throws Exception {
try {
// instructions
x_4.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","AttributOuMethode -> #tds #inh Type identificateur SuiteAttributOuMethode #ast ;", e });
}
  }
private void action_ast_50(T_MiniJava x_3, S_Parametres_MiniJava x_6, S_Bloc_MiniJava x_9) throws Exception {
try {
// instructions
this.att_type=Optional.empty();
this.att_nom=x_3.att_txt;
this.att_methode_corps=x_9.att_ast;
this.att_methode_arguments=x_6.att_args;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","AttributOuMethode -> vide identificateur parenthese_ouvrante #tds Parametres parenthese_fermante #inh Bloc #ast ;", e });
}
  }
private void action_auto_inh_49(S_Type_MiniJava x_4, T_MiniJava x_5, S_SuiteAttributOuMethode_MiniJava x_6) throws Exception {
try {
// instructions
x_6.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","AttributOuMethode -> #tds #inh Type identificateur SuiteAttributOuMethode #ast ;", e });
}
  }
private void action_inh_49(S_Type_MiniJava x_4, T_MiniJava x_5, S_SuiteAttributOuMethode_MiniJava x_6) throws Exception {
try {
// instructions
x_4.att_factory= new BlockFactoryImpl();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#inh","AttributOuMethode -> #tds #inh Type identificateur SuiteAttributOuMethode #ast ;", e });
}
  }
private void action_inh_50(T_MiniJava x_3, S_Parametres_MiniJava x_6, S_Bloc_MiniJava x_9) throws Exception {
try {
// instructions
x_9.att_factory= new BlockFactoryImpl();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#inh","AttributOuMethode -> vide identificateur parenthese_ouvrante #tds Parametres parenthese_fermante #inh Bloc #ast ;", e });
}
  }
private void action_tds_50(T_MiniJava x_3, S_Parametres_MiniJava x_6, S_Bloc_MiniJava x_9) throws Exception {
try {
// instructions
x_6.att_tds=this.att_tds;
x_9.att_tds= new SymbolTable(this.att_tds);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","AttributOuMethode -> vide identificateur parenthese_ouvrante #tds Parametres parenthese_fermante #inh Bloc #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_type_bool : // 82
        regle49 () ;
      break ;
      case LEX_MiniJava.token_type_int : // 81
        regle49 () ;
      break ;
      case LEX_MiniJava.token_type_char : // 84
        regle49 () ;
      break ;
      case LEX_MiniJava.token_type_float : // 83
        regle49 () ;
      break ;
      case LEX_MiniJava.token_type_String : // 85
        regle49 () ;
      break ;
      case LEX_MiniJava.token_identificateur_type : // 104
        regle49 () ;
      break ;
      case LEX_MiniJava.token_vide : // 86
        regle50 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
