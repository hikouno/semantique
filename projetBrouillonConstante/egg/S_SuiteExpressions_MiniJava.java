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
public class S_SuiteExpressions_MiniJava {
LEX_MiniJava scanner;
  S_SuiteExpressions_MiniJava() {
	}
  S_SuiteExpressions_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tds;
  boolean att_eval;
  LEX_MiniJava att_scanner;
  LinkedList<Expression> att_expressions;
  private void regle105() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_105();
  }
  private void regle104() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_Expression_MiniJava x_4 = new S_Expression_MiniJava(scanner,att_eval) ;
	S_SuiteExpressions_MiniJava x_5 = new S_SuiteExpressions_MiniJava(scanner,att_eval) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_virgule);
if  (att_eval)	  action_tds_104(x_4, x_5);
	x_4.analyser() ;
	x_5.analyser() ;
if  (att_eval)	  action_ast_104(x_4, x_5);
  }
private void action_ast_104(S_Expression_MiniJava x_4, S_SuiteExpressions_MiniJava x_5) throws Exception {
try {
// instructions
x_5.att_expressions.addFirst(x_4.att_ast);
this.att_expressions=x_5.att_expressions;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","SuiteExpressions -> virgule #tds Expression SuiteExpressions1 #ast ;", e });
}
  }
private void action_ast_105() throws Exception {
try {
// instructions
this.att_expressions= new LinkedList<Expression>();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","SuiteExpressions -> #ast ;", e });
}
  }
private void action_tds_104(S_Expression_MiniJava x_4, S_SuiteExpressions_MiniJava x_5) throws Exception {
try {
// instructions
x_4.att_factory= new BlockFactoryImpl();
x_4.att_tds=this.att_tds;
x_5.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","SuiteExpressions -> virgule #tds Expression SuiteExpressions1 #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_virgule : // 60
        regle104 () ;
      break ;
      case LEX_MiniJava.token_parenthese_fermante : // 53
        regle105 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
