package ac.tec.ic.ic4700.lispexpr.cli.impl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author: diegomunguia
 */
public class DefaultCLIControllerImplTest {

    @Test
    public void testGetInstance() throws Exception {
        DefaultCLIControllerImpl instance = DefaultCLIControllerImpl.getInstance();

        assertNotNull(instance);
    }

    @Test
    public void testEvalCode() throws Exception {
        DefaultCLIControllerImpl instance = DefaultCLIControllerImpl.getInstance();

        String result = instance.evalCode("(not (or (> (+ (* 3 2) (modulo 13 3)) (quotient (- 5 1) 3)) (and (<= (* 2 1) (- 7 3)) (= (* 2 2) (+ 2 2)))))");
        assertEquals("#f", result);
    }
}