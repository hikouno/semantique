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
public class S_Interface_MiniJava {
LEX_MiniJava scanner;
  S_Interface_MiniJava() {
	}
  S_Interface_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tds;
  boolean att_eval;
  Interface att_ast;
  LEX_MiniJava att_scanner;
  LinkedList<ConstantDeclaration> att_constantes;
  private void regle3() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	S_Genericite_MiniJava x_4 = new S_Genericite_MiniJava(scanner,att_eval) ;
	S_HeritageInterface_MiniJava x_5 = new S_HeritageInterface_MiniJava(scanner,att_eval) ;
	T_MiniJava x_6 = new T_MiniJava(scanner ) ;
	S_ElementsInterface_MiniJava x_8 = new S_ElementsInterface_MiniJava(scanner,att_eval) ;
	T_MiniJava x_10 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_interface);
	x_3.analyser(LEX_MiniJava.token_identificateur_type);
	x_4.analyser() ;
	x_5.analyser() ;
	x_6.analyser(LEX_MiniJava.token_accolade_ouvrante);
if  (att_eval)	  action_ast_inh_3(x_3, x_4, x_5, x_8);
	x_8.analyser() ;
if  (att_eval)	  action_ast_3(x_3, x_4, x_5, x_8);
	x_10.analyser(LEX_MiniJava.token_accolade_fermante);
  }
private void action_ast_inh_3(T_MiniJava x_3, S_Genericite_MiniJava x_4, S_HeritageInterface_MiniJava x_5, S_ElementsInterface_MiniJava x_8) throws Exception {
try {
// locales
ProgramFactoryImpl loc_prg;
Interface loc_interface;
// instructions
loc_prg= new ProgramFactoryImpl();
loc_interface=loc_prg.createInterface(x_3.att_txt);
this.att_ast=loc_interface;
x_8.att_tds=this.att_tds;
x_8.att_interface_mere=loc_interface;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast_inh","Interface -> interface identificateur_type Genericite HeritageInterface accolade_ouvrante #ast_inh ElementsInterface #ast accolade_fermante ;", e });
}
  }
private void action_ast_3(T_MiniJava x_3, S_Genericite_MiniJava x_4, S_HeritageInterface_MiniJava x_5, S_ElementsInterface_MiniJava x_8) throws Exception {
try {
// instructions
this.att_constantes=x_8.att_constantes;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Interface -> interface identificateur_type Genericite HeritageInterface accolade_ouvrante #ast_inh ElementsInterface #ast accolade_fermante ;", e });
}
  }
  public void analyser () throws Exception {
    regle3 () ;
  }
  }
