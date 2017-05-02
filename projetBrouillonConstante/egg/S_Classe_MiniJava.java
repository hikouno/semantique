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
public class S_Classe_MiniJava {
LEX_MiniJava scanner;
  S_Classe_MiniJava() {
	}
  S_Classe_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tds;
  boolean att_eval;
  Classe att_ast;
  LEX_MiniJava att_scanner;
  private void regle16() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	S_Genericite_MiniJava x_4 = new S_Genericite_MiniJava(scanner,att_eval) ;
	S_HeritageClasse_MiniJava x_5 = new S_HeritageClasse_MiniJava(scanner,att_eval) ;
	S_ImplantationInterface_MiniJava x_6 = new S_ImplantationInterface_MiniJava(scanner,att_eval) ;
	T_MiniJava x_7 = new T_MiniJava(scanner ) ;
	S_ElementsClasse_MiniJava x_9 = new S_ElementsClasse_MiniJava(scanner,att_eval) ;
	T_MiniJava x_10 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_classe);
	x_3.analyser(LEX_MiniJava.token_identificateur_type);
	x_4.analyser() ;
	x_5.analyser() ;
	x_6.analyser() ;
	x_7.analyser(LEX_MiniJava.token_accolade_ouvrante);
if  (att_eval)	  action_ast_inh_16(x_3, x_4, x_5, x_6, x_9);
	x_9.analyser() ;
	x_10.analyser(LEX_MiniJava.token_accolade_fermante);
  }
private void action_ast_inh_16(T_MiniJava x_3, S_Genericite_MiniJava x_4, S_HeritageClasse_MiniJava x_5, S_ImplantationInterface_MiniJava x_6, S_ElementsClasse_MiniJava x_9) throws Exception {
try {
// locales
ProgramFactoryImpl loc_prg;
Classe loc_classe;
// instructions
loc_prg= new ProgramFactoryImpl();
loc_classe=loc_prg.createClasse(x_3.att_txt);
this.att_ast=loc_classe;
x_9.att_tds=this.att_tds;
x_9.att_classe_mere=loc_classe;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast_inh","Classe -> classe identificateur_type Genericite HeritageClasse ImplantationInterface accolade_ouvrante #ast_inh ElementsClasse accolade_fermante ;", e });
}
  }
  public void analyser () throws Exception {
    regle16 () ;
  }
  }
