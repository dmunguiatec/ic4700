package ac.tec.ic.ic4700.lispexpr.eval.impl;

import ac.tec.ic.ic4700.collections.tree.KTree;
import ac.tec.ic.ic4700.lispexpr.eval.Evaluator;
import ac.tec.ic.ic4700.lispexpr.locators.ServiceLocator;
import ac.tec.ic.ic4700.lispexpr.parser.tokens.Token;
import ac.tec.ic.ic4700.lispexpr.runtime.BinaryOperator;
import ac.tec.ic.ic4700.lispexpr.runtime.Runtime;
import ac.tec.ic.ic4700.lispexpr.runtime.UnaryOperator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: diegomunguia
 */
public class DefaultEvaluatorImpl implements Evaluator {

    private static DefaultEvaluatorImpl instance = null;

    private Runtime runtime = ServiceLocator.getRuntime();

    private DefaultEvaluatorImpl() {}

    public static DefaultEvaluatorImpl getInstance() {
        if (instance == null) {
            instance = new DefaultEvaluatorImpl();
        }

        return instance;
    }

    @Override
    public Token evaluate(KTree<Token> expr) {
        Token result;
        if (expr.isLeaf()) {
            result = expr.getValue();
        } else {
            // evaluar los parámetros
            List<Token> params = new ArrayList<>(expr.getChildren().size());
            for (KTree<Token> child : expr.getChildren()) {
                params.add(evaluate(child));
            }

            // evaluar la función actual
            if (params.size() == 1) {
                UnaryOperator op = runtime.getUnaryOp(expr.getValue());
                result = op.apply(params.get(0));
            } else if (params.size() == 2) {
                BinaryOperator op = runtime.getBinaryOp(expr.getValue());
                result = op.apply(params.get(0), params.get(1));
            } else {
                throw new RuntimeException("Caso no esperado: funciones con más de dos parámetros");
            }
        }

        return result;
    }
}
