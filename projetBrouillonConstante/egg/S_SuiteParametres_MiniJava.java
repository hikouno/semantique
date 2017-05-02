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
public class S_SuiteParametres_MiniJava {
LEX_MiniJava scanner;
  S_SuiteParametres_MiniJava() {
	}
  S_SuiteParametres_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  LinkedList<Argument> att_args;
  SymbolTable att_tds;
  boolean att_eval;
  LEX_MiniJava att_scanner;
  private void regle57() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_args_57();
  }
  private void regle58() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_Parametre_MiniJava x_4 = new S_Parametre_MiniJava(scanner,att_eval) ;
	S_SuiteParametres_MiniJava x_5 = new S_SuiteParametres_MiniJava(scanner,att_eval) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_virgule);
if  (att_eval)	  action_tds_58(x_4, x_5);
	x_4.analyser() ;
	x_5.analyser() ;
if  (att_eval)	  action_args_58(x_4, x_5);
  }
private void action_args_57() throws Exception {
try {
// instructions
this.att_args= new LinkedList<Argument>();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#args","SuiteParametres -> #args ;", e });
}
  }
private void action_args_58(S_Parametre_MiniJava x_4, S_SuiteParametres_MiniJava x_5) throws Exception {
try {
// locales
ProgramFactoryImpl loc_prg;
LinkedList<Argument> loc_liste_args;
// instructions
loc_prg= new ProgramFactoryImpl();
loc_liste_args= new LinkedList<Argument>();
loc_liste_args.add(loc_prg.createArgument(x_4.att_type, x_4.att_nom));
loc_liste_args.addAll(x_5.att_args);
this.att_args=loc_liste_args;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#args","SuiteParametres -> virgule #tds Parametre SuiteParametres1 #args ;", e });
}
  }
private void action_tds_58(S_Parametre_MiniJava x_4, S_SuiteParametres_MiniJava x_5) throws Exception {
try {
// instructions
x_4.att_tds=this.att_tds;
x_5.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","SuiteParametres -> virgule #tds Parametre SuiteParametres1 #args ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_parenthese_fermante : // 53
        regle57 () ;
      break ;
      case LEX_MiniJava.token_virgule : // 60
        regle58 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
