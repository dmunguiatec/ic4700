package ac.tec.ic.ic4700.lispexpr.locators;

import ac.tec.ic.ic4700.lispexpr.cli.CLIController;
import ac.tec.ic.ic4700.lispexpr.cli.impl.DefaultCLIControllerImpl;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author: diegomunguia
 */
public class ControllerLocatorTest {

    @Test
    public void testGetCLIController() throws Exception {
        CLIController controller = ControllerLocator.getCLIController();

        assertNotNull(controller);
        assertTrue(controller instanceof DefaultCLIControllerImpl);
    }
}