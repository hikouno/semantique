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
public class S_Affectable_MiniJava {
LEX_MiniJava scanner;
  S_Affectable_MiniJava() {
	}
  S_Affectable_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  Assignable att_ast;
  LEX_MiniJava att_scanner;
  private void regle73() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_Affectable_MiniJava x_4 = new S_Affectable_MiniJava(scanner,att_eval) ;
	T_MiniJava x_5 = new T_MiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_73(x_4);
	x_2.analyser(LEX_MiniJava.token_parenthese_ouvrante);
if  (att_eval)	  action_tds_73(x_4);
	x_4.analyser() ;
	x_5.analyser(LEX_MiniJava.token_parenthese_fermante);
if  (att_eval)	  action_ast_73(x_4);
  }
  private void regle74() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_SuiteAffectable_MiniJava x_5 = new S_SuiteAffectable_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_74(x_2, x_5);
	x_2.analyser(LEX_MiniJava.token_identificateur);
if  (att_eval)	  action_tds_74(x_2, x_5);
if  (att_eval)	  action_inh_74(x_2, x_5);
	x_5.analyser() ;
if  (att_eval)	  action_ast_74(x_2, x_5);
  }
private void action_auto_inh_73(S_Affectable_MiniJava x_4) throws Exception {
try {
// instructions
x_4.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Affectable -> parenthese_ouvrante #tds Affectable1 parenthese_fermante #ast ;", e });
}
  }
private void action_tds_74(T_MiniJava x_2, S_SuiteAffectable_MiniJava x_5) throws Exception {
try {
// instructions
x_5.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","Affectable -> identificateur #tds #inh SuiteAffectable #ast ;", e });
}
  }
private void action_tds_73(S_Affectable_MiniJava x_4) throws Exception {
try {
// instructions
x_4.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","Affectable -> parenthese_ouvrante #tds Affectable1 parenthese_fermante #ast ;", e });
}
  }
private void action_auto_inh_74(T_MiniJava x_2, S_SuiteAffectable_MiniJava x_5) throws Exception {
try {
// instructions
x_5.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Affectable -> identificateur #tds #inh SuiteAffectable #ast ;", e });
}
  }
private void action_inh_74(T_MiniJava x_2, S_SuiteAffectable_MiniJava x_5) throws Exception {
try {
// locales
Optional<Declaration> loc_o;
Declaration loc_d;
// instructions
if ((this.att_tds.knows(x_2.att_txt))){
loc_o=this.att_tds.get(x_2.att_txt);
loc_d=loc_o.get();
if (loc_d instanceof VariableDeclaration ){
x_5.att_support=this.att_factory.createVariableAssignment(((VariableDeclaration)loc_d));
}
else if (loc_d instanceof ConstantDeclaration ){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_not_a_variable, MiniJavaMessages.MiniJava_not_a_variable,new Object[]{""+x_2.att_txt});

}

}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_undefined_ident, MiniJavaMessages.MiniJava_undefined_ident,new Object[]{""+x_2.att_txt});

}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#inh","Affectable -> identificateur #tds #inh SuiteAffectable #ast ;", e });
}
  }
private void action_ast_73(S_Affectable_MiniJava x_4) throws Exception {
try {
// instructions
this.att_ast=x_4.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Affectable -> parenthese_ouvrante #tds Affectable1 parenthese_fermante #ast ;", e });
}
  }
private void action_ast_74(T_MiniJava x_2, S_SuiteAffectable_MiniJava x_5) throws Exception {
try {
// instructions
this.att_ast=x_5.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Affectable -> identificateur #tds #inh SuiteAffectable #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_parenthese_ouvrante : // 52
        regle73 () ;
      break ;
      case LEX_MiniJava.token_identificateur : // 103
        regle74 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
