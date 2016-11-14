package ac.tec.ic.ic4700.lispexpr.cli.impl;

import ac.tec.ic.ic4700.collections.tree.KTree;
import ac.tec.ic.ic4700.lispexpr.cli.CLIController;
import ac.tec.ic.ic4700.lispexpr.eval.Evaluator;
import ac.tec.ic.ic4700.lispexpr.locators.ServiceLocator;
import ac.tec.ic.ic4700.lispexpr.parser.Parser;
import ac.tec.ic.ic4700.lispexpr.parser.tokens.Token;

import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: diegomunguia
 */
public class DefaultCLIControllerImpl implements CLIController {

    private static final String ERROR_MESSAGE = "Ha ocurrido un error inesperado.";

    private static DefaultCLIControllerImpl instance = null;

    private Parser parser = ServiceLocator.getParser();
    private Evaluator evaluator = ServiceLocator.getEvaluator();

    private DefaultCLIControllerImpl() {}

    public static DefaultCLIControllerImpl getInstance() {
        if (instance == null) {
            instance = new DefaultCLIControllerImpl();
        }

        return instance;
    }

    @Override
    public String evalCode(String input) {
        try {
            // transformar entrada de UI en formato requerido por la lógica del problema
            StringReader code = new StringReader(input);

            // invocar a la lógica del problema
            KTree<Token> expr = parser.parse(code);
            Token value = evaluator.evaluate(expr);

            // transformar el resultado en formato requerido por la interfaz de usuario
            return value.toString();
        } catch(Throwable t) {
            // manejar errores
            return handleError(t);
        }
    }

    private String handleError(Throwable t) {
        // loguear el error
        System.err.printf("[%s][Throwable] %s: %s\n",
                new SimpleDateFormat("yyyy-MM-dd kk:mm:ss Z").format(new Date()),
                t.getClass().getName(),
                t.getMessage());
        t.printStackTrace(System.err);

        // retornar a UI mensaje significativo
        return ERROR_MESSAGE;
    }
}
