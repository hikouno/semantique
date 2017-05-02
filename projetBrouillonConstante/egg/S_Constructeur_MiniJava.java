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
public class S_Constructeur_MiniJava {
LEX_MiniJava scanner;
  S_Constructeur_MiniJava() {
	}
  S_Constructeur_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  LinkedList<Argument> att_args;
  Block att_bloc;
  SymbolTable att_tds;
  boolean att_eval;
  LEX_MiniJava att_scanner;
  private void regle53() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	S_Parametres_MiniJava x_5 = new S_Parametres_MiniJava(scanner,att_eval) ;
	T_MiniJava x_6 = new T_MiniJava(scanner ) ;
	S_Bloc_MiniJava x_8 = new S_Bloc_MiniJava(scanner,att_eval) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_identificateur_type);
	x_3.analyser(LEX_MiniJava.token_parenthese_ouvrante);
if  (att_eval)	  action_tds_53(x_2, x_5, x_8);
	x_5.analyser() ;
	x_6.analyser(LEX_MiniJava.token_parenthese_fermante);
if  (att_eval)	  action_inh_53(x_2, x_5, x_8);
	x_8.analyser() ;
if  (att_eval)	  action_ast_53(x_2, x_5, x_8);
  }
private void action_inh_53(T_MiniJava x_2, S_Parametres_MiniJava x_5, S_Bloc_MiniJava x_8) throws Exception {
try {
// instructions
x_8.att_factory= new BlockFactoryImpl();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#inh","Constructeur -> identificateur_type parenthese_ouvrante #tds Parametres parenthese_fermante #inh Bloc #ast ;", e });
}
  }
private void action_tds_53(T_MiniJava x_2, S_Parametres_MiniJava x_5, S_Bloc_MiniJava x_8) throws Exception {
try {
// instructions
x_5.att_tds=this.att_tds;
x_8.att_tds= new SymbolTable(this.att_tds);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","Constructeur -> identificateur_type parenthese_ouvrante #tds Parametres parenthese_fermante #inh Bloc #ast ;", e });
}
  }
private void action_ast_53(T_MiniJava x_2, S_Parametres_MiniJava x_5, S_Bloc_MiniJava x_8) throws Exception {
try {
// instructions
this.att_args=x_5.att_args;
this.att_bloc=x_8.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Constructeur -> identificateur_type parenthese_ouvrante #tds Parametres parenthese_fermante #inh Bloc #ast ;", e });
}
  }
  public void analyser () throws Exception {
    regle53 () ;
  }
  }
