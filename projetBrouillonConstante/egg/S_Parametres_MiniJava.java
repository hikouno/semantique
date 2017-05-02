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
public class S_Parametres_MiniJava {
LEX_MiniJava scanner;
  S_Parametres_MiniJava() {
	}
  S_Parametres_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  LinkedList<Argument> att_args;
  SymbolTable att_tds;
  boolean att_eval;
  LEX_MiniJava att_scanner;
  private void regle54() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_args_54();
  }
  private void regle55() throws Exception {

	//declaration
	S_Parametre_MiniJava x_3 = new S_Parametre_MiniJava(scanner,att_eval) ;
	S_SuiteParametres_MiniJava x_4 = new S_SuiteParametres_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_tds_55(x_3, x_4);
	x_3.analyser() ;
	x_4.analyser() ;
if  (att_eval)	  action_args_55(x_3, x_4);
  }
private void action_args_55(S_Parametre_MiniJava x_3, S_SuiteParametres_MiniJava x_4) throws Exception {
try {
// locales
ProgramFactoryImpl loc_prg;
LinkedList<Argument> loc_liste_args;
// instructions
loc_prg= new ProgramFactoryImpl();
loc_liste_args= new LinkedList<Argument>();
loc_liste_args.add(loc_prg.createArgument(x_3.att_type, x_3.att_nom));
loc_liste_args.addAll(x_4.att_args);
this.att_args=loc_liste_args;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#args","Parametres -> #tds Parametre SuiteParametres #args ;", e });
}
  }
private void action_tds_55(S_Parametre_MiniJava x_3, S_SuiteParametres_MiniJava x_4) throws Exception {
try {
// instructions
x_3.att_tds=this.att_tds;
x_4.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","Parametres -> #tds Parametre SuiteParametres #args ;", e });
}
  }
private void action_args_54() throws Exception {
try {
// instructions
this.att_args= new LinkedList<Argument>();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#args","Parametres -> #args ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_parenthese_fermante : // 53
        regle54 () ;
      break ;
      case LEX_MiniJava.token_type_bool : // 82
        regle55 () ;
      break ;
      case LEX_MiniJava.token_type_int : // 81
        regle55 () ;
      break ;
      case LEX_MiniJava.token_type_char : // 84
        regle55 () ;
      break ;
      case LEX_MiniJava.token_type_float : // 83
        regle55 () ;
      break ;
      case LEX_MiniJava.token_type_String : // 85
        regle55 () ;
      break ;
      case LEX_MiniJava.token_identificateur_type : // 104
        regle55 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
