package ac.tec.ic.ic4700.lispexpr.eval.impl;

import ac.tec.ic.ic4700.collections.tree.KTree;
import ac.tec.ic.ic4700.lispexpr.parser.impl.StringLineParser;
import ac.tec.ic.ic4700.lispexpr.parser.tokens.Token;
import ac.tec.ic.ic4700.lispexpr.parser.tokens.impl.BooleanToken;
import ac.tec.ic.ic4700.lispexpr.parser.tokens.impl.NaturalToken;
import org.junit.Test;

import java.io.StringReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author: diegomunguia
 */
public class DefaultEvaluatorImplTest {

    @Test
    public void testGetInstance() throws Exception {
        DefaultEvaluatorImpl instance = DefaultEvaluatorImpl.getInstance();

        assertNotNull(instance);
    }

    @Test
    public void testEvaluateLeafNatural() throws Exception {
        StringLineParser parser = StringLineParser.getInstance();
        KTree<Token> expr = parser.parse(new StringReader("1"));

        DefaultEvaluatorImpl evaluator = DefaultEvaluatorImpl.getInstance();
        NaturalToken result = (NaturalToken) evaluator.evaluate(expr);

        assertEquals(new Integer(1), result.getValue());
    }

    @Test
    public void testEvaluateLeafBoolean() throws Exception {
        StringLineParser parser = StringLineParser.getInstance();
        KTree<Token> expr = parser.parse(new StringReader("#t"));

        DefaultEvaluatorImpl evaluator = DefaultEvaluatorImpl.getInstance();
        BooleanToken result = (BooleanToken) evaluator.evaluate(expr);

        assertEquals(true, result.getValue());
    }

    @Test
    public void testEvaluateUnary() throws Exception {
        StringLineParser parser = StringLineParser.getInstance();
        KTree<Token> expr = parser.parse(new StringReader("(not #t)"));

        DefaultEvaluatorImpl evaluator = DefaultEvaluatorImpl.getInstance();
        BooleanToken result = (BooleanToken) evaluator.evaluate(expr);

        assertEquals(false, result.getValue());
    }

    @Test
    public void testEvaluateBinary() throws Exception {
        StringLineParser parser = StringLineParser.getInstance();
        KTree<Token> expr = parser.parse(new StringReader("(+ 1 1)"));

        DefaultEvaluatorImpl evaluator = DefaultEvaluatorImpl.getInstance();
        NaturalToken result = (NaturalToken) evaluator.evaluate(expr);

        assertEquals(new Integer(2), result.getValue());
    }

    @Test
    public void testEvaluateComplexExpression() throws Exception {
        StringLineParser parser = StringLineParser.getInstance();
        KTree<Token> expr = parser.parse(new StringReader("(not (or (> (+ (* 3 2) (modulo 13 3)) (quotient (- 5 1) 3)) (and (<= (* 2 1) (- 7 3)) (= (* 2 2) (+ 2 2)))))"));

        DefaultEvaluatorImpl evaluator = DefaultEvaluatorImpl.getInstance();
        BooleanToken result = (BooleanToken) evaluator.evaluate(expr);

        assertEquals(false, result.getValue());
    }
}