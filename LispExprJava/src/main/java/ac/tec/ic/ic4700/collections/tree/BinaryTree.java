package ac.tec.ic.ic4700.collections.tree;

/**
 * @author: diegomunguia
 */
public interface BinaryTree<T> extends Tree<T> {
    BinaryTree<T> getLeft();
    BinaryTree<T> getRight();

    void setLeft(BinaryTree<T> left);
    void setRight(BinaryTree<T> right);
}
