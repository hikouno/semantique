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
public class S_Instructions_MiniJava {
LEX_MiniJava scanner;
  S_Instructions_MiniJava() {
	}
  S_Instructions_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  LEX_MiniJava att_scanner;
  Block att_blocParent;
  private void regle69() throws Exception {

	//declaration
	//appel
  }
  private void regle70() throws Exception {

	//declaration
	S_Instruction_MiniJava x_3 = new S_Instruction_MiniJava(scanner,att_eval) ;
	S_Instructions_MiniJava x_5 = new S_Instructions_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_70(x_3, x_5);
if  (att_eval)	  action_inh_70(x_3, x_5);
	x_3.analyser() ;
if  (att_eval)	  action_instr_70(x_3, x_5);
	x_5.analyser() ;
  }
private void action_instr_70(S_Instruction_MiniJava x_3, S_Instructions_MiniJava x_5) throws Exception {
try {
// instructions
this.att_blocParent.add(x_3.att_instr);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#instr","Instructions -> #inh Instruction #instr Instructions1 ;", e });
}
  }
private void action_auto_inh_70(S_Instruction_MiniJava x_3, S_Instructions_MiniJava x_5) throws Exception {
try {
// instructions
x_5.att_factory=this.att_factory;
x_5.att_blocParent=this.att_blocParent;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Instructions -> #inh Instruction #instr Instructions1 ;", e });
}
  }
private void action_inh_70(S_Instruction_MiniJava x_3, S_Instructions_MiniJava x_5) throws Exception {
try {
// instructions
x_3.att_factory= new BlockFactoryImpl();
x_3.att_tds=this.att_tds;
x_5.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#inh","Instructions -> #inh Instruction #instr Instructions1 ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_accolade_fermante : // 49
        regle69 () ;
      break ;
      case LEX_MiniJava.token_type_bool : // 82
        regle70 () ;
      break ;
      case LEX_MiniJava.token_type_int : // 81
        regle70 () ;
      break ;
      case LEX_MiniJava.token_type_char : // 84
        regle70 () ;
      break ;
      case LEX_MiniJava.token_type_float : // 83
        regle70 () ;
      break ;
      case LEX_MiniJava.token_type_String : // 85
        regle70 () ;
      break ;
      case LEX_MiniJava.token_identificateur_type : // 104
        regle70 () ;
      break ;
      case LEX_MiniJava.token_parenthese_ouvrante : // 52
        regle70 () ;
      break ;
      case LEX_MiniJava.token_identificateur : // 103
        regle70 () ;
      break ;
      case LEX_MiniJava.token_si : // 75
        regle70 () ;
      break ;
      case LEX_MiniJava.token_tant_que : // 79
        regle70 () ;
      break ;
      case LEX_MiniJava.token_afficher : // 77
        regle70 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
