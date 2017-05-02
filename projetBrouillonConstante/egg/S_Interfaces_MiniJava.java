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
public class S_Interfaces_MiniJava {
LEX_MiniJava scanner;
  S_Interfaces_MiniJava() {
	}
  S_Interfaces_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tds;
  LinkedList<Interface> att_interfaces;
  boolean att_eval;
  LEX_MiniJava att_scanner;
  private void regle2() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_interfaces_2();
  }
  private void regle1() throws Exception {

	//declaration
	S_Interface_MiniJava x_3 = new S_Interface_MiniJava(scanner,att_eval) ;
	S_Interfaces_MiniJava x_5 = new S_Interfaces_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_tds_1(x_3, x_5);
	x_3.analyser() ;
if  (att_eval)	  action_tds1_1(x_3, x_5);
	x_5.analyser() ;
if  (att_eval)	  action_interfaces_1(x_3, x_5);
  }
private void action_tds_1(S_Interface_MiniJava x_3, S_Interfaces_MiniJava x_5) throws Exception {
try {
// instructions
x_3.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","Interfaces -> #tds Interface #tds1 Interfaces1 #interfaces ;", e });
}
  }
private void action_tds1_1(S_Interface_MiniJava x_3, S_Interfaces_MiniJava x_5) throws Exception {
try {
// locales
BlockFactoryImpl loc_fac;
// instructions
loc_fac= new BlockFactoryImpl();
if (this.att_tds.contains(x_3.att_ast.getNom())){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_interface_already_defined, MiniJavaMessages.MiniJava_interface_already_defined,new Object[]{""+x_3.att_ast.getNom()});

x_5.att_tds=this.att_tds;
}
else {
x_5.att_tds=this.att_tds;
x_5.att_tds.register(loc_fac.createInterfaceDeclaration(x_3.att_ast));
x_5.att_tds.register(x_3.att_constantes);
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds1","Interfaces -> #tds Interface #tds1 Interfaces1 #interfaces ;", e });
}
  }
private void action_interfaces_2() throws Exception {
try {
// instructions
this.att_interfaces= new LinkedList<Interface>();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#interfaces","Interfaces -> #interfaces ;", e });
}
  }
private void action_interfaces_1(S_Interface_MiniJava x_3, S_Interfaces_MiniJava x_5) throws Exception {
try {
// instructions
this.att_interfaces=x_5.att_interfaces;
this.att_interfaces.add(x_3.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#interfaces","Interfaces -> #tds Interface #tds1 Interfaces1 #interfaces ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_interface : // 90
        regle1 () ;
      break ;
      case LEX_MiniJava.token_classe : // 91
        regle2 () ;
      break ;
      case LEX_MiniJava.token_public : // 94
        regle2 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
