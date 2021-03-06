/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;
import java.util.Optional;

import fr.n7.stl.block.ast.impl.MembreClasseAccessImpl.Identifier;

import fr.n7.stl.block.ast.Assignable;
import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.BinaryOperator;
import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.BlockFactory;
import fr.n7.stl.block.ast.BooleanValue;
//import fr.n7.stl.block.ast.Sequence;
import fr.n7.stl.block.ast.ConstantDeclaration;
import fr.n7.stl.block.ast.InterfaceDeclaration;
import fr.n7.stl.block.ast.ClasseDeclaration;
import fr.n7.stl.block.ast.ClasseInstanceDeclaration;
import fr.n7.stl.block.ast.InterfaceInstanceDeclaration;
import fr.n7.stl.block.ast.UndeclaredInstanceDeclaration;
import fr.n7.stl.block.ast.Expression;
//import fr.n7.stl.block.ast.FieldDeclaration;
//import fr.n7.stl.block.ast.FunctionCall;
import fr.n7.stl.block.ast.Instruction;
//import fr.n7.stl.block.ast.RecordType;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.Interface;
import fr.n7.stl.block.ast.Classe;
//import fr.n7.stl.block.ast.TypeDeclaration;
import fr.n7.stl.block.ast.UnaryOperator;
import fr.n7.stl.block.ast.Value;
import fr.n7.stl.block.ast.VariableDeclaration;

/**
 * Implementation of the factory for building Abstract Syntax Tree node for the Bloc language.
 * @author Marc Pantel
 *
 */
public class BlockFactoryImpl implements BlockFactory {

    /**
     * 
     */
    public BlockFactoryImpl() {
        
    }
    
    /**
     * Create an Abstract Syntax Tree node for the InterfaceDeclaration type.
     * @return Abstract Syntax Tree node for the InterfaceDeclaration type.
     */
    public InterfaceDeclaration createInterfaceDeclaration(Interface interf) {
        return new InterfaceDeclarationImpl(interf);
    }
    
    /**
     * Create an Abstract Syntax Tree node for the ClasseDeclaration type.
     * @return Abstract Syntax Tree node for the ClasseDeclaration type.
     */
    public ClasseDeclaration createClasseDeclaration(Classe classe) {
        return new ClasseDeclarationImpl(classe);
    }
    
    /**
     * Create an Abstract Syntax Tree node for the ClasseInstanceDeclaration type.
     * @return Abstract Syntax Tree node for the ClasseInstanceDeclaration type.
     */
    public ClasseInstanceDeclaration createClasseInstanceDeclaration(String nom, Type type, Expression value) {
        return new ClasseInstanceDeclarationImpl(nom, type, value);
    }

    /**
     * Create an Abstract Syntax Tree node for the InterfaceInstanceDeclaration type.
     * @return Abstract Syntax Tree node for the InterfaceInstanceDeclaration type.
     */
    public InterfaceInstanceDeclaration createInterfaceInstanceDeclaration(String nom, Type type, Expression value) {
        return new InterfaceInstanceDeclarationImpl(nom, type, value);
    }
    
    
    /**
	 * Create an Abstract Syntax Tree node for the UndefinedInstanceDeclaration type.
	 * @return Abstract Syntax Tree node for the UndefinedInstanceDeclaration type.
	 */
	public UndeclaredInstanceDeclaration createUndeclaredInstanceDeclaration(String nom, String typeNom, Expression value) {
        return new UndeclaredInstanceDeclarationImpl(nom, typeNom, value);
    }
    
    /**
	 * Create an Abstract Syntax Tree node for the ClasseInstanceAllocation type.
	 * @return Abstract Syntax Tree node for the ClasseInstanceAllocation type.
	 */
    public Expression createUndeclaredAllocation(String nom, LinkedList<Expression> args) {
        return new UndeclaredAllocationImpl(nom, args);
    }
    
    /**
     * Create an Abstract Syntax Tree node for the ClasseInstanceAllocation type.
     * @return Abstract Syntax Tree node for the ClasseInstanceAllocation type.
     */
    public Expression createClasseInstanceAllocation(Classe classe, LinkedList<Expression> args) {
        return new ClasseInstanceAllocationImpl(classe, args);
    }
    
    /* (non-Javadoc)
     * @see fr.n7.block.ast.ASTFactory#createBinaryExpression(fr.n7.block.ast.Expression, fr.n7.block.ast.Expression)
     */
    @Override
    public Expression createBinaryExpression(Expression _left, BinaryOperator _operator, Expression _right) {
        return new BinaryExpressionImpl(_left,_operator,_right);
    }

    /* (non-Javadoc)
     * @see fr.n7.block.ast.ASTFactory#createIntegerValue()
     */
    @Override
    public Value createIntegerValue(String _texte) {
        return new IntegerValueImpl(_texte);
    }
    
    /* (non-Javadoc)
     * @see fr.n7.block.ast.ASTFactory#createCharValue()
     */
    @Override
    public Value createCharValue(String _texte) {
		return new CharValueImpl(_texte);
	}
	
	
	/* (non-Javadoc)
     * @see fr.n7.block.ast.ASTFactory#createStringValue()
     */
    @Override
    public Value createStringValue(String _texte) {
		return new StringValueImpl(_texte);
	}

    /* (non-Javadoc)
     * @see fr.n7.block.ast.ASTFactory#createBlock()
     */
    @Override
    public Block createBlock(Block _context) {
        return new BlockImpl(_context);
    }

    /* (non-Javadoc)
     * @see fr.n7.block.ast.ASTFactory#createVariableDeclaration(java.lang.String, fr.n7.block.ast.Type, fr.n7.block.ast.Expression)
     */
    @Override
    public VariableDeclaration createVariableDeclaration(String _name, Type _type, Expression _initialValue) {
        return new VariableDeclarationImpl(_name,_type,_initialValue);
    }
    
    /* (non-Javadoc)
     */
    public Type createInterfaceType(Interface interf) {
        return new InterfaceTypeImpl(interf);
    }
    
    /* (non-Javadoc)
     */
    @Override
    public Type createClasseType(Classe classe) {
        return new ClasseTypeImpl(classe);
    }
    
    /* (non-Javadoc)
     * @see fr.n7.block.ast.ASTFactory#createIntegerType()
     */
    @Override
    public Type createIntegerType() {
        return AtomicType.IntegerType;
    }

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.ExpressionFactory#createUnaryExpression(fr.n7.stl.block.ast.UnaryOperator, fr.n7.stl.block.ast.Expression)
     */
    @Override
    public Expression createUnaryExpression(UnaryOperator _operator, Expression _parameter) {
        return new UnaryExpressionImpl(_operator,_parameter);
    }

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.ExpressionFactory#createVariableUse(fr.n7.stl.block.ast.VariableDeclaration)
     */
    @Override
    public Expression createVariableUse(VariableDeclaration _declaration) {
        return new VariableUseImpl(_declaration);
    }
    
	/**
	* Create a node for a variable use expression in the Abstract Syntax Tree.
	* with resolving the reference with the Symbol Table.	 
	* @return Abstract Syntax Tree node for the access to a variable.
	*/
	public Expression createUndeclaredAccess_use(UndeclaredInstanceUseImpl _use, String nom) {
		UndeclaredAccessImpl access = new UndeclaredAccessImpl(_use);
		access.setNomAcces(nom);

		return access;
	}

	/**
	* Create a node for a variable use expression in the Abstract Syntax Tree.
	* with resolving the reference with the Symbol Table.	 
	* @return Abstract Syntax Tree node for the access to a variable.
	*/
	public Expression createUndeclaredAccess_access(UndeclaredAccessImpl _access, String nom) {
		UndeclaredAccessImpl access = new UndeclaredAccessImpl(_access);
		access.setNomAcces(nom);

		return access;
	}
    
    /**
     * Create a node for a variable use expression in the Abstract Syntax Tree.
     * with resolving the reference with the Symbol Table.   
     * @param _declaration Abstract Syntax Tree node for the declaration of the variable.
     * @return Abstract Syntax Tree node for the access to a variable.
     */
    public Expression createInstanceUse(ClasseInstanceDeclaration _declaration) {
        return new InstanceUseImpl(_declaration);
    }
    
    /**
     * Create a node for a variable use expression in the Abstract Syntax Tree.
     * with resolving the reference with the Symbol Table.   
     * @return Abstract Syntax Tree node for the access to a variable.
     */
    public Expression createInstanceAccess_use(InstanceUseImpl _use, String nom) {
        InstanceAccessImpl access = new InstanceAccessImpl(_use);
        access.setNomAcces(nom);
        
        return access;
    }
    
    /**
     * Create a node for a variable use expression in the Abstract Syntax Tree.
     * with resolving the reference with the Symbol Table.   
     * @return Abstract Syntax Tree node for the access to a variable.
     */
    public Expression createInstanceAccess_access(InstanceAccessImpl _access, String nom) {
        InstanceAccessImpl access = new InstanceAccessImpl(_access);
        access.setNomAcces(nom);
        
        return access;
    }
    
    /**
	* Create a node for a variable use expression in the Abstract Syntax Tree.
	* with resolving the reference with the Symbol Table.	 
	* @return Abstract Syntax Tree node for the access to a variable.
	*/
	public Expression createMembreClasseAccess_identifier(Identifier _identifier, String nom) {
        MembreClasseAccessImpl access = new MembreClasseAccessImpl(_identifier);
        if (!nom.equals("")) access.setNomAcces(nom);
        
        return access;
    }
    
    /**
	* Create a node for a variable use expression in the Abstract Syntax Tree.
	* with resolving the reference with the Symbol Table.	 
	* @return Abstract Syntax Tree node for the access to a variable.
	*/
	public Expression createMembreClasseAccess_access(MembreClasseAccessImpl _access, String nom) {
        MembreClasseAccessImpl access = new MembreClasseAccessImpl(_access);
        access.setNomAcces(nom);
        
        return access;
    }
    
    
    /**
	* Create a node for a variable use expression in the Abstract Syntax Tree.
	* with resolving the reference with the Symbol Table.	 
	* @return Abstract Syntax Tree node for the access to a variable.
	*/
	public Assignable createMembreClasseAccessAssignment_identifier(Identifier _identifier, String nom) {
        MembreClasseAccessAssignmentImpl assignment = new MembreClasseAccessAssignmentImpl(_identifier);
        if (!nom.equals("")) assignment.setNomAcces(nom);
        
        return assignment;
    }
    
    /**
	* Create a node for a variable use expression in the Abstract Syntax Tree.
	* with resolving the reference with the Symbol Table.	 
	* @return Abstract Syntax Tree node for the access to a variable.
	*/
	public Assignable createMembreClasseAccessAssignment_access(MembreClasseAccessImpl _access) {
		return new MembreClasseAccessAssignmentImpl(_access, true);
	}
    
    public Assignable createMembreClasseAccessAssignment_accesstxt(MembreClasseAccessImpl _access, String txt) {
		MembreClasseAccessAssignmentImpl m = new MembreClasseAccessAssignmentImpl(_access, (_access.getNomAcces() == null));
        m.setNomAcces(txt);
        
        return m;
	}
    
    /**
	* Create a node for a variable use expression in the Abstract Syntax Tree.
	* with resolving the reference with the Symbol Table.	 
	* @return Abstract Syntax Tree node for the access to a variable.
	*/
	public Assignable createUndeclaredAccessAssignment_dec(UndeclaredInstanceDeclaration _dec) {
		return new UndeclaredAccessAssignmentImpl(_dec);
	}
	
	/**
	* Create a node for a variable use expression in the Abstract Syntax Tree.
	* with resolving the reference with the Symbol Table.	 
	* @return Abstract Syntax Tree node for the access to a variable.
	*/
	public Assignable createUndeclaredAccessAssignment_access(UndeclaredAccessImpl _access) {
		return new UndeclaredAccessAssignmentImpl(_access);
	}
    
    /**
     * Create a node for an undeclared variable use expression in the Abstract Syntax Tree.
     * with resolving the reference with the Symbol Table.   
     * @return Abstract Syntax Tree node for the access to a variable.
     */
    public Expression createUndeclaredInstanceUse(UndeclaredInstanceDeclaration _declaration) {
        return new UndeclaredInstanceUseImpl(_declaration);
    }
    
    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.ExpressionFactory#createVariableAssignment(fr.n7.stl.block.ast.VariableDeclaration)
     */
    @Override
    public Assignable createVariableAssignment(VariableDeclaration _declaration) {
        return new VariableAssignmentImpl(_declaration);
    }

    /**
	* Create a node for an instance assignment expression in the Abstract Syntax Tree.
	* with resolving the reference with the Symbol Table.	 
	* @return Abstract Syntax Tree node for the assignment.
	*/
	public Assignable createInstanceAssignment_dec(ClasseInstanceDeclaration _declaration) {
        return new InstanceAssignmentImpl(_declaration);
    }
    
    /**
	* Create a node for an instance assignment expression in the Abstract Syntax Tree.
	* with resolving the reference with the Symbol Table.	 
	* @return Abstract Syntax Tree node for the assignment.
	*/
	public Assignable createInstanceAssignment_rec(InstanceAccessImpl _access) {
        return new InstanceAssignmentImpl(_access);
    }


    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.InstructionFactory#createConditional(fr.n7.stl.block.ast.Expression, fr.n7.stl.block.ast.Block, fr.n7.stl.block.ast.Block)
     */
    @Override
    public Instruction createConditional(Expression _condition, Block _then, Block _else) {
        return new ConditionalImpl(_condition,_then,_else);
    }

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.InstructionFactory#createRepetition(fr.n7.stl.block.ast.Expression, fr.n7.stl.block.ast.Block)
     */
    @Override
    public Instruction createRepetition(Expression _condition, Block _body) {
        return new RepetitionImpl(_condition,_body);
    }


    @Override
    public Instruction createReturn(Expression expr, MethodImpl methodeMere) {
        return new ReturnImpl(expr, methodeMere);
    }

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.TypeFactory#createBooleanType()
     */
    @Override
    public Type createBooleanType() {
        return AtomicType.BooleanType;
    }

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.TypeFactory#createCoupleType(fr.n7.stl.block.ast.Type, fr.n7.stl.block.ast.Type)
     *
    @Override
    public Type createCoupleType(Type _first, Type _second) {
        return new CoupleTypeImpl( _first, _second);
    } */

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.ExpressionFactory#createCouple(fr.n7.stl.block.ast.Expression, fr.n7.stl.block.ast.Expression)
     *
    @Override
    public Expression createCouple(Expression _first, Expression _second) {
        return new CoupleImpl(_first, _second);
    } */

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.InstructionFactory#createPrinter(fr.n7.stl.block.ast.Expression)
     */
    @Override
    public Instruction createPrinter(Expression _value) {
        return new PrinterImpl(_value);
    }

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.ExpressionFactory#createFirst(fr.n7.stl.block.ast.Expression)
     *
    @Override
    public Expression createFirst(Expression _parameter) {
        return new UnaryExpressionImpl(UnaryOperator.First,_parameter);
    } */

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.ExpressionFactory#createSecond(fr.n7.stl.block.ast.Expression)
     *
    @Override
    public Expression createSecond(Expression _parameter) {
        return new UnaryExpressionImpl(UnaryOperator.Second,_parameter);
    } */

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.InstructionFactory#createAssignment(fr.n7.stl.block.ast.VariableDeclaration, fr.n7.stl.block.ast.Expression)
     */
    @Override
    public Instruction createAssignment(VariableDeclaration _declaration, Expression _value) {
        return new AssignmentImpl(_declaration,_value);
    }
    
    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.InstructionFactory#createAssignment(fr.n7.stl.block.ast.VariableDeclaration, fr.n7.stl.block.ast.Expression)
     */
    @Override
    public Instruction createAssignment(Assignable _assignable, Expression _value) {
        return new AssignmentImpl(_assignable,_value);
    }

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.ExpressionFactory#createBooleanValue(boolean)
     */
    @Override
    public Value createBooleanValue(boolean _value) {
        if (_value) {
            return BooleanValue.True;
        } else {
            return BooleanValue.False;
        }
    }

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.ExpressionFactory#createFunctionCall(fr.n7.stl.block.ast.Expression)
     *
    @Override
    public FunctionCall createFunctionCall(Expression _function) {
        return new FunctionCallImpl(_function);
    } */

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.ExpressionFactory#createArrayAccess(fr.n7.stl.block.ast.Expression, fr.n7.stl.block.ast.Expression)
     */
    @Override
    public Expression createArrayAccess(Expression _array, Expression _index) {
        return new ArrayAccessImpl(_array,_index);
    }
    
    /*@Override
    public Expression createArrayAllocation(Type _type, Expression _expr) {
        return new ArrayAllocationImpl(_type, _expr);
    }*/
    
    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.ExpressionFactory#createArrayAssignment(fr.n7.stl.block.ast.Assignable, fr.n7.stl.block.ast.Expression)
     */
    @Override
    public Assignable createArrayAssignment(Assignable _array, Expression _index) {
        return new ArrayAssignmentImpl(_array,_index);
    }

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.ExpressionFactory#createFieldAccess(fr.n7.stl.block.ast.Expression, fr.n7.stl.block.ast.FieldDeclaration)
     *
    @Override
    public Expression createFieldAccess(Expression _record, FieldDeclaration _field) {
        return new FieldAccessImpl(_record,_field);
    } */
    
    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.ExpressionFactory#createFieldAssignment(fr.n7.stl.block.ast.Assignable, fr.n7.stl.block.ast.FieldDeclaration)
     *
    @Override
    public Assignable createFieldAssignment(Assignable _record, FieldDeclaration _field) {
        return new FieldAssignmentImpl(_record,_field);
    } */

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.ExpressionFactory#createFieldAccess(fr.n7.stl.block.ast.Expression, java.lang.String)
     *
    @Override
    public Expression createFieldAccess(Expression _record, String _name) {
        return new FieldAccessImpl(_record, _name);
    }
    
    @Override
    public Assignable createFieldAssignment(Assignable _record, String _name) {
        return new FieldAssignmentImpl(_record, _name);
    } */
    
    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.InstructionFactory#createBlock()
     */
    @Override
    public Block createBlock() {
        return createBlock((Block)null);
    }

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.InstructionFactory#createBlock(java.lang.Iterable)
     */
    @Override
    public Block createBlock(Iterable<Instruction> _content) {
        Block _local = createBlock();
        _local.addAll(_content);
        return _local;
    }

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.InstructionFactory#createBlock(fr.n7.stl.block.ast.Block, java.lang.Iterable)
     */
    @Override
    public Block createBlock(Block _context, Iterable<Instruction> _content) {
        Block _local = createBlock(_context);
        _local.addAll(_content);
        return _local;
    }

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.InstructionFactory#createConditional(fr.n7.stl.block.ast.Expression, fr.n7.stl.block.ast.Block)
     */
    @Override
    public Instruction createConditional(Expression _condition, Block _then) {
        return new ConditionalImpl(_condition,_then);
    }

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.TypeFactory#createRecordType(java.lang.Iterable)
     *
    @Override
    public RecordType createRecordType(String _name, Iterable<FieldDeclaration> _fields) {
        return new RecordTypeImpl(_name, _fields);
    } */

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.TypeFactory#createRecordType()
     *
    @Override
    public RecordType createRecordType(String _name) {
        return new RecordTypeImpl(_name);
    } */

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.InstructionFactory#createConstantDeclaration(java.lang.String, fr.n7.stl.block.ast.Type, fr.n7.stl.block.ast.Expression, fr.n7.stl.block.ast.Interface)
     */
    @Override
    public ConstantDeclaration createConstantDeclaration(String _name, Type _type, Expression _value) {
          return new ConstantDeclarationImpl(_name,_type,_value);
    }

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.InstructionFactory#createTypeDeclaration(java.lang.String, fr.n7.stl.block.ast.Type)
     *
    @Override
    public TypeDeclaration createTypeDeclaration(String _name, Type _type) {
        return new TypeDeclarationImpl(_name,_type);
    } */

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.TypeFactory#createArrayType(fr.n7.stl.block.ast.Type)
     */
    @Override
    public Type createArrayType(Type _element) {
        return new ArrayTypeImpl(_element);
    }

	/**
	 * Create an Abstract Syntax Tree node for the UndeclaredType type.
	 * @return Abstract Syntax Tree node for the UndeclaredType type.
	 */
	public Type createUndeclaredType(String nom) {
		return new UndeclaredTypeImpl(nom);
	}

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.TypeFactory#createPointerType(fr.n7.stl.block.ast.Type)
     *
    @Override
    public Type createPointerType(Type _element) {
        return new PointerTypeImpl(_element);
    } */

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.TypeFactory#createFunctionType(fr.n7.stl.block.ast.Type, java.lang.Iterable)
     *
    @Override
    public Type createFunctionType(Type _result, Iterable<Type> _parameters) {
        return new FunctionTypeImpl(_result,_parameters);
    } */

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.TypeFactory#createFieldDeclaration(java.lang.String, fr.n7.stl.block.ast.Type)
     *
    @Override
    public FieldDeclaration createFieldDeclaration(String _name, Type _type) {
        return new FieldDeclarationImpl(_name,_type);
    } */

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.ExpressionFactory#createTypeConversion(fr.n7.stl.block.ast.Expression, fr.n7.stl.block.ast.Type)
     *
    @Override
    public Expression createTypeConversion(Expression _target, Type _type) {
        return new TypeConversionImpl(_target,_type);
    } */

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.ExpressionFactory#createCollection()
     *
    @Override
    public Sequence createSequence() {
        return new SequenceImpl();
    }*/

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.ExpressionFactory#createCollection(java.lang.Iterable)
     *
    @Override
    public Sequence createSequence(Iterable<Expression> _values) {
        return new SequenceImpl(_values);
    }*/

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.TypeFactory#createNamedType(fr.n7.stl.block.ast.TypeDeclaration)
     *
    @Override
    public Type createNamedType(TypeDeclaration _declaration) {
        return new NamedTypeImpl(_declaration);
    }
    
    @Override
    public Expression createAddressAccess(Expression _expr) {
        return new AddressAccessImpl(_expr);
    } */
    
    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.ExpressionFactory#createPointerAccess(fr.n7.stl.block.ast.Expression)
     *
    @Override
    public Expression createPointerAccess(Expression _pointer) {
        return new PointerAccessImpl(_pointer);
    }
    
    @Override
    public Expression createPointerAllocation(Type _type) {
        return new PointerAllocationImpl(_type);
    } */
    
    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.ExpressionFactory#createPointerAssignment(fr.n7.stl.block.ast.Assignable)
     *
    @Override
    public Assignable createPointerAssignment(Assignable _pointer) {
        return new PointerAssignmentImpl(_pointer);
    } */

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.TypeFactory#createFloatingType()
     */
    @Override
    public Type createFloatingType() {
        return AtomicType.FloatingType;
    }

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.TypeFactory#createCharType()
     */
    @Override
    public Type createCharType() {
        return AtomicType.CharacterType;
    }

    /* (non-Javadoc)
     * @see fr.n7.stl.block.ast.TypeFactory#createStringType()
     */
    @Override
    public Type createStringType() {
        return AtomicType.StringType;
    }

}
