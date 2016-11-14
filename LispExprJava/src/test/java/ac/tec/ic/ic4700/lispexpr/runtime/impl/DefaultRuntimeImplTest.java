package ac.tec.ic.ic4700.lispexpr.runtime.impl;

import ac.tec.ic.ic4700.lispexpr.parser.tokens.impl.IdentifierToken;
import ac.tec.ic.ic4700.lispexpr.runtime.BinaryOperator;
import ac.tec.ic.ic4700.lispexpr.runtime.UnaryOperator;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author: diegomunguia
 */
public class DefaultRuntimeImplTest {

    @Test
    public void testGetInstance() throws Exception {
        DefaultRuntimeImpl runtime = DefaultRuntimeImpl.getInstance();

        assertNotNull(runtime);
    }

    @Test
    public void testGetUnaryOp() throws Exception {
        DefaultRuntimeImpl runtime = DefaultRuntimeImpl.getInstance();

        UnaryOperator op = runtime.getUnaryOp(new IdentifierToken("not"));
        assertNotNull(op);
    }

    @Test
    public void testGetBinaryOp() throws Exception {
        DefaultRuntimeImpl runtime = DefaultRuntimeImpl.getInstance();

        String[] operators = new String[] {"+", "-", "*", "quotient", "modulo",
                "=", "<", "<=", ">", ">=", "and", "or"};
        for (String operator : operators) {
            BinaryOperator op = runtime.getBinaryOp(new IdentifierToken(operator));
            assertNotNull(op);
        }
    }
}