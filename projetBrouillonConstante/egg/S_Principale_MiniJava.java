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
public class S_Principale_MiniJava {
LEX_MiniJava scanner;
  S_Principale_MiniJava() {
	}
  S_Principale_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tds;
  boolean att_eval;
  ClassePrincipale att_ast;
  LEX_MiniJava att_scanner;
  private void regle21() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	T_MiniJava x_4 = new T_MiniJava(scanner ) ;
	T_MiniJava x_5 = new T_MiniJava(scanner ) ;
	S_MethodePrincipale_MiniJava x_7 = new S_MethodePrincipale_MiniJava(scanner,att_eval) ;
	T_MiniJava x_8 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_public);
	x_3.analyser(LEX_MiniJava.token_classe);
	x_4.analyser(LEX_MiniJava.token_identificateur_type);
	x_5.analyser(LEX_MiniJava.token_accolade_ouvrante);
if  (att_eval)	  action_tds_21(x_4, x_7);
	x_7.analyser() ;
	x_8.analyser(LEX_MiniJava.token_accolade_fermante);
if  (att_eval)	  action_ast_21(x_4, x_7);
  }
private void action_tds_21(T_MiniJava x_4, S_MethodePrincipale_MiniJava x_7) throws Exception {
try {
// instructions
x_7.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","Principale -> public classe identificateur_type accolade_ouvrante #tds MethodePrincipale accolade_fermante #ast ;", e });
}
  }
private void action_ast_21(T_MiniJava x_4, S_MethodePrincipale_MiniJava x_7) throws Exception {
try {
// locales
ProgramFactoryImpl loc_prg;
// instructions
loc_prg= new ProgramFactoryImpl();
this.att_ast=loc_prg.createPrincipale(x_4.att_txt, x_7.att_bloc);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Principale -> public classe identificateur_type accolade_ouvrante #tds MethodePrincipale accolade_fermante #ast ;", e });
}
  }
  public void analyser () throws Exception {
    regle21 () ;
  }
  }
