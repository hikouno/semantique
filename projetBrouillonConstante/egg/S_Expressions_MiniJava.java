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
public class S_Expressions_MiniJava {
LEX_MiniJava scanner;
  S_Expressions_MiniJava() {
	}
  S_Expressions_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tds;
  boolean att_eval;
  LEX_MiniJava att_scanner;
  LinkedList<Expression> att_expressions;
  private void regle103() throws Exception {

	//declaration
	S_Expression_MiniJava x_3 = new S_Expression_MiniJava(scanner,att_eval) ;
	S_SuiteExpressions_MiniJava x_4 = new S_SuiteExpressions_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_tds_103(x_3, x_4);
	x_3.analyser() ;
	x_4.analyser() ;
if  (att_eval)	  action_ast_103(x_3, x_4);
  }
private void action_tds_103(S_Expression_MiniJava x_3, S_SuiteExpressions_MiniJava x_4) throws Exception {
try {
// instructions
x_3.att_factory= new BlockFactoryImpl();
x_3.att_tds=this.att_tds;
x_4.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","Expressions -> #tds Expression SuiteExpressions #ast ;", e });
}
  }
private void action_ast_103(S_Expression_MiniJava x_3, S_SuiteExpressions_MiniJava x_4) throws Exception {
try {
// instructions
x_4.att_expressions.addFirst(x_3.att_ast);
this.att_expressions=x_4.att_expressions;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Expressions -> #tds Expression SuiteExpressions #ast ;", e });
}
  }
  public void analyser () throws Exception {
    regle103 () ;
  }
  }
