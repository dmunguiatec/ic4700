package ac.tec.ic.ic4700.lispexpr.locators;

import ac.tec.ic.ic4700.lispexpr.cli.CLIController;
import ac.tec.ic.ic4700.lispexpr.cli.impl.DefaultCLIControllerImpl;

/**
 * @author: diegomunguia
 */
public class ControllerLocator {
    public static CLIController getCLIController() {
        return DefaultCLIControllerImpl.getInstance();
    }

}
