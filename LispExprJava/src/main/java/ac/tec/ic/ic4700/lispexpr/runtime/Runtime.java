package ac.tec.ic.ic4700.lispexpr.runtime;

import ac.tec.ic.ic4700.lispexpr.parser.tokens.Token;

/**
 * @author: diegomunguia
 */
public interface Runtime {
    UnaryOperator getUnaryOp(Token identifier);
    BinaryOperator getBinaryOp(Token identifier);
}
