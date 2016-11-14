package ac.tec.ic.ic4700.lispexpr.parser.impl;

import ac.tec.ic.ic4700.collections.tree.KTree;
import ac.tec.ic.ic4700.lispexpr.parser.Parser;
import ac.tec.ic.ic4700.lispexpr.parser.tokens.Token;
import org.junit.Test;

import java.io.StringReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author: diegomunguia
 */
public class StringLineParserTest {

    @Test
    public void testGetInstance() throws Exception {
        Parser instance = StringLineParser.getInstance();

        assertNotNull(instance);
    }

    @Test
    public void testParseBoolean() throws Exception {
        Parser parser = StringLineParser.getInstance();

        String expr = "#t";
        KTree<Token> tree = parser.parse(new StringReader(expr));

        assertEquals(expr, tree.toString());
    }

    @Test
    public void testParseNatural() throws Exception {
        Parser parser = StringLineParser.getInstance();

        String expr = "12345";
        KTree<Token> tree = parser.parse(new StringReader(expr));

        assertEquals(expr, tree.toString());
    }

    @Test
    public void testParseFunctionCall() throws Exception {
        Parser parser = StringLineParser.getInstance();

        String expr = "(+ 1 2)";
        KTree<Token> tree = parser.parse(new StringReader(expr));

        assertEquals(expr, tree.toString().replace('[', '(').replace(']', ')'));
    }

    @Test
    public void testParseNestedFunctionCalls() throws Exception {
        Parser parser = StringLineParser.getInstance();

        String expr = "(+ (* (modulo 3 2) 2) (- 10 3))";
        KTree<Token> tree = parser.parse(new StringReader(expr));

        assertEquals(expr, tree.toString().replace('[', '(').replace(']', ')'));
    }
}