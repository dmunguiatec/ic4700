package ac.tec.ic.ic4700.lispexpr.parser.tokens.impl;

/**
 * @author: diegomunguia
 */
public class NaturalToken extends ImageToken<Integer> {

    private Integer value;

    public NaturalToken(String image) {
        this.image = image;
        this.value = Integer.parseInt(image);
    }

    public NaturalToken(Integer value) {
        this.value = value;
        this.image = value.toString();
    }

    public static boolean isNaturalToken(String image) {
        return image.matches("^\\d+$");
    }

    public Integer getValue() {
        return value;
    }
}
