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
public class S_Parametre_MiniJava {
LEX_MiniJava scanner;
  S_Parametre_MiniJava() {
	}
  S_Parametre_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tds;
  boolean att_eval;
  LEX_MiniJava att_scanner;
  Type att_type;
  String att_nom;
  private void regle56() throws Exception {

	//declaration
	S_Type_MiniJava x_3 = new S_Type_MiniJava(scanner,att_eval) ;
	T_MiniJava x_4 = new T_MiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_tds_56(x_3, x_4);
	x_3.analyser() ;
	x_4.analyser(LEX_MiniJava.token_identificateur);
if  (att_eval)	  action_ast_56(x_3, x_4);
  }
private void action_tds_56(S_Type_MiniJava x_3, T_MiniJava x_4) throws Exception {
try {
// instructions
x_3.att_tds=this.att_tds;
x_3.att_factory= new BlockFactoryImpl();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","Parametre -> #tds Type identificateur #ast ;", e });
}
  }
private void action_ast_56(S_Type_MiniJava x_3, T_MiniJava x_4) throws Exception {
try {
// instructions
this.att_nom=x_4.att_txt;
this.att_type=x_3.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Parametre -> #tds Type identificateur #ast ;", e });
}
  }
  public void analyser () throws Exception {
    regle56 () ;
  }
  }
