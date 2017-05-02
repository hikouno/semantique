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
public class S_SuiteNouveau_MiniJava {
LEX_MiniJava scanner;
  S_SuiteNouveau_MiniJava() {
	}
  S_SuiteNouveau_MiniJava(LEX_MiniJava scanner, boolean eval) {
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
  Type att_type;
  private void regle110() throws Exception {

	//declaration
	S_Arguments_MiniJava x_3 = new S_Arguments_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_tds_110(x_3);
	x_3.analyser() ;
if  (att_eval)	  action_ast_110(x_3);
  }
  private void regle109() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_Expression_MiniJava x_4 = new S_Expression_MiniJava(scanner,att_eval) ;
	T_MiniJava x_5 = new T_MiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_109(x_4);
	x_2.analyser(LEX_MiniJava.token_crochet_ouvrant);
if  (att_eval)	  action_tds_109(x_4);
	x_4.analyser() ;
	x_5.analyser(LEX_MiniJava.token_crochet_fermant);
if  (att_eval)	  action_ast_109(x_4);
  }
private void action_tds_110(S_Arguments_MiniJava x_3) throws Exception {
try {
// instructions
x_3.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","SuiteNouveau -> #tds Arguments #ast ;", e });
}
  }
private void action_ast_109(S_Expression_MiniJava x_4) throws Exception {
try {
// instructions
this.att_ast=null;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","SuiteNouveau -> crochet_ouvrant #tds Expression crochet_fermant #ast ;", e });
}
  }
private void action_tds_109(S_Expression_MiniJava x_4) throws Exception {
try {
// instructions
x_4.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","SuiteNouveau -> crochet_ouvrant #tds Expression crochet_fermant #ast ;", e });
}
  }
private void action_ast_110(S_Arguments_MiniJava x_3) throws Exception {
try {
// instructions
if (this.att_type instanceof ClasseTypeImpl ){
this.att_ast=this.att_factory.createClasseInstanceAllocation(((ClasseTypeImpl)this.att_type).getClasse(), x_3.att_args);
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_badtype_classe, MiniJavaMessages.MiniJava_badtype_classe,new Object[]{""+this.att_type.toString()});


}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","SuiteNouveau -> #tds Arguments #ast ;", e });
}
  }
private void action_auto_inh_109(S_Expression_MiniJava x_4) throws Exception {
try {
// instructions
x_4.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","SuiteNouveau -> crochet_ouvrant #tds Expression crochet_fermant #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_crochet_ouvrant : // 50
        regle109 () ;
      break ;
      case LEX_MiniJava.token_parenthese_ouvrante : // 52
        regle110 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
