package ac.tec.ic.ic4700.collections.tree.impl;

import ac.tec.ic.ic4700.collections.tree.KTree;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: diegomunguia
 */
public class DefaultKTreeImplTest {

    @Test
    public void testGetChildren() throws Exception {
        DefaultKTreeImpl<String> tree = new DefaultKTreeImpl<>();
        List<KTree<String>> children = tree.getChildren();

        assertNotNull(children);
    }

    @Test
    public void testAddChild() throws Exception {
        DefaultKTreeImpl<String> tree = new DefaultKTreeImpl<>();
        DefaultKTreeImpl<String> child = new DefaultKTreeImpl<>();
        tree.addChild(child);

        assertEquals(1, tree.getChildren().size());
    }

    @Test
    public void testIsLeafTrue() throws Exception {
        DefaultKTreeImpl<String> tree = new DefaultKTreeImpl<>();

        assertTrue(tree.isLeaf());
    }

    @Test
    public void testIsLeafFalse() throws Exception {
        DefaultKTreeImpl<String> tree = new DefaultKTreeImpl<>();
        DefaultKTreeImpl<String> child = new DefaultKTreeImpl<>();
        tree.addChild(child);

        assertFalse(tree.isLeaf());
    }

    @Test
    public void testGetValue() throws Exception {
        DefaultKTreeImpl<String> tree = new DefaultKTreeImpl<>();
        tree.setValue("a");

        assertEquals("a", tree.getValue());
    }

    @Test
    public void testSetValue() throws Exception {
        DefaultKTreeImpl<String> tree = new DefaultKTreeImpl<>();
        tree.setValue("a");
    }

    @Test
    public void testToStringLeaf() throws Exception {
        DefaultKTreeImpl<Integer> tree = new DefaultKTreeImpl<>();
        tree.setValue(1);

        assertEquals("1", tree.toString());
    }

    @Test
    public void testToStringChildren() throws Exception {
        DefaultKTreeImpl<Integer> tree = new DefaultKTreeImpl<>();
        tree.setValue(1);

        DefaultKTreeImpl<Integer> child = new DefaultKTreeImpl<>();
        child.setValue(2);
        tree.addChild(child);

        child = new DefaultKTreeImpl<>();
        child.setValue(3);
        tree.addChild(child);

        assertEquals("[1 2 3]", tree.toString());
    }

    @Test
    public void testToStringSubtrees() throws Exception {
        DefaultKTreeImpl<Integer> tree = new DefaultKTreeImpl<>();
        tree.setValue(1);

        DefaultKTreeImpl<Integer> left = new DefaultKTreeImpl<>();
        left.setValue(2);
        tree.addChild(left);

        DefaultKTreeImpl<Integer> child = new DefaultKTreeImpl<>();
        child.setValue(3);
        left.addChild(child);

        DefaultKTreeImpl<Integer> right = new DefaultKTreeImpl<>();
        right.setValue(4);
        tree.addChild(right);

        child = new DefaultKTreeImpl<>();
        child.setValue(5);
        right.addChild(child);

        assertEquals("[1 [2 3] [4 5]]", tree.toString());
    }
}