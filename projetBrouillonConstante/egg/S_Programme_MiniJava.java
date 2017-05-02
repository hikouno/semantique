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
public class S_Programme_MiniJava {
LEX_MiniJava scanner;
  S_Programme_MiniJava() {
	}
  S_Programme_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  boolean att_eval;
  Program att_ast;
  LEX_MiniJava att_scanner;
  private void regle0() throws Exception {

	//declaration
	S_Interfaces_MiniJava x_3 = new S_Interfaces_MiniJava(scanner,att_eval) ;
	S_Classes_MiniJava x_4 = new S_Classes_MiniJava(scanner,att_eval) ;
	S_Principale_MiniJava x_5 = new S_Principale_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_tds_0(x_3, x_4, x_5);
	x_3.analyser() ;
	x_4.analyser() ;
	x_5.analyser() ;
if  (att_eval)	  action_ast_0(x_3, x_4, x_5);
  }
private void action_tds_0(S_Interfaces_MiniJava x_3, S_Classes_MiniJava x_4, S_Principale_MiniJava x_5) throws Exception {
try {
// locales
SymbolTable loc_tds;
// instructions
loc_tds= new SymbolTable();
x_3.att_tds=loc_tds;
x_4.att_tds=loc_tds;
x_5.att_tds=loc_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","Programme -> #tds Interfaces Classes Principale #ast ;", e });
}
  }
private void action_ast_0(S_Interfaces_MiniJava x_3, S_Classes_MiniJava x_4, S_Principale_MiniJava x_5) throws Exception {
try {
// locales
ProgramFactoryImpl loc_prg;
// instructions
loc_prg= new ProgramFactoryImpl();
Collections.reverse(x_3.att_interfaces);
Collections.reverse(x_4.att_classes);
this.att_ast=loc_prg.createProgram(x_5.att_ast, x_3.att_interfaces, x_4.att_classes);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Programme -> #tds Interfaces Classes Principale #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_interface : // 90
        regle0 () ;
      break ;
      case LEX_MiniJava.token_classe : // 91
        regle0 () ;
      break ;
      case LEX_MiniJava.token_public : // 94
        regle0 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
