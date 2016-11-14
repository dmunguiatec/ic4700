package ac.tec.ic.ic4700.lispexpr.parser.impl;

import ac.tec.ic.ic4700.collections.tree.KTree;
import ac.tec.ic.ic4700.lispexpr.parser.Parser;
import ac.tec.ic.ic4700.lispexpr.parser.tokens.Token;
import ac.tec.ic.ic4700.lispexpr.parser.tokens.TokenFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author: diegomunguia
 */
public class StringLineParser implements Parser {

    public static final String EXPR_OPENER = "(";
    public static final String EXPR_CLOSER = ")";

    private static StringLineParser instance = null; // ojo: ¿porqué las inicializaciones aquí y no en el constructor?

    private StringLineParser() {}

    public static StringLineParser getInstance() {
        if (instance == null) {
            instance = new StringLineParser();
        }

        return instance;
    }

    private KTree<Token> makeKTree() { // ojo: patrón Factory Method
        return new ac.tec.ic.ic4700.collections.tree.impl.DefaultKTreeImpl<>();
    }

    @Override
    public KTree<Token> parse(Reader input) {
        try {
            String code = new BufferedReader(input).readLine();
            input.close();

            // truco para facilitar la "tokenización"
            code = code.replace(EXPR_OPENER, EXPR_OPENER + ' ');
            code = code.replace(EXPR_CLOSER, ' ' + EXPR_CLOSER);

            StringTokenizer tokenizer = new StringTokenizer(code, " ", false);
            Stack<KTree<Token>> stack = new Stack<>();
            Token token;
            KTree<Token> child;
            KTree<Token> current = null;
            while (tokenizer.hasMoreTokens()) {
                String tokenImage = tokenizer.nextToken();

                switch (tokenImage) {
                    case EXPR_OPENER:
                        child = makeKTree();
                        if (current == null) {
                            stack.push(child);
                        } else {
                            current.addChild(child);
                            stack.push(current);
                        }
                        current = child;

                        token = TokenFactory.makeToken(tokenizer.nextToken());
                        current.setValue(token);

                        break;

                    case EXPR_CLOSER:
                        current = stack.pop();
                        break;

                    default:
                        token = TokenFactory.makeToken(tokenImage);
                        child = makeKTree();
                        child.setValue(token);

                        if (current == null) {
                            current = child;
                        } else {
                            current.addChild(child);
                        }
                }
            }

            return current;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
