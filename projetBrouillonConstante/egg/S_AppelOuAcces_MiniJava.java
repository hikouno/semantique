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
public class S_AppelOuAcces_MiniJava {
LEX_MiniJava scanner;
  S_AppelOuAcces_MiniJava() {
	}
  S_AppelOuAcces_MiniJava(LEX_MiniJava scanner, boolean eval) {
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
  private void regle118() throws Exception {

	//declaration
	S_Acces_MiniJava x_3 = new S_Acces_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_118(x_3);
if  (att_eval)	  action_tds_118(x_3);
	x_3.analyser() ;
if  (att_eval)	  action_ast_118(x_3);
  }
private void action_ast_118(S_Acces_MiniJava x_3) throws Exception {
try {
// instructions
this.att_ast=x_3.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","AppelOuAcces -> #tds Acces #ast ;", e });
}
  }
private void action_tds_118(S_Acces_MiniJava x_3) throws Exception {
try {
// instructions
x_3.att_tds=this.att_tds;
x_3.att_support=this.att_support;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","AppelOuAcces -> #tds Acces #ast ;", e });
}
  }
private void action_auto_inh_118(S_Acces_MiniJava x_3) throws Exception {
try {
// instructions
x_3.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","AppelOuAcces -> #tds Acces #ast ;", e });
}
  }
  public void analyser () throws Exception {
    regle118 () ;
  }
  }
