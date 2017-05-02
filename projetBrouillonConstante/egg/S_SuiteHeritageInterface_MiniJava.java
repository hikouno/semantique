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
public class S_SuiteHeritageInterface_MiniJava {
LEX_MiniJava scanner;
  S_SuiteHeritageInterface_MiniJava() {
	}
  S_SuiteHeritageInterface_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  boolean att_eval;
  LEX_MiniJava att_scanner;
  private void regle7() throws Exception {

	//declaration
	//appel
  }
  private void regle6() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	S_InstanceGenericite_MiniJava x_4 = new S_InstanceGenericite_MiniJava(scanner,att_eval) ;
	S_SuiteHeritageInterface_MiniJava x_5 = new S_SuiteHeritageInterface_MiniJava(scanner,att_eval) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_virgule);
	x_3.analyser(LEX_MiniJava.token_identificateur_type);
	x_4.analyser() ;
	x_5.analyser() ;
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_virgule : // 60
        regle6 () ;
      break ;
      case LEX_MiniJava.token_accolade_ouvrante : // 48
        regle7 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
