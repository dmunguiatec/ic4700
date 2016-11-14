package ac.tec.ic.ic4700.lispexpr.parser.tokens.impl;

/**
 * @author: diegomunguia
 */
public class BooleanToken extends ImageToken<Boolean> {

    public static final String TRUE_IMAGE = "#t";
    public static final String FALSE_IMAGE = "#f";

    private Boolean value;

    public BooleanToken(String image) {
        this.image = image;
        this.value = TRUE_IMAGE.equals(image);
    }

    public BooleanToken(Boolean value) {
        this.value = value;
        this.image = value ? TRUE_IMAGE : FALSE_IMAGE;
    }

    public static boolean isBooleanToken(String image) {
        return TRUE_IMAGE.equals(image) || FALSE_IMAGE.equals(image); // ojo al orden de las expresiones
    }

    public Boolean getValue() {
        return this.value;
    }
}
