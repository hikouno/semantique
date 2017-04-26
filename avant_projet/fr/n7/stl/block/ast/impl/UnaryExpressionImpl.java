/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.CoupleType;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.UnaryOperator;
import fr.n7.stl.block.ast.VariableDeclaration;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;

/**
 * Implementation of the Abstract Syntax Tree node for an unary operation expression.
 * @author Marc Pantel
 *
 */
public class UnaryExpressionImpl implements Expression {

	private UnaryOperator operator;
	private Expression parameter;
	
	/**
	 * Builds a unary expression Abstract Syntax Tree node from the parameter sub-expression
	 * and the unary operation.
	 * @param _operator : Unary Operator.
	 * @param _parameter : Expression for the parameter.
	 */
	public UnaryExpressionImpl(UnaryOperator _operator, Expression _parameter) {
		this.operator = _operator;
		this.parameter = _parameter;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(" + this.operator + " " + this.parameter + ")";
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		Type resultType = this.parameter.getType();
		if (resultType.equals(AtomicType.ErrorType)) {
			return resultType;
		} else {
			switch (this.operator) {
				case Negate: {
					if (resultType.compatibleWith(AtomicType.BooleanType))  {
						return resultType;
					} else {
						Logger.warning("Type error in unary expression : Negate parameter " + resultType);
						return AtomicType.ErrorType;
					}
				}
				case Opposite: {
					if (resultType.compatibleWith(AtomicType.FloatingType)) {
						return resultType;
					} else {
						Logger.warning("Type error in unary expression : Opposite parameter " + resultType);
						return AtomicType.ErrorType;
					}
				}
				case First: {
					if (resultType instanceof CoupleType) {
						return ((CoupleType)resultType).getFirst();
					} else {
						Logger.warning("Type error in unary expression : First parameter " + resultType);
						return AtomicType.ErrorType;
					}
				}
				case Second: {
					if (resultType instanceof CoupleType) {
						return ((CoupleType)resultType).getFirst();
					} else {
						Logger.warning("Type error in unary expression : Second parameter " + resultType);
						return AtomicType.ErrorType;
					}
				}
				default : return AtomicType.ErrorType;
			}
		}
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		
		if (this.operator != UnaryOperator.First && this.operator != UnaryOperator.Second)
		{
			Fragment _code = this.parameter.getCode(_factory);
			_code.add(TAMFactory.createUnaryOperator(this.operator));
			
			System.out.println(_code);
			return _code;
		}
		else
		{
			/*if (parameter instanceof FieldAccessImpl) {
				
			}  
			* 
			* ---OPTIMISATION---
			* 
			else if (parameter instanceof VariableUseImpl) {
				VariableDeclaration declaration = ((VariableUseImpl) parameter).getDeclaration();
				SequenceImpl seq = (SequenceImpl) declaration.getValue();
				
				return (operator == UnaryOperator.First) ? seq.getValues().get(0).getCode(_factory) :
																	seq.getValues().get(1).getCode(_factory);
			}*/
			
			Fragment _code = this.parameter.getCode(_factory);
			if (this.operator == UnaryOperator.First)
				_code.add(_factory.createPop(0,1));
			else
				_code.add(_factory.createPop(1,1));
			
			return _code;
		}
	}

}
