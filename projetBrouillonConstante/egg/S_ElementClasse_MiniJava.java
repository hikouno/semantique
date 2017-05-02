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
public class S_ElementClasse_MiniJava {
LEX_MiniJava scanner;
  S_ElementClasse_MiniJava() {
	}
  S_ElementClasse_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tds;
  boolean att_eval;
  LEX_MiniJava att_scanner;
  Classe att_classe_mere;
  DroitAcces att_droit;
  private void regle48() throws Exception {

	//declaration
	S_Constructeur_MiniJava x_3 = new S_Constructeur_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_tds_48(x_3);
	x_3.analyser() ;
if  (att_eval)	  action_ast_48(x_3);
  }
  private void regle47() throws Exception {

	//declaration
	S_AttributOuMethode_MiniJava x_3 = new S_AttributOuMethode_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_tds_47(x_3);
	x_3.analyser() ;
if  (att_eval)	  action_ast_47(x_3);
  }
  private void regle46() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_AttributOuMethode_MiniJava x_4 = new S_AttributOuMethode_MiniJava(scanner,att_eval) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_statique);
if  (att_eval)	  action_tds_46(x_4);
	x_4.analyser() ;
if  (att_eval)	  action_ast_46(x_4);
  }
private void action_ast_47(S_AttributOuMethode_MiniJava x_3) throws Exception {
try {
// locales
ProgramFactoryImpl loc_prg;
// instructions
loc_prg= new ProgramFactoryImpl();
if ((x_3.att_methode_corps!=null)){
if ((!(this.att_classe_mere.ajouterMethode(loc_prg.createMethode(this.att_classe_mere, x_3.att_nom, x_3.att_methode_arguments, x_3.att_methode_corps, this.att_droit, false, x_3.att_type))))){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_Methode_DejaDef, MiniJavaMessages.MiniJava_Methode_DejaDef,new Object[]{""+this.att_classe_mere.getNom(), ""+x_3.att_nom});

}

}
else {
if ((!(this.att_classe_mere.ajouterAttribut(loc_prg.createAttribut(this.att_classe_mere, x_3.att_type.get(), x_3.att_nom, this.att_droit, false))))){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_Attribut_DejaDef, MiniJavaMessages.MiniJava_Attribut_DejaDef,new Object[]{""+this.att_classe_mere.getNom(), ""+x_3.att_nom});

}

}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","ElementClasse -> #tds AttributOuMethode #ast ;", e });
}
  }
private void action_ast_48(S_Constructeur_MiniJava x_3) throws Exception {
try {
// locales
ProgramFactoryImpl loc_prg;
// instructions
loc_prg= new ProgramFactoryImpl();
if ((!(this.att_classe_mere.ajouterConstructeur(loc_prg.createConstructeur(this.att_classe_mere, this.att_droit, x_3.att_args, x_3.att_bloc))))){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_Constructeur_DejaDef, MiniJavaMessages.MiniJava_Constructeur_DejaDef,new Object[]{""+this.att_classe_mere.getNom()});

}

}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","ElementClasse -> #tds Constructeur #ast ;", e });
}
  }
private void action_tds_47(S_AttributOuMethode_MiniJava x_3) throws Exception {
try {
// instructions
x_3.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","ElementClasse -> #tds AttributOuMethode #ast ;", e });
}
  }
private void action_tds_46(S_AttributOuMethode_MiniJava x_4) throws Exception {
try {
// instructions
x_4.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","ElementClasse -> statique #tds AttributOuMethode #ast ;", e });
}
  }
private void action_tds_48(S_Constructeur_MiniJava x_3) throws Exception {
try {
// instructions
x_3.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","ElementClasse -> #tds Constructeur #ast ;", e });
}
  }
private void action_ast_46(S_AttributOuMethode_MiniJava x_4) throws Exception {
try {
// locales
ProgramFactoryImpl loc_prg;
// instructions
loc_prg= new ProgramFactoryImpl();
if ((x_4.att_methode_corps!=null)){
if ((!(this.att_classe_mere.ajouterMethode(loc_prg.createMethode(this.att_classe_mere, x_4.att_nom, x_4.att_methode_arguments, x_4.att_methode_corps, this.att_droit, true, x_4.att_type))))){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_Methode_DejaDef, MiniJavaMessages.MiniJava_Methode_DejaDef,new Object[]{""+this.att_classe_mere.getNom(), ""+x_4.att_nom});

}

}
else {
if ((!(this.att_classe_mere.ajouterAttribut(loc_prg.createAttribut(this.att_classe_mere, x_4.att_type.get(), x_4.att_nom, this.att_droit, true))))){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_Attribut_DejaDef, MiniJavaMessages.MiniJava_Attribut_DejaDef,new Object[]{""+this.att_classe_mere.getNom(), ""+x_4.att_nom});

}

}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","ElementClasse -> statique #tds AttributOuMethode #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_statique : // 97
        regle46 () ;
      break ;
      case LEX_MiniJava.token_type_bool : // 82
        regle47 () ;
      break ;
      case LEX_MiniJava.token_type_int : // 81
        regle47 () ;
      break ;
      case LEX_MiniJava.token_type_char : // 84
        regle47 () ;
      break ;
      case LEX_MiniJava.token_type_float : // 83
        regle47 () ;
      break ;
      case LEX_MiniJava.token_type_String : // 85
        regle47 () ;
      break ;
      case LEX_MiniJava.token_identificateur_type : // 104
        scanner.lit ( 2 ) ;
        switch ( scanner.fenetre[1].code ) {
          case LEX_MiniJava.token_inferieur : // 54
            regle47 () ;
          break ;
          case LEX_MiniJava.token_crochet_ouvrant : // 50
            regle47 () ;
          break ;
          case LEX_MiniJava.token_identificateur : // 103
            regle47 () ;
          break ;
          case LEX_MiniJava.token_parenthese_ouvrante : // 52
            regle48 () ;
          break ;
          default :
            	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[1].getNom()});
scanner.accepter_sucre(LEX_MiniJava.token_identificateur_type);
        }
      break ;
      case LEX_MiniJava.token_vide : // 86
        regle47 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
