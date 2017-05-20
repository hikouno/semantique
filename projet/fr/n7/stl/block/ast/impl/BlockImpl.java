/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.InterfaceDeclaration;
import fr.n7.stl.block.ast.ClasseDeclaration;
import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.UndeclaredInstanceDeclaration;
import fr.n7.stl.block.ast.Instruction;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for an instruction block.
 * @author Marc Pantel
 *
 */
public class BlockImpl implements Block {

	/**
	 * Sequence of instructions contained in a block.
	 */
	protected List<Instruction> instructions;

	/**
	 * Hierarchical structure of blocks.
	 * Link to the container block.
	 * 
	 */
	protected Optional<Block> context;
	
	private int memAllouee = 0;
	
	/**
	 * Constructor for a block contained in a _context block.
	 * @param _context Englobing block.
	 */
	public BlockImpl(Block _context) {
		assert( _context != null);
		this.instructions = new LinkedList<Instruction>();
		if (_context == null) {
			this.context = Optional.empty();
		} else {
			this.context = Optional.of(_context);
		}
	}
	
	/**
	 * Constructor for a block root of the block hierarchy.
	 */
	public BlockImpl() {
		this.instructions = new LinkedList<Instruction>();
		this.context = Optional.empty();
	}

	/* (non-Javadoc)
	 * @see fr.n7.block.ast.Block#add(fr.n7.block.ast.Instruction)
	 */
	@Override
	public void add(Instruction _instruction) {
		this.instructions.add(_instruction);
	}


	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#addAll(java.lang.Iterable)
	 */
	@Override
	public void addAll(Iterable<Instruction> _instructions) {
		for (Instruction i : _instructions) {
			this.instructions.add(i);
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String _local = "";
		for (Instruction _instruction : this.instructions) {
			_local += "    " + _instruction;
		}
		return "{\n" + _local + "}\n" ;
	}

	/**
	 * Synthesized Semantics attribute to check if the AST is well formed according
	 * to the scope.
	 * @return The new AST with undeclared references replaces by actual ones.
	 */	
	@Override
	public Block toDeclared(List<InterfaceDeclaration> interfaces, List<ClasseDeclaration> classes, Classe classeMere) throws ToDeclaredException {
		
		//Try to build a new declared instruction list.
		String errorMsg = "";
		
		LinkedList<Instruction> nouvListe = new LinkedList<Instruction>();
	  	for(Instruction instr : instructions) {
			
			try {
				nouvListe.add( instr.toDeclared(interfaces, classes, classeMere) );
			} catch (ToDeclaredException e) {
				errorMsg += e.getMessage() + "\n";
			} catch (NullPointerException e) {
				errorMsg += "Instruction nulle dans le bloc.\n";
			}
		}
		
		if (!errorMsg.equals("")) //Exception ?
			throw new ToDeclaredException(errorMsg);
		
		//Create the new declared block with the list
		Block block_declared;
		if (context.isPresent()) {
			block_declared = new BlockImpl(context.get());
		} else {
			block_declared = new BlockImpl();
		}
		
		block_declared.addAll(nouvListe);
		
		return block_declared;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#checkType()
	 */
	@Override
	public boolean checkType() {
		for (Instruction instr : instructions) {
			if (!instr.checkType())
				return false;
		}
		
		return true;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		int local = _offset;
		for (Instruction _instr : instructions) {
			local += _instr.allocateMemory(_register, local);
		}
		
		this.memAllouee = local - _offset;
		
		return local - _offset;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#generateCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment res = _factory.createFragment();
		for (Instruction i : instructions) {
			res.append(i.getCode(_factory));
		}
		if (memAllouee != 0) res.add(_factory.createPop(0, memAllouee));
		
		return res;
	}

}
