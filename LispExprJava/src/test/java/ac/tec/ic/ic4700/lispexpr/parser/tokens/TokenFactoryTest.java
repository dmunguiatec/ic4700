package ac.tec.ic.ic4700.lispexpr.parser.tokens;

import ac.tec.ic.ic4700.lispexpr.parser.tokens.impl.BooleanToken;
import ac.tec.ic.ic4700.lispexpr.parser.tokens.impl.IdentifierToken;
import ac.tec.ic.ic4700.lispexpr.parser.tokens.impl.NaturalToken;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: diegomunguia
 */
public class TokenFactoryTest {

    @Test
    public void testMakeNaturalToken() throws Exception {
        Token token = TokenFactory.makeToken("1");

        assertNotNull(token);
        assertTrue(token instanceof NaturalToken);
    }

    @Test
    public void testMakeBooleanToken() throws Exception {
        Token token = TokenFactory.makeToken("#f");

        assertNotNull(token);
        assertTrue(token instanceof BooleanToken);
    }

    @Test
    public void testMakeIdentifierToken() throws Exception {
        Token token = TokenFactory.makeToken("modulo");

        assertNotNull(token);
        assertTrue(token instanceof IdentifierToken);
    }
}