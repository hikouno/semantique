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
public class S_ElementsInterface_MiniJava {
LEX_MiniJava scanner;
  S_ElementsInterface_MiniJava() {
	}
  S_ElementsInterface_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tds;
  boolean att_eval;
  LEX_MiniJava att_scanner;
  Interface att_interface_mere;
  LinkedList<ConstantDeclaration> att_constantes;
  private void regle9() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_9();
  }
  private void regle8() throws Exception {

	//declaration
	S_ElementInterface_MiniJava x_4 = new S_ElementInterface_MiniJava(scanner,att_eval) ;
	S_ElementsInterface_MiniJava x_5 = new S_ElementsInterface_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_tds_8(x_4, x_5);
if  (att_eval)	  action_inh_8(x_4, x_5);
	x_4.analyser() ;
	x_5.analyser() ;
if  (att_eval)	  action_ast_8(x_4, x_5);
  }
private void action_ast_9() throws Exception {
try {
// instructions
this.att_constantes= new LinkedList<ConstantDeclaration>();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","ElementsInterface -> #ast ;", e });
}
  }
private void action_inh_8(S_ElementInterface_MiniJava x_4, S_ElementsInterface_MiniJava x_5) throws Exception {
try {
// instructions
x_4.att_interface_mere=this.att_interface_mere;
x_5.att_interface_mere=this.att_interface_mere;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#inh","ElementsInterface -> #tds #inh ElementInterface ElementsInterface1 #ast ;", e });
}
  }
private void action_ast_8(S_ElementInterface_MiniJava x_4, S_ElementsInterface_MiniJava x_5) throws Exception {
try {
// instructions
this.att_constantes=x_5.att_constantes;
this.att_constantes.add(x_4.att_constante);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","ElementsInterface -> #tds #inh ElementInterface ElementsInterface1 #ast ;", e });
}
  }
private void action_tds_8(S_ElementInterface_MiniJava x_4, S_ElementsInterface_MiniJava x_5) throws Exception {
try {
// instructions
x_4.att_tds=this.att_tds;
x_5.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","ElementsInterface -> #tds #inh ElementInterface ElementsInterface1 #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_final : // 98
        regle8 () ;
      break ;
      case LEX_MiniJava.token_vide : // 86
        regle8 () ;
      break ;
      case LEX_MiniJava.token_type_bool : // 82
        regle8 () ;
      break ;
      case LEX_MiniJava.token_type_int : // 81
        regle8 () ;
      break ;
      case LEX_MiniJava.token_type_char : // 84
        regle8 () ;
      break ;
      case LEX_MiniJava.token_type_float : // 83
        regle8 () ;
      break ;
      case LEX_MiniJava.token_type_String : // 85
        regle8 () ;
      break ;
      case LEX_MiniJava.token_identificateur_type : // 104
        regle8 () ;
      break ;
      case LEX_MiniJava.token_accolade_fermante : // 49
        regle9 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
