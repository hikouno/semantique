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
public class S_TypeAtomique_MiniJava {
LEX_MiniJava scanner;
  S_TypeAtomique_MiniJava() {
	}
  S_TypeAtomique_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  Type att_ast;
  LEX_MiniJava att_scanner;
  private void regle63() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_type_char);
if  (att_eval)	  action_ast_63();
  }
  private void regle64() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_type_float);
if  (att_eval)	  action_ast_64();
  }
  private void regle65() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_type_String);
if  (att_eval)	  action_ast_65();
  }
  private void regle66() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_InstanceGenericite_MiniJava x_3 = new S_InstanceGenericite_MiniJava(scanner,att_eval) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_identificateur_type);
	x_3.analyser() ;
if  (att_eval)	  action_ast_66(x_2, x_3);
  }
  private void regle61() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_type_bool);
if  (att_eval)	  action_ast_61();
  }
  private void regle62() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_type_int);
if  (att_eval)	  action_ast_62();
  }
private void action_ast_61() throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createBooleanType();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","TypeAtomique -> type_bool #ast ;", e });
}
  }
private void action_ast_62() throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createIntegerType();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","TypeAtomique -> type_int #ast ;", e });
}
  }
private void action_ast_63() throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createCharType();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","TypeAtomique -> type_char #ast ;", e });
}
  }
private void action_ast_64() throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createFloatingType();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","TypeAtomique -> type_float #ast ;", e });
}
  }
private void action_ast_65() throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createStringType();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","TypeAtomique -> type_String #ast ;", e });
}
  }
private void action_ast_66(T_MiniJava x_2, S_InstanceGenericite_MiniJava x_3) throws Exception {
try {
// locales
Optional<Declaration> loc_f;
Declaration loc_d;
// instructions
if ((this.att_tds.knows(x_2.att_txt))){
loc_f=this.att_tds.get(x_2.att_txt);
loc_d=loc_f.get();
if (loc_d instanceof ClasseDeclaration ){
this.att_ast=this.att_factory.createClasseType(((ClasseDeclaration)loc_d).getClasse());
}
else if (loc_d instanceof InterfaceDeclaration ){
this.att_ast=this.att_factory.createInterfaceType(((InterfaceDeclaration)loc_d).getInterface());
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_badtype_classe, MiniJavaMessages.MiniJava_badtype_classe,new Object[]{""+x_2.att_txt});


}
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_undefined_classe, MiniJavaMessages.MiniJava_undefined_classe,new Object[]{""+x_2.att_txt});

}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","TypeAtomique -> identificateur_type InstanceGenericite #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_type_bool : // 82
        regle61 () ;
      break ;
      case LEX_MiniJava.token_type_int : // 81
        regle62 () ;
      break ;
      case LEX_MiniJava.token_type_char : // 84
        regle63 () ;
      break ;
      case LEX_MiniJava.token_type_float : // 83
        regle64 () ;
      break ;
      case LEX_MiniJava.token_type_String : // 85
        regle65 () ;
      break ;
      case LEX_MiniJava.token_identificateur_type : // 104
        regle66 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
