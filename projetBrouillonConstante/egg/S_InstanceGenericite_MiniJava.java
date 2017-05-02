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
public class S_InstanceGenericite_MiniJava {
LEX_MiniJava scanner;
  S_InstanceGenericite_MiniJava() {
	}
  S_InstanceGenericite_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  boolean att_eval;
  LEX_MiniJava att_scanner;
  private void regle34() throws Exception {

	//declaration
	//appel
  }
  private void regle35() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_ArgumentsGenericite_MiniJava x_3 = new S_ArgumentsGenericite_MiniJava(scanner,att_eval) ;
	T_MiniJava x_4 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_inferieur);
	x_3.analyser() ;
	x_4.analyser(LEX_MiniJava.token_superieur);
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_virgule : // 60
        regle34 () ;
      break ;
      case LEX_MiniJava.token_implantation : // 93
        regle34 () ;
      break ;
      case LEX_MiniJava.token_accolade_ouvrante : // 48
        regle34 () ;
      break ;
      case LEX_MiniJava.token_crochet_ouvrant : // 50
        regle34 () ;
      break ;
      case LEX_MiniJava.token_superieur : // 55
        regle34 () ;
      break ;
      case LEX_MiniJava.token_identificateur : // 103
        regle34 () ;
      break ;
      case LEX_MiniJava.token_parenthese_ouvrante : // 52
        regle34 () ;
      break ;
      case LEX_MiniJava.token_inferieur : // 54
        regle35 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
