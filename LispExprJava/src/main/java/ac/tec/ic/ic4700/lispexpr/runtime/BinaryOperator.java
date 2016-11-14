package ac.tec.ic.ic4700.lispexpr.runtime;

import ac.tec.ic.ic4700.lispexpr.parser.tokens.Token;

/**
 * @author: diegomunguia
 */
public interface BinaryOperator {
    Token apply(Token a, Token b);
}
