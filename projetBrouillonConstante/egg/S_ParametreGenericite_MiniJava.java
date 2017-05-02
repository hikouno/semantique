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
public class S_ParametreGenericite_MiniJava {
LEX_MiniJava scanner;
  S_ParametreGenericite_MiniJava() {
	}
  S_ParametreGenericite_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  boolean att_eval;
  LEX_MiniJava att_scanner;
  private void regle28() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_HeritageGenericite_MiniJava x_3 = new S_HeritageGenericite_MiniJava(scanner,att_eval) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_identificateur_type);
	x_3.analyser() ;
  }
  private void regle29() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_HeritageGenericite_MiniJava x_3 = new S_HeritageGenericite_MiniJava(scanner,att_eval) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_choix);
	x_3.analyser() ;
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_identificateur_type : // 104
        regle28 () ;
      break ;
      case LEX_MiniJava.token_choix : // 88
        regle29 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
