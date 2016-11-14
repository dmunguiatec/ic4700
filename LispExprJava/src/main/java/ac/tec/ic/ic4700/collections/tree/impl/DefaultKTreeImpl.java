package ac.tec.ic.ic4700.collections.tree.impl;

import ac.tec.ic.ic4700.collections.tree.KTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: diegomunguia
 */
public class DefaultKTreeImpl<T> implements KTree<T> {
    private T value;
    private List<KTree<T>> children = new ArrayList<KTree<T>>();

    @Override
    public List<KTree<T>> getChildren() {
        return this.children;
    }

    @Override
    public void addChild(KTree<T> child) {
        this.children.add(child);
    }

    @Override
    public boolean isLeaf() {
        return this.children.isEmpty();
    }

    @Override
    public T getValue() {
        return this.value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        if (isLeaf()) {
            return this.value != null ? this.value.toString() : "";
        } else {
            StringBuilder builder = new StringBuilder();
            builder.append('[').append(this.value);
            for (KTree<T> child : this.children) {
                builder.append(' ').append(child.toString());
            }
            builder.append(']');

            return builder.toString();
        }
    }
}
