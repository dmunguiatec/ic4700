package ac.tec.ic.ic4700.lispexpr.eval;

import ac.tec.ic.ic4700.collections.tree.KTree;
import ac.tec.ic.ic4700.lispexpr.parser.tokens.Token;

/**
 * @author: diegomunguia
 */
public interface Evaluator {
    Token evaluate(KTree<Token> expr);
}
