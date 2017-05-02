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
public class S_Classes_MiniJava {
LEX_MiniJava scanner;
  S_Classes_MiniJava() {
	}
  S_Classes_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tds;
  boolean att_eval;
  LinkedList<Classe> att_classes;
  LEX_MiniJava att_scanner;
  private void regle14() throws Exception {

	//declaration
	S_Classe_MiniJava x_3 = new S_Classe_MiniJava(scanner,att_eval) ;
	S_Classes_MiniJava x_5 = new S_Classes_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_tds_14(x_3, x_5);
	x_3.analyser() ;
if  (att_eval)	  action_tds1_14(x_3, x_5);
	x_5.analyser() ;
if  (att_eval)	  action_classes_14(x_3, x_5);
  }
  private void regle15() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_classes_15();
  }
private void action_tds_14(S_Classe_MiniJava x_3, S_Classes_MiniJava x_5) throws Exception {
try {
// instructions
x_3.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","Classes -> #tds Classe #tds1 Classes1 #classes ;", e });
}
  }
private void action_tds1_14(S_Classe_MiniJava x_3, S_Classes_MiniJava x_5) throws Exception {
try {
// locales
BlockFactoryImpl loc_fac;
// instructions
loc_fac= new BlockFactoryImpl();
if (this.att_tds.contains(x_3.att_ast.getNom())){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_classe_already_defined, MiniJavaMessages.MiniJava_classe_already_defined,new Object[]{""+x_3.att_ast.getNom()});

x_5.att_tds=this.att_tds;
}
else {
x_5.att_tds=this.att_tds;
x_5.att_tds.register(loc_fac.createClasseDeclaration(x_3.att_ast));
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds1","Classes -> #tds Classe #tds1 Classes1 #classes ;", e });
}
  }
private void action_classes_14(S_Classe_MiniJava x_3, S_Classes_MiniJava x_5) throws Exception {
try {
// instructions
this.att_classes=x_5.att_classes;
this.att_classes.add(x_3.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#classes","Classes -> #tds Classe #tds1 Classes1 #classes ;", e });
}
  }
private void action_classes_15() throws Exception {
try {
// instructions
this.att_classes= new LinkedList<Classe>();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#classes","Classes -> #classes ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_classe : // 91
        regle14 () ;
      break ;
      case LEX_MiniJava.token_public : // 94
        regle15 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
