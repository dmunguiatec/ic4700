package ac.tec.ic.ic4700.lispexpr.locators;

import ac.tec.ic.ic4700.lispexpr.eval.Evaluator;
import ac.tec.ic.ic4700.lispexpr.eval.impl.DefaultEvaluatorImpl;
import ac.tec.ic.ic4700.lispexpr.parser.Parser;
import ac.tec.ic.ic4700.lispexpr.parser.impl.StringLineParser;
import ac.tec.ic.ic4700.lispexpr.runtime.Runtime;
import ac.tec.ic.ic4700.lispexpr.runtime.impl.DefaultRuntimeImpl;

/**
 * @author: diegomunguia
 */
public class ServiceLocator { // patrón IoC

    public static Parser getParser() {
        return StringLineParser.getInstance();
    }

    public static Evaluator getEvaluator() {
        return DefaultEvaluatorImpl.getInstance();
    }

    public static Runtime getRuntime() {
        return DefaultRuntimeImpl.getInstance();
    }
}
