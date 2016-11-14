package ac.tec.ic.ic4700.lispexpr.cli;

import ac.tec.ic.ic4700.lispexpr.locators.ControllerLocator;

import java.util.Scanner;

/**
 * @author: diegomunguia
 */
public class CLI {

    private static final String prompt = "lisp> ";

    private static CLIController controller = ControllerLocator.getCLIController();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        header();
        while (true) {
            System.out.println();
            System.out.print(prompt);
            String expr = scanner.nextLine();
            String result = controller.evalCode(expr);
            System.out.println(result);
        }
    }

    private static void header() {
        System.out.println("Evaluador de expresiones LISP");
    }
}
