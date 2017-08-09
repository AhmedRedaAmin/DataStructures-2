package eg.edu.alexu.csd.filestructure.avl;

/**
 * Created by ahmed on 3/22/17.
 * avl trees.
 */
public class Node implements INode {
    /**
     * The main parameters of the class.
     * left node
     **/
    private INode leftChild;
    /**
     * right node.
     **/
    private INode rightChild;
    /**
     * value stored in node.
     **/
    private Comparable value;
    /**
     * the height of the node.
     **/
    private int height;

    /**
     * Constructor for the class.
     *
     * @param z ;
     **/
    public Node(final Comparable z) {
        this.value = z;
        this.height = 1;
        leftChild = null;
        rightChild = null;
    }

    /**
     * Returns the left child of the current element/node in the heap tree.
     *
     * @return INode wrapper to the left child of the current element/node
     */
    public INode getLeftChild() {
        return leftChild;
    }

    /**
     * left child setter.
     *
     * @param temp;
     **/
    public void setLeftChild(final INode temp) {
        this.leftChild = temp;
    }

    /**
     * Returns the right child of the current element/node in the heap tree.
     *
     * @return INode wrapper to the right child of the current element/node
     */
    public INode getRightChild() {
        return rightChild;
    }

    /**
     * right child setter.
     *
     * @param temp;
     **/
    public void setRightChild(final INode temp) {
        this.rightChild = temp;
    }

    /**
     * Set/Get the value of the current node.
     *
     * @return Value of the current node
     */
    public Comparable getValue() {
        return value;
    }

    /**
     * Setter of the current.
     *
     * @param value ;
     *              node
     **/
    public void setValue(final Comparable value) {
        this.value = value;
    }

    /**
     * checks for left child.
     *
     * @return boolean
     **/
    public boolean hasleft() {
        return this.leftChild != null;
    }

    /**
     * checks for right child.
     *
     * @return boolean
     **/
    public boolean hasright() {
        return this.rightChild != null;
    }

    /**
     * calculates balance factor.
     *
     * @return int
     **/
    public int getBalanceF() {
        int temp = 0;
        if (!(this.hasleft() || this.hasright())) {
            return temp;
        } else if (!this.hasleft()) {
            temp = -1 * ((Node) this.getRightChild()).getHeight();
        } else if (!this.hasright()) {
            temp = ((Node) this.getLeftChild()).getHeight();
        } else {
            temp = ((Node) this.getLeftChild()).getHeight()
                    - ((Node) this.getRightChild()).getHeight();
        }
        return temp;
    }

    /**
     * update tree height.
     * param x is either true for update height recursively
     * as in update this node and its children and their children and so on
     * or false for updating this node only as in cases where the elements
     * below our node have an accurate height and only our node needs
     * updating
     * @param x;
     **/
    public void updateHeight(final boolean x) {
        this.height = 1 ;
        if (!(this.hasleft() || this.hasright())) {
            return;
        } else if (!this.hasleft()) {
            if (x) {
                ((Node) this.getRightChild()).updateHeight(true);
            }
            height = ((Node) this.getRightChild()).getHeight() + 1;
        } else if (!this.hasright()) {
            if (x) {
                ((Node) this.getLeftChild()).updateHeight(true);
            }
            height = ((Node) this.getLeftChild()).getHeight() + 1;
        } else {
            if (x) {
                ((Node) this.getRightChild()).updateHeight(true);
                ((Node) this.getLeftChild()).updateHeight(true);
            }
            int a = ((Node) this.getRightChild()).getHeight();
            int b = ((Node) this.getLeftChild()).getHeight();
            height = (a > b) ? a + 1 : b + 1;
        }
    }

    /**
     * gets subtree height x.
     *
     * @return int ;
     **/
    public int getHeight() {
        return this.height;
    }
}
