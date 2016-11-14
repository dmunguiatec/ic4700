package ac.tec.ic.ic4700.lispexpr.parser.tokens.impl;

/**
 * @author: diegomunguia
 */
public class IdentifierToken extends ImageToken<String> {

    public IdentifierToken(String image) {
        this.image = image;
    }

    /**
     * Retorna la imagen porque no es necesario hacer una conversión.
     * Este token representa las operaciones que se pueden ejecutar
     * en una expresión lisp.
     *
     * @returns La imagen del token
     */
    public String getValue() {
        return this.image;
    }
}
