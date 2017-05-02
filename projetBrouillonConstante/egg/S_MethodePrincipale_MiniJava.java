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
public class S_MethodePrincipale_MiniJava {
LEX_MiniJava scanner;
  S_MethodePrincipale_MiniJava() {
	}
  S_MethodePrincipale_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  Block att_bloc;
  SymbolTable att_tds;
  boolean att_eval;
  LEX_MiniJava att_scanner;
  private void regle22() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	T_MiniJava x_4 = new T_MiniJava(scanner ) ;
	T_MiniJava x_5 = new T_MiniJava(scanner ) ;
	T_MiniJava x_6 = new T_MiniJava(scanner ) ;
	T_MiniJava x_7 = new T_MiniJava(scanner ) ;
	T_MiniJava x_8 = new T_MiniJava(scanner ) ;
	T_MiniJava x_9 = new T_MiniJava(scanner ) ;
	T_MiniJava x_10 = new T_MiniJava(scanner ) ;
	T_MiniJava x_11 = new T_MiniJava(scanner ) ;
	S_Bloc_MiniJava x_13 = new S_Bloc_MiniJava(scanner,att_eval) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_public);
	x_3.analyser(LEX_MiniJava.token_statique);
	x_4.analyser(LEX_MiniJava.token_vide);
	x_5.analyser(LEX_MiniJava.token_principale);
	x_6.analyser(LEX_MiniJava.token_parenthese_ouvrante);
	x_7.analyser(LEX_MiniJava.token_type_String);
	x_8.analyser(LEX_MiniJava.token_crochet_ouvrant);
	x_9.analyser(LEX_MiniJava.token_crochet_fermant);
	x_10.analyser(LEX_MiniJava.token_identificateur);
	x_11.analyser(LEX_MiniJava.token_parenthese_fermante);
if  (att_eval)	  action_tds_22(x_10, x_13);
	x_13.analyser() ;
if  (att_eval)	  action_ast_22(x_10, x_13);
  }
private void action_tds_22(T_MiniJava x_10, S_Bloc_MiniJava x_13) throws Exception {
try {
// instructions
x_13.att_tds= new SymbolTable(this.att_tds);
x_13.att_factory= new BlockFactoryImpl();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","MethodePrincipale -> public statique vide principale parenthese_ouvrante type_String crochet_ouvrant crochet_fermant identificateur parenthese_fermante #tds Bloc #ast ;", e });
}
  }
private void action_ast_22(T_MiniJava x_10, S_Bloc_MiniJava x_13) throws Exception {
try {
// instructions
this.att_bloc=x_13.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","MethodePrincipale -> public statique vide principale parenthese_ouvrante type_String crochet_ouvrant crochet_fermant identificateur parenthese_fermante #tds Bloc #ast ;", e });
}
  }
  public void analyser () throws Exception {
    regle22 () ;
  }
  }
