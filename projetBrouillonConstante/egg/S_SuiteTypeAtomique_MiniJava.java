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
public class S_SuiteTypeAtomique_MiniJava {
LEX_MiniJava scanner;
  S_SuiteTypeAtomique_MiniJava() {
	}
  S_SuiteTypeAtomique_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  Integer att_profondeur_remontee;
  boolean att_eval;
  Integer att_calcul_profondeur;
  LEX_MiniJava att_scanner;
  private void regle67() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	S_SuiteTypeAtomique_MiniJava x_5 = new S_SuiteTypeAtomique_MiniJava(scanner,att_eval) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_crochet_ouvrant);
	x_3.analyser(LEX_MiniJava.token_crochet_fermant);
if  (att_eval)	  action_calcul_prof_67(x_5);
	x_5.analyser() ;
if  (att_eval)	  action_remonte_prof_67(x_5);
  }
  private void regle68() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_remonte_prof_68();
  }
private void action_remonte_prof_67(S_SuiteTypeAtomique_MiniJava x_5) throws Exception {
try {
// instructions
this.att_profondeur_remontee=x_5.att_profondeur_remontee;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#remonte_prof","SuiteTypeAtomique -> crochet_ouvrant crochet_fermant #calcul_prof SuiteTypeAtomique1 #remonte_prof ;", e });
}
  }
private void action_remonte_prof_68() throws Exception {
try {
// instructions
this.att_profondeur_remontee=this.att_calcul_profondeur;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#remonte_prof","SuiteTypeAtomique -> #remonte_prof ;", e });
}
  }
private void action_calcul_prof_67(S_SuiteTypeAtomique_MiniJava x_5) throws Exception {
try {
// instructions
x_5.att_calcul_profondeur=(this.att_calcul_profondeur+1);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#calcul_prof","SuiteTypeAtomique -> crochet_ouvrant crochet_fermant #calcul_prof SuiteTypeAtomique1 #remonte_prof ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_crochet_ouvrant : // 50
        scanner.lit ( 2 ) ;
        switch ( scanner.fenetre[1].code ) {
          case LEX_MiniJava.token_crochet_fermant : // 51
            regle67 () ;
          break ;
          case LEX_MiniJava.token_soustraction : // 65
            regle68 () ;
          break ;
          case LEX_MiniJava.token_negation : // 71
            regle68 () ;
          break ;
          case LEX_MiniJava.token_nouveau : // 78
            regle68 () ;
          break ;
          case LEX_MiniJava.token_entier : // 102
            regle68 () ;
          break ;
          case LEX_MiniJava.token_vrai : // 73
            regle68 () ;
          break ;
          case LEX_MiniJava.token_faux : // 74
            regle68 () ;
          break ;
          case LEX_MiniJava.token_identificateur : // 103
            regle68 () ;
          break ;
          default :
            	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[1].getNom()});
scanner.accepter_sucre(LEX_MiniJava.token_crochet_ouvrant);
        }
      break ;
      case LEX_MiniJava.token_identificateur : // 103
        regle68 () ;
      break ;
      case LEX_MiniJava.token_parenthese_ouvrante : // 52
        regle68 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
