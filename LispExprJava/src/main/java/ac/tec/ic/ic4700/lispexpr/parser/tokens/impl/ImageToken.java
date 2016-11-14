package ac.tec.ic.ic4700.lispexpr.parser.tokens.impl;

import ac.tec.ic.ic4700.lispexpr.parser.tokens.Token;

/**
 * @author: diegomunguia
 */
public abstract class ImageToken<T> implements Token {
    protected String image;

    @Override
    public String getImage() {
        return this.image;
    }

    abstract T getValue();

    @Override
    public String toString() {
        return this.image;
    }

    @Override
    public int hashCode() {
        return this.image.hashCode();
    }
}
