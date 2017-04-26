/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Assignable;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.FieldDeclaration;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * @author Marc Pantel
 *
 */
public class FieldAssignmentImpl extends FieldAccessImpl implements Assignable {

	/**
	 * Construction for the implementation of a record field assignment expression Abstract Syntax Tree node.
	 * @param _record Abstract Syntax Tree for the record part in a record field assignment expression.
	 * @param _name Name of the field in the record field assignment expression.
	 */
	public FieldAssignmentImpl(Expression _record, String _name) {
		super(_record, _name);
	}

	/**
	 * Construction for the implementation of a record field assignment expression Abstract Syntax Tree node.
	 * @param _record Abstract Syntax Tree for the record part in a record field assignment expression.
	 * @param _field Abstract Syntax Tree for the field declaration in a record field assignment expression.
	 */
	public FieldAssignmentImpl(Expression _record, FieldDeclaration _field) {
		super(_record, _field);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.impl.FieldAccessImpl#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		//CF. Classe AssignmentImpl ou tout se fait.
		throw new SemanticsUndefinedException("Semantics getCode undefined in FieldAssignmentImpl.");
	}
	
}
