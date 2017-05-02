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
public class S_ElementsClasse_MiniJava {
LEX_MiniJava scanner;
  S_ElementsClasse_MiniJava() {
	}
  S_ElementsClasse_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tds;
  boolean att_eval;
  LEX_MiniJava att_scanner;
  Classe att_classe_mere;
  private void regle41() throws Exception {

	//declaration
	S_DroitAcces_MiniJava x_2 = new S_DroitAcces_MiniJava(scanner,att_eval) ;
	S_ElementClasse_MiniJava x_5 = new S_ElementClasse_MiniJava(scanner,att_eval) ;
	S_ElementsClasse_MiniJava x_6 = new S_ElementsClasse_MiniJava(scanner,att_eval) ;
	//appel
	x_2.analyser() ;
if  (att_eval)	  action_tds_41(x_2, x_5, x_6);
if  (att_eval)	  action_inh_41(x_2, x_5, x_6);
	x_5.analyser() ;
	x_6.analyser() ;
  }
  private void regle42() throws Exception {

	//declaration
	//appel
  }
private void action_tds_41(S_DroitAcces_MiniJava x_2, S_ElementClasse_MiniJava x_5, S_ElementsClasse_MiniJava x_6) throws Exception {
try {
// instructions
x_5.att_tds=this.att_tds;
x_6.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","ElementsClasse -> DroitAcces #tds #inh ElementClasse ElementsClasse1 ;", e });
}
  }
private void action_inh_41(S_DroitAcces_MiniJava x_2, S_ElementClasse_MiniJava x_5, S_ElementsClasse_MiniJava x_6) throws Exception {
try {
// instructions
x_5.att_classe_mere=this.att_classe_mere;
x_5.att_droit=x_2.att_droit;
x_6.att_classe_mere=this.att_classe_mere;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#inh","ElementsClasse -> DroitAcces #tds #inh ElementClasse ElementsClasse1 ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_public : // 94
        regle41 () ;
      break ;
      case LEX_MiniJava.token_protege : // 95
        regle41 () ;
      break ;
      case LEX_MiniJava.token_prive : // 96
        regle41 () ;
      break ;
      case LEX_MiniJava.token_accolade_fermante : // 49
        regle42 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
