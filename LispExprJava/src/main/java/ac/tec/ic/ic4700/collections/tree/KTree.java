package ac.tec.ic.ic4700.collections.tree;

import java.util.List;

/**
 * @author: diegomunguia
 */
public interface KTree<T> extends Tree<T> {
    List<KTree<T>> getChildren();
    void addChild(KTree<T> child);
    boolean isLeaf();
}
