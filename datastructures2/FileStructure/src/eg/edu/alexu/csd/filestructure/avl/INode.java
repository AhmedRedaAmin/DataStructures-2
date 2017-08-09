package eg.edu.alexu.csd.filestructure.avl;

/**
 * Created by ahmed on 3/17/17.
 * avl trees.
 */
public interface INode<T extends Comparable<T>> {
    /**
     * Returns the left child of the current element/node in the heap tree.
     * @return INode wrapper to the left child of the current element/node
     */
    INode<T> getLeftChild();
    /**
     * Returns the right child of the current element/node in the heap tree.
     * @return INode wrapper to the right child of the current element/node
     */
    INode<T> getRightChild();
    /**
     * Set/Get the value of the current node.
     * @return Value of the current node
     */
    T getValue();
    /**Setter of the current.
     * @param value;
     * node**/
    void setValue(T value);
}