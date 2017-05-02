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
public class S_ElementInterface_MiniJava {
LEX_MiniJava scanner;
  S_ElementInterface_MiniJava() {
	}
  S_ElementInterface_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tds;
  boolean att_eval;
  ConstantDeclaration att_constante;
  LEX_MiniJava att_scanner;
  Interface att_interface_mere;
  private void regle11() throws Exception {

	//declaration
	S_Signature_MiniJava x_3 = new S_Signature_MiniJava(scanner,att_eval) ;
	T_MiniJava x_4 = new T_MiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_tds_11(x_3);
	x_3.analyser() ;
	x_4.analyser(LEX_MiniJava.token_point_virgule);
if  (att_eval)	  action_ast_11(x_3);
  }
  private void regle10() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	S_Type_MiniJava x_6 = new S_Type_MiniJava(scanner,att_eval) ;
	T_MiniJava x_7 = new T_MiniJava(scanner ) ;
	T_MiniJava x_8 = new T_MiniJava(scanner ) ;
	S_Expression_MiniJava x_9 = new S_Expression_MiniJava(scanner,att_eval) ;
	T_MiniJava x_11 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_final);
	x_3.analyser(LEX_MiniJava.token_statique);
if  (att_eval)	  action_tds_10(x_6, x_7, x_9);
if  (att_eval)	  action_inh_10(x_6, x_7, x_9);
	x_6.analyser() ;
	x_7.analyser(LEX_MiniJava.token_identificateur);
	x_8.analyser(LEX_MiniJava.token_affectation);
	x_9.analyser() ;
if  (att_eval)	  action_ast_10(x_6, x_7, x_9);
	x_11.analyser(LEX_MiniJava.token_point_virgule);
  }
private void action_inh_10(S_Type_MiniJava x_6, T_MiniJava x_7, S_Expression_MiniJava x_9) throws Exception {
try {
// locales
BlockFactoryImpl loc_fac;
// instructions
loc_fac= new BlockFactoryImpl();
x_6.att_factory=loc_fac;
x_9.att_factory=loc_fac;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#inh","ElementInterface -> final statique #tds #inh Type identificateur affectation Expression #ast point_virgule ;", e });
}
  }
private void action_tds_10(S_Type_MiniJava x_6, T_MiniJava x_7, S_Expression_MiniJava x_9) throws Exception {
try {
// instructions
x_6.att_tds=this.att_tds;
x_9.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","ElementInterface -> final statique #tds #inh Type identificateur affectation Expression #ast point_virgule ;", e });
}
  }
private void action_tds_11(S_Signature_MiniJava x_3) throws Exception {
try {
// instructions
x_3.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","ElementInterface -> #tds Signature point_virgule #ast ;", e });
}
  }
private void action_ast_10(S_Type_MiniJava x_6, T_MiniJava x_7, S_Expression_MiniJava x_9) throws Exception {
try {
// locales
BlockFactoryImpl loc_fac;
// instructions
loc_fac= new BlockFactoryImpl();
this.att_constante=loc_fac.createConstantDeclaration(x_7.att_txt, x_6.att_ast, x_9.att_ast, this.att_interface_mere);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","ElementInterface -> final statique #tds #inh Type identificateur affectation Expression #ast point_virgule ;", e });
}
  }
private void action_ast_11(S_Signature_MiniJava x_3) throws Exception {
try {
// instructions
if ((!(this.att_interface_mere.ajouterSignature(x_3.att_type, x_3.att_nom, x_3.att_args)))){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_Signature_DejaDef, MiniJavaMessages.MiniJava_Signature_DejaDef,new Object[]{""+this.att_interface_mere.getNom(), ""+x_3.att_nom});

}

this.att_constante=null;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","ElementInterface -> #tds Signature point_virgule #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_final : // 98
        regle10 () ;
      break ;
      case LEX_MiniJava.token_vide : // 86
        regle11 () ;
      break ;
      case LEX_MiniJava.token_type_bool : // 82
        regle11 () ;
      break ;
      case LEX_MiniJava.token_type_int : // 81
        regle11 () ;
      break ;
      case LEX_MiniJava.token_type_char : // 84
        regle11 () ;
      break ;
      case LEX_MiniJava.token_type_float : // 83
        regle11 () ;
      break ;
      case LEX_MiniJava.token_type_String : // 85
        regle11 () ;
      break ;
      case LEX_MiniJava.token_identificateur_type : // 104
        regle11 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
