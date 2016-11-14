package ac.tec.ic.ic4700.lispexpr;

import ac.tec.ic.ic4700.lispexpr.eval.Evaluator;
import ac.tec.ic.ic4700.lispexpr.eval.impl.DefaultEvaluatorImpl;
import ac.tec.ic.ic4700.lispexpr.locators.ServiceLocator;
import ac.tec.ic.ic4700.lispexpr.parser.Parser;
import ac.tec.ic.ic4700.lispexpr.parser.impl.StringLineParser;
import ac.tec.ic.ic4700.lispexpr.runtime.Runtime;
import ac.tec.ic.ic4700.lispexpr.runtime.impl.DefaultRuntimeImpl;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author: diegomunguia
 */
public class ServiceLocatorTest {

    @Test
    public void testGetParser() throws Exception {
        Parser parser = ServiceLocator.getParser();

        assertNotNull(parser);
        assertTrue(parser instanceof StringLineParser);
    }

    @Test
    public void testGetEvaluator() throws Exception {
        Evaluator evaluator = ServiceLocator.getEvaluator();

        assertNotNull(evaluator);
        assertTrue(evaluator instanceof DefaultEvaluatorImpl);
    }

    @Test
    public void testGetRuntime() throws Exception {
        Runtime runtime = ServiceLocator.getRuntime();

        assertNotNull(runtime);
        assertTrue(runtime instanceof DefaultRuntimeImpl);
    }
}