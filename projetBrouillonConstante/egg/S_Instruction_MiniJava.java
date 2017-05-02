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
public class S_Instruction_MiniJava {
LEX_MiniJava scanner;
  S_Instruction_MiniJava() {
	}
  S_Instruction_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  Instruction att_instr;
  LEX_MiniJava att_scanner;
  private void regle76() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	S_Expression_MiniJava x_5 = new S_Expression_MiniJava(scanner,att_eval) ;
	T_MiniJava x_6 = new T_MiniJava(scanner ) ;
	S_Bloc_MiniJava x_7 = new S_Bloc_MiniJava(scanner,att_eval) ;
	S_SuiteConditionnelle_MiniJava x_8 = new S_SuiteConditionnelle_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_76(x_5, x_7, x_8);
	x_2.analyser(LEX_MiniJava.token_si);
	x_3.analyser(LEX_MiniJava.token_parenthese_ouvrante);
if  (att_eval)	  action_tds_76(x_5, x_7, x_8);
	x_5.analyser() ;
	x_6.analyser(LEX_MiniJava.token_parenthese_fermante);
	x_7.analyser() ;
	x_8.analyser() ;
if  (att_eval)	  action_instr_76(x_5, x_7, x_8);
  }
  private void regle72() throws Exception {

	//declaration
	S_Affectable_MiniJava x_3 = new S_Affectable_MiniJava(scanner,att_eval) ;
	T_MiniJava x_4 = new T_MiniJava(scanner ) ;
	S_Expression_MiniJava x_5 = new S_Expression_MiniJava(scanner,att_eval) ;
	T_MiniJava x_7 = new T_MiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_72(x_3, x_5);
if  (att_eval)	  action_tds_72(x_3, x_5);
	x_3.analyser() ;
	x_4.analyser(LEX_MiniJava.token_affectation);
	x_5.analyser() ;
if  (att_eval)	  action_instr_72(x_3, x_5);
	x_7.analyser(LEX_MiniJava.token_point_virgule);
  }
  private void regle71() throws Exception {

	//declaration
	S_Type_MiniJava x_2 = new S_Type_MiniJava(scanner,att_eval) ;
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	T_MiniJava x_4 = new T_MiniJava(scanner ) ;
	S_Expression_MiniJava x_6 = new S_Expression_MiniJava(scanner,att_eval) ;
	T_MiniJava x_7 = new T_MiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_71(x_2, x_3, x_6);
	x_2.analyser() ;
	x_3.analyser(LEX_MiniJava.token_identificateur);
	x_4.analyser(LEX_MiniJava.token_affectation);
if  (att_eval)	  action_tds_71(x_2, x_3, x_6);
	x_6.analyser() ;
	x_7.analyser(LEX_MiniJava.token_point_virgule);
if  (att_eval)	  action_instr_71(x_2, x_3, x_6);
  }
  private void regle80() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_Expression_MiniJava x_3 = new S_Expression_MiniJava(scanner,att_eval) ;
	T_MiniJava x_4 = new T_MiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_80(x_3);
	x_2.analyser(LEX_MiniJava.token_afficher);
	x_3.analyser() ;
	x_4.analyser(LEX_MiniJava.token_point_virgule);
if  (att_eval)	  action_instr_80(x_3);
  }
  private void regle79() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	S_Expression_MiniJava x_5 = new S_Expression_MiniJava(scanner,att_eval) ;
	T_MiniJava x_6 = new T_MiniJava(scanner ) ;
	S_Bloc_MiniJava x_7 = new S_Bloc_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_79(x_5, x_7);
	x_2.analyser(LEX_MiniJava.token_tant_que);
	x_3.analyser(LEX_MiniJava.token_parenthese_ouvrante);
if  (att_eval)	  action_tds_79(x_5, x_7);
	x_5.analyser() ;
	x_6.analyser(LEX_MiniJava.token_parenthese_fermante);
	x_7.analyser() ;
if  (att_eval)	  action_instr_79(x_5, x_7);
  }
private void action_instr_79(S_Expression_MiniJava x_5, S_Bloc_MiniJava x_7) throws Exception {
try {
// instructions
this.att_instr=this.att_factory.createRepetition(x_5.att_ast, x_7.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#instr","Instruction -> tant_que parenthese_ouvrante #tds Expression parenthese_fermante Bloc #instr ;", e });
}
  }
private void action_instr_76(S_Expression_MiniJava x_5, S_Bloc_MiniJava x_7, S_SuiteConditionnelle_MiniJava x_8) throws Exception {
try {
// locales
Block loc_sc_bloc;
// instructions
loc_sc_bloc=x_8.att_suite_cond_bloc;
if ((loc_sc_bloc==null)){
this.att_instr=this.att_factory.createConditional(x_5.att_ast, x_7.att_ast);
}
else {
this.att_instr=this.att_factory.createConditional(x_5.att_ast, x_7.att_ast, loc_sc_bloc);
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#instr","Instruction -> si parenthese_ouvrante #tds Expression parenthese_fermante Bloc SuiteConditionnelle #instr ;", e });
}
  }
private void action_instr_72(S_Affectable_MiniJava x_3, S_Expression_MiniJava x_5) throws Exception {
try {
// instructions
this.att_instr=this.att_factory.createAssignment(x_3.att_ast, x_5.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#instr","Instruction -> #tds Affectable affectation Expression #instr point_virgule ;", e });
}
  }
private void action_tds_76(S_Expression_MiniJava x_5, S_Bloc_MiniJava x_7, S_SuiteConditionnelle_MiniJava x_8) throws Exception {
try {
// instructions
x_5.att_tds=this.att_tds;
x_8.att_tds=this.att_tds;
x_7.att_tds= new SymbolTable(this.att_tds);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","Instruction -> si parenthese_ouvrante #tds Expression parenthese_fermante Bloc SuiteConditionnelle #instr ;", e });
}
  }
private void action_instr_71(S_Type_MiniJava x_2, T_MiniJava x_3, S_Expression_MiniJava x_6) throws Exception {
try {
// locales
VariableDeclaration loc_d;
// instructions
if (this.att_tds.contains(x_3.att_txt)){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_already_defined, MiniJavaMessages.MiniJava_already_defined,new Object[]{""+x_3.att_txt});

}
else {
loc_d=this.att_factory.createVariableDeclaration(x_3.att_txt, x_2.att_ast, x_6.att_ast);
this.att_tds.register(loc_d);
this.att_instr=loc_d;
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#instr","Instruction -> Type identificateur affectation #tds Expression point_virgule #instr ;", e });
}
  }
private void action_auto_inh_76(S_Expression_MiniJava x_5, S_Bloc_MiniJava x_7, S_SuiteConditionnelle_MiniJava x_8) throws Exception {
try {
// instructions
x_5.att_factory=this.att_factory;
x_7.att_factory=this.att_factory;
x_8.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Instruction -> si parenthese_ouvrante #tds Expression parenthese_fermante Bloc SuiteConditionnelle #instr ;", e });
}
  }
private void action_instr_80(S_Expression_MiniJava x_3) throws Exception {
try {
// instructions
this.att_instr=this.att_factory.createPrinter(x_3.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#instr","Instruction -> afficher Expression point_virgule #instr ;", e });
}
  }
private void action_auto_inh_79(S_Expression_MiniJava x_5, S_Bloc_MiniJava x_7) throws Exception {
try {
// instructions
x_5.att_factory=this.att_factory;
x_7.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Instruction -> tant_que parenthese_ouvrante #tds Expression parenthese_fermante Bloc #instr ;", e });
}
  }
private void action_tds_79(S_Expression_MiniJava x_5, S_Bloc_MiniJava x_7) throws Exception {
try {
// instructions
x_5.att_tds=this.att_tds;
x_7.att_tds= new SymbolTable(this.att_tds);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","Instruction -> tant_que parenthese_ouvrante #tds Expression parenthese_fermante Bloc #instr ;", e });
}
  }
private void action_auto_inh_80(S_Expression_MiniJava x_3) throws Exception {
try {
// instructions
x_3.att_factory=this.att_factory;
x_3.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Instruction -> afficher Expression point_virgule #instr ;", e });
}
  }
private void action_auto_inh_71(S_Type_MiniJava x_2, T_MiniJava x_3, S_Expression_MiniJava x_6) throws Exception {
try {
// instructions
x_2.att_factory=this.att_factory;
x_6.att_factory=this.att_factory;
x_2.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Instruction -> Type identificateur affectation #tds Expression point_virgule #instr ;", e });
}
  }
private void action_tds_72(S_Affectable_MiniJava x_3, S_Expression_MiniJava x_5) throws Exception {
try {
// instructions
x_3.att_tds=this.att_tds;
x_5.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","Instruction -> #tds Affectable affectation Expression #instr point_virgule ;", e });
}
  }
private void action_tds_71(S_Type_MiniJava x_2, T_MiniJava x_3, S_Expression_MiniJava x_6) throws Exception {
try {
// instructions
x_6.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","Instruction -> Type identificateur affectation #tds Expression point_virgule #instr ;", e });
}
  }
private void action_auto_inh_72(S_Affectable_MiniJava x_3, S_Expression_MiniJava x_5) throws Exception {
try {
// instructions
x_3.att_factory=this.att_factory;
x_5.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Instruction -> #tds Affectable affectation Expression #instr point_virgule ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_type_bool : // 82
        regle71 () ;
      break ;
      case LEX_MiniJava.token_type_int : // 81
        regle71 () ;
      break ;
      case LEX_MiniJava.token_type_char : // 84
        regle71 () ;
      break ;
      case LEX_MiniJava.token_type_float : // 83
        regle71 () ;
      break ;
      case LEX_MiniJava.token_type_String : // 85
        regle71 () ;
      break ;
      case LEX_MiniJava.token_identificateur_type : // 104
        regle71 () ;
      break ;
      case LEX_MiniJava.token_parenthese_ouvrante : // 52
        regle72 () ;
      break ;
      case LEX_MiniJava.token_identificateur : // 103
        regle72 () ;
      break ;
      case LEX_MiniJava.token_si : // 75
        regle76 () ;
      break ;
      case LEX_MiniJava.token_tant_que : // 79
        regle79 () ;
      break ;
      case LEX_MiniJava.token_afficher : // 77
        regle80 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
