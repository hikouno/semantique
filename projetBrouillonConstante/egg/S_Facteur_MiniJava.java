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
public class S_Facteur_MiniJava {
LEX_MiniJava scanner;
  S_Facteur_MiniJava() {
	}
  S_Facteur_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  Expression att_ast;
  LEX_MiniJava att_scanner;
  private void regle113() throws Exception {

	//declaration
	S_Valeur_MiniJava x_2 = new S_Valeur_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_113(x_2);
	x_2.analyser() ;
if  (att_eval)	  action_ast_113(x_2);
  }
  private void regle106() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_Facteur_MiniJava x_4 = new S_Facteur_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_106(x_4);
	x_2.analyser(LEX_MiniJava.token_soustraction);
if  (att_eval)	  action_tds_106(x_4);
	x_4.analyser() ;
if  (att_eval)	  action_ast_106(x_4);
  }
  private void regle117() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_AppelOuAcces_MiniJava x_5 = new S_AppelOuAcces_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_117(x_2, x_5);
	x_2.analyser(LEX_MiniJava.token_identificateur);
if  (att_eval)	  action_tds_117(x_2, x_5);
if  (att_eval)	  action_inh_117(x_2, x_5);
	x_5.analyser() ;
if  (att_eval)	  action_ast_117(x_2, x_5);
  }
  private void regle107() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_Facteur_MiniJava x_4 = new S_Facteur_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_107(x_4);
	x_2.analyser(LEX_MiniJava.token_negation);
if  (att_eval)	  action_tds_107(x_4);
	x_4.analyser() ;
if  (att_eval)	  action_ast_107(x_4);
  }
  private void regle108() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_Type_MiniJava x_4 = new S_Type_MiniJava(scanner,att_eval) ;
	S_SuiteNouveau_MiniJava x_6 = new S_SuiteNouveau_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_108(x_4, x_6);
	x_2.analyser(LEX_MiniJava.token_nouveau);
if  (att_eval)	  action_tds_108(x_4, x_6);
	x_4.analyser() ;
if  (att_eval)	  action_inh_108(x_4, x_6);
	x_6.analyser() ;
if  (att_eval)	  action_ast_108(x_4, x_6);
  }
private void action_auto_inh_113(S_Valeur_MiniJava x_2) throws Exception {
try {
// instructions
x_2.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Facteur -> Valeur #ast ;", e });
}
  }
private void action_auto_inh_106(S_Facteur_MiniJava x_4) throws Exception {
try {
// instructions
x_4.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Facteur -> soustraction #tds Facteur1 #ast ;", e });
}
  }
private void action_tds_108(S_Type_MiniJava x_4, S_SuiteNouveau_MiniJava x_6) throws Exception {
try {
// instructions
x_4.att_tds=this.att_tds;
x_6.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","Facteur -> nouveau #tds Type #inh SuiteNouveau #ast ;", e });
}
  }
private void action_auto_inh_117(T_MiniJava x_2, S_AppelOuAcces_MiniJava x_5) throws Exception {
try {
// instructions
x_5.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Facteur -> identificateur #tds #inh AppelOuAcces #ast ;", e });
}
  }
private void action_tds_107(S_Facteur_MiniJava x_4) throws Exception {
try {
// instructions
x_4.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","Facteur -> negation #tds Facteur1 #ast ;", e });
}
  }
private void action_tds_106(S_Facteur_MiniJava x_4) throws Exception {
try {
// instructions
x_4.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","Facteur -> soustraction #tds Facteur1 #ast ;", e });
}
  }
private void action_auto_inh_108(S_Type_MiniJava x_4, S_SuiteNouveau_MiniJava x_6) throws Exception {
try {
// instructions
x_4.att_factory=this.att_factory;
x_6.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Facteur -> nouveau #tds Type #inh SuiteNouveau #ast ;", e });
}
  }
private void action_tds_117(T_MiniJava x_2, S_AppelOuAcces_MiniJava x_5) throws Exception {
try {
// instructions
x_5.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","Facteur -> identificateur #tds #inh AppelOuAcces #ast ;", e });
}
  }
private void action_auto_inh_107(S_Facteur_MiniJava x_4) throws Exception {
try {
// instructions
x_4.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Facteur -> negation #tds Facteur1 #ast ;", e });
}
  }
private void action_ast_106(S_Facteur_MiniJava x_4) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createUnaryExpression(UnaryOperator.Opposite, x_4.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Facteur -> soustraction #tds Facteur1 #ast ;", e });
}
  }
private void action_ast_117(T_MiniJava x_2, S_AppelOuAcces_MiniJava x_5) throws Exception {
try {
// instructions
this.att_ast=x_5.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Facteur -> identificateur #tds #inh AppelOuAcces #ast ;", e });
}
  }
private void action_ast_107(S_Facteur_MiniJava x_4) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createUnaryExpression(UnaryOperator.Negate, x_4.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Facteur -> negation #tds Facteur1 #ast ;", e });
}
  }
private void action_inh_117(T_MiniJava x_2, S_AppelOuAcces_MiniJava x_5) throws Exception {
try {
// locales
Optional<Declaration> loc_f;
Declaration loc_d;
// instructions
if ((this.att_tds.knows(x_2.att_txt))){
loc_f=this.att_tds.get(x_2.att_txt);
loc_d=loc_f.get();
if (loc_d instanceof ConstantDeclaration ){
x_5.att_support=((ConstantDeclaration)loc_d).getValue();
}
else if (loc_d instanceof VariableDeclaration ){
x_5.att_support=this.att_factory.createVariableUse(((VariableDeclaration)loc_d));
}

}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_undefined_ident, MiniJavaMessages.MiniJava_undefined_ident,new Object[]{""+x_2.att_txt});

}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#inh","Facteur -> identificateur #tds #inh AppelOuAcces #ast ;", e });
}
  }
private void action_ast_108(S_Type_MiniJava x_4, S_SuiteNouveau_MiniJava x_6) throws Exception {
try {
// instructions
this.att_ast=x_6.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Facteur -> nouveau #tds Type #inh SuiteNouveau #ast ;", e });
}
  }
private void action_inh_108(S_Type_MiniJava x_4, S_SuiteNouveau_MiniJava x_6) throws Exception {
try {
// instructions
x_6.att_type=x_4.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#inh","Facteur -> nouveau #tds Type #inh SuiteNouveau #ast ;", e });
}
  }
private void action_ast_113(S_Valeur_MiniJava x_2) throws Exception {
try {
// instructions
this.att_ast=x_2.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Facteur -> Valeur #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_soustraction : // 65
        regle106 () ;
      break ;
      case LEX_MiniJava.token_negation : // 71
        regle107 () ;
      break ;
      case LEX_MiniJava.token_nouveau : // 78
        regle108 () ;
      break ;
      case LEX_MiniJava.token_entier : // 102
        regle113 () ;
      break ;
      case LEX_MiniJava.token_vrai : // 73
        regle113 () ;
      break ;
      case LEX_MiniJava.token_faux : // 74
        regle113 () ;
      break ;
      case LEX_MiniJava.token_identificateur : // 103
        regle117 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
