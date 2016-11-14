package ac.tec.ic.ic4700.lispexpr.parser;

import ac.tec.ic.ic4700.collections.tree.KTree;
import ac.tec.ic.ic4700.lispexpr.parser.tokens.Token;

import java.io.Reader;

/**
 * @author: diegomunguia
 */
public interface Parser {
    KTree<Token> parse(Reader input);
}
