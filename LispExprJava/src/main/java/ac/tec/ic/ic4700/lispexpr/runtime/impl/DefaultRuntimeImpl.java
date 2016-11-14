package ac.tec.ic.ic4700.lispexpr.runtime.impl;

import ac.tec.ic.ic4700.lispexpr.parser.tokens.Token;
import ac.tec.ic.ic4700.lispexpr.parser.tokens.impl.BooleanToken;
import ac.tec.ic.ic4700.lispexpr.parser.tokens.impl.NaturalToken;
import ac.tec.ic.ic4700.lispexpr.runtime.BinaryOperator;
import ac.tec.ic.ic4700.lispexpr.runtime.Runtime;
import ac.tec.ic.ic4700.lispexpr.runtime.UnaryOperator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: diegomunguia
 */
public class DefaultRuntimeImpl implements Runtime {

    private static final String UNARY_NOT = "not";
    private static final String BINARY_ADD = "+";
    private static final String BINARY_SUB = "-";
    private static final String BINARY_MUL = "*";
    private static final String BINARY_QUO = "quotient";
    private static final String BINARY_MOD = "modulo";
    private static final String BINARY_EQ = "=";
    private static final String BINARY_LT = "<";
    private static final String BINARY_LE = "<=";
    private static final String BINARY_GT = ">";
    private static final String BINARY_GE = ">=";
    private static final String BINARY_AND = "and";
    private static final String BINARY_OR = "or";

    private static DefaultRuntimeImpl instance = null;

    private Map<String, UnaryOperator> unaries = new HashMap<>();
    private Map<String, BinaryOperator> binaries = new HashMap<>();

    private DefaultRuntimeImpl() {
        // initialize runtime unary operations
        unaries.put(UNARY_NOT, a -> new BooleanToken(!((BooleanToken) a).getValue()));

        // initialize runtime binary operations
        binaries.put(BINARY_ADD, (a, b) -> new NaturalToken(((NaturalToken)a).getValue() + ((NaturalToken)b).getValue()));
        binaries.put(BINARY_SUB, (a, b) -> new NaturalToken(((NaturalToken)a).getValue() - ((NaturalToken)b).getValue()));
        binaries.put(BINARY_MUL, (a, b) -> new NaturalToken(((NaturalToken)a).getValue() * ((NaturalToken)b).getValue()));
        binaries.put(BINARY_QUO, (a, b) -> new NaturalToken(((NaturalToken)a).getValue() / ((NaturalToken)b).getValue()));
        binaries.put(BINARY_MOD, (a, b) -> new NaturalToken(((NaturalToken)a).getValue() % ((NaturalToken)b).getValue()));

        binaries.put(BINARY_EQ, (a, b) -> new BooleanToken(((NaturalToken)a).getValue().equals(((NaturalToken)b).getValue())));
        binaries.put(BINARY_LT, (a, b) -> new BooleanToken(((NaturalToken)a).getValue() < ((NaturalToken)b).getValue()));
        binaries.put(BINARY_LE, (a, b) -> new BooleanToken(((NaturalToken)a).getValue() <= ((NaturalToken)b).getValue()));
        binaries.put(BINARY_GT, (a, b) -> new BooleanToken(((NaturalToken)a).getValue() > ((NaturalToken)b).getValue()));
        binaries.put(BINARY_GE, (a, b) -> new BooleanToken(((NaturalToken)a).getValue() >= ((NaturalToken)b).getValue()));

        binaries.put(BINARY_AND, (a, b) -> (new BooleanToken(((BooleanToken)a).getValue() && ((BooleanToken)b).getValue())));
        binaries.put(BINARY_OR, (a, b) -> (new BooleanToken(((BooleanToken)a).getValue() || ((BooleanToken)b).getValue())));
    }

    public static DefaultRuntimeImpl getInstance() {
        if (instance == null) {
            instance = new DefaultRuntimeImpl();
        }

        return instance;
    }


    @Override
    public UnaryOperator getUnaryOp(Token identifier) {
        return this.unaries.get(identifier.getImage());
    }

    @Override
    public BinaryOperator getBinaryOp(Token identifier) {
        return this.binaries.get(identifier.getImage());
    }
}
