package egg;
import java.util.*;
import fr.n7.stl.block.ast.*;
import fr.n7.stl.block.ast.impl.*;
import fr.n7.stl.util.*;
import fr.n7.stl.block.ast.MembreClasse.DroitAcces;
import mg.egg.eggc.runtime.libjava.EGGException;
import mg.egg.eggc.runtime.libjava.ISourceUnit;
import mg.egg.eggc.runtime.libjava.lex.LEX_CONTEXTE;
import mg.egg.eggc.runtime.libjava.problem.IProblemReporter;
import mg.egg.eggc.runtime.libjava.problem.IProblem;
import mg.egg.eggc.runtime.libjava.problem.ProblemSeverities;
import mg.egg.eggc.runtime.libjava.messages.NLS;
public class MiniJava {
  LEX_MiniJava scanner;
  protected IProblemReporter problemReporter;
	private S_Programme_MiniJava axiome ;
	public  S_Programme_MiniJava getAxiom(){return axiome;}
  public MiniJava(IProblemReporter pr){
	   this.problemReporter = pr;
  }
  public void compile(ISourceUnit cu) throws Exception {
	try{
	  System.err.println("MiniJava Version 0.0.1");
	  LEX_CONTEXTE contexte;
	  contexte = new LEX_CONTEXTE(cu);
	  scanner = new LEX_MiniJava(problemReporter, contexte, 2);
	  scanner.analyseur.fromContext(contexte);
	  att_scanner = scanner;
	  axiome = new S_Programme_MiniJava(scanner,att_eval);
	  axiome.att_scanner = this.att_scanner ;
	  axiome.att_eval = this.att_eval ;
	  axiome.analyser() ;
	  this.att_ast = axiome.att_ast ;
	  scanner.accepter_fds() ;
	}catch (EGGException e){
	  problemReporter.handle(e.getCategory(), e.getCode(),0, NLS.bind(e.getId(),e.getArgs()),ProblemSeverities.Error,0,0,e.getArgs());
	}
	}
  boolean att_eval;
  public void set_eval(boolean a_eval){
	att_eval = a_eval;
  }
  public boolean get_eval(){
	return att_eval;
  }
  Program att_ast;
  public void set_ast(Program a_ast){
	att_ast = a_ast;
  }
  public Program get_ast(){
	return att_ast;
  }
  LEX_MiniJava att_scanner;
  public void set_scanner(LEX_MiniJava a_scanner){
	att_scanner = a_scanner;
  }
  public LEX_MiniJava get_scanner(){
	return att_scanner;
  }
  }
