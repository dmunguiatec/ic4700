package ac.tec.ic.ic4700.lispexpr.parser.tokens;

import ac.tec.ic.ic4700.lispexpr.parser.tokens.impl.BooleanToken;
import ac.tec.ic.ic4700.lispexpr.parser.tokens.impl.IdentifierToken;
import ac.tec.ic.ic4700.lispexpr.parser.tokens.impl.NaturalToken;

/**
 * @author: diegomunguia
 */
public class TokenFactory { // ojo: patrón Factory Class

    public static Token makeToken(String image) {
        if (NaturalToken.isNaturalToken(image)) {
            return new NaturalToken(image);
        } else if (BooleanToken.isBooleanToken(image)) {
            return new BooleanToken(image);
        } else {
            return new IdentifierToken(image);
        }
    }
}
