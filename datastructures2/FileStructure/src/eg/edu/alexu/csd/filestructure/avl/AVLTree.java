package eg.edu.alexu.csd.filestructure.avl;

/**
 * Created by ahmed on 3/22/17.
 * avl trees.
 */
public class AVLTree implements IAVLTree {
    /**
     * root of the tree.
     **/
    private Node root;
    /**
     * heigth of the tree.
     **/
    private int height = 0;
    /**
     * number of elements in the tree.
     **/
    private int size = 0;
    /**
     * this variable carries the child type of the last predecessor
     * is the node a right child or a left child , only the predecessor method
     * accesses this variable.
     */
    private String whichChild = null;

    /**
     * Insert the given value using the key.
     *
     * @param key ; the value to be inserted in the tree
     */
    public void insert(final Comparable key) {
        if (root == null) {
            root = new Node(key);
        } else {
            if (!insertRoutine(key, root)) {
                return;
            }
        }
        this.height = root.getHeight();
        this.size++;
    }

    /** A recursive extension to the insert method.
     * @param key ;
     * @param current ;
     * @return boolean;
     */
    private boolean insertRoutine(final Comparable key, final Node current) {
        boolean done = false;
        int comparison = current.getValue().compareTo(key);
        if (comparison < 0) {
            if (current.hasright()) {
                done = insertRoutine(key, (Node) current.getRightChild());
            } else {
                current.setRightChild(new Node(key));
                done = true;
            }
        } else if (comparison > 0) {
            if (current.hasleft()) {
                done = insertRoutine(key, (Node) current.getLeftChild());
            } else {
                current.setLeftChild(new Node(key));
                done = true;
            }
        } else {
            return false;
        }
        if (!done) {
            return done;
        }
        current.updateHeight(false);
        int z = current.getBalanceF();
        if (Math.abs(z) > 1) {
            this.rebalance(current);
        }
        return done;
    }

    /** Method to get successor to your current node.
     *Works according to Hibbard`s deletion.
     * @param x;
     * @return Node;
     */
    public Node successor(Node x) {
        if (x.hasleft()) {
            x = (Node) x.getLeftChild();
            while (x.hasright()) {
                x = (Node) x.getRightChild();
            }
            return x;
        } else if (x.hasright()) {
            x = (Node) x.getRightChild();
            while (x.hasleft()) {
                x = (Node) x.getLeftChild();
            }
            return x;
        }
        return null;
    }

    /** Method to get the predecessor of your current node.
     * Also the only method to affect variable which Child.
     * @param x ;
     * @return Node;
     */

    public Node predecessor(final Node x) {
        if (x.equals(this.root)) {
            return null;
        } else {
            Node temp = this.root;
            while (temp.hasleft() || temp.hasright()) {
                int comparison = temp.getValue().compareTo(x.getValue());
                if (comparison > 0) {
                    if (temp.hasleft()) {
                        if (((Node) temp.getLeftChild()).equals(x)) {
                            this.whichChild = "left";
                            return temp;
                        } else {
                            temp = (Node) temp.getLeftChild();
                        }
                    } else {
                        throw new RuntimeException("something isn`t right");
                    }
                } else if (comparison < 0) {
                    if (temp.hasright()) {
                        if (((Node) temp.getRightChild()).equals(x)) {
                            this.whichChild = "right";
                            return temp;
                        } else {
                            temp = (Node) temp.getRightChild();
                        }
                    } else {
                        throw new RuntimeException("something isn`t right");
                    }
                } else {
                    return null;
                }
            }
            return null;
        }
    }

    /**
     * Delete the key (if exists).
     *
     * @param key the key of the node
     * @return true if node deleted, false if not exists
     */
    public boolean delete(final Comparable key) {
        if (root == null) {
            return false;
        } else {
            if (!deleteRoutine(key, root)) {
                return false;
            }
        }
        this.height = (root != null) ? root.getHeight() : 0;
        this.size--;
        return true;
    }

    /** a recursive extension to the delete method.
     * @param key ;
     * @param current ;
     * @return boolean;
     */
    private boolean deleteRoutine(final Comparable key, Node current) {
        boolean done = false;
        int comparison = current.getValue().compareTo(key);
        if (comparison < 0) {
            if (current.hasright()) {
                done = deleteRoutine(key, (Node) current.getRightChild());
            } else {
                return false;
            }
        } else if (comparison > 0) {
            if (current.hasleft()) {
                done = deleteRoutine(key, (Node) current.getLeftChild());
            } else {
                return false;
            }
        } else {
            done = true;
            if (current.hasright() || current.hasleft()) {
                Node heir = successor(current);
                Comparable y = heir.getValue();
                done = deleteRoutine(heir.getValue(), heir);
                current.setValue(y);
                current.updateHeight(true);
            } else {
                current = predecessor(current);
                switch (whichChild) {
                    case "left":
                        current.setLeftChild(null);
                        break;
                    default:
                        current.setRightChild(null);
                }
            }
        }
        if (!done) {
            return done;
        }
        current.updateHeight(false);
        int z = current.getBalanceF();
        if (Math.abs(z) > 1) {
            this.rebalance(current);
        }
        return done;
    }
    /** Left Rotate method.
     *
     * @param x ;
     * @return Node;
     */
    private Node leftRotate(final Node x) {
        Node currentParent = x;
        Node futureParent = (Node) x.getRightChild();

        currentParent.setRightChild(futureParent.getLeftChild());

        futureParent.setLeftChild(currentParent);
        futureParent.updateHeight(true);
        return futureParent;
    }

    /** Right Rotate method.
     *
     * @param x ;
     * @return Node;
     */
    private Node rightRotate(final Node x) {
        Node currentParent = x;
        Node futureParent = (Node) x.getLeftChild();

        currentParent.setLeftChild(futureParent.getRightChild());

        futureParent.setRightChild(currentParent);
        futureParent.updateHeight(true);
        return futureParent;
    }

    /**
     * Search for a specific element using the key in the tree.
     *
     * @param key the key of the node
     * @return true if the key exists, false otherwise
     */
    public boolean search(final Comparable key) {
        Node temp = null;
        if (this.root != null) {
            temp = this.root;
        }
        while (temp != null) {
            int comparison = temp.getValue().compareTo(key);
            if (comparison > 0) {
                if (temp.hasleft()) {
                    temp = (Node) temp.getLeftChild();
                } else {
                    return false;
                }
            } else if (comparison < 0) {
                if (temp.hasright()) {
                    temp = (Node) temp.getRightChild();
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    /** Method to rebalance the tree after checking the weights
     *there are only four possible cases left-left , left-right
     * , right-right and right-left.
     * @param z ;
     */
    private void rebalance(final Node z) {
        int balance = z.getBalanceF();
        if (balance > 1) {
            if (balance == 2) {
                Node parent = this.predecessor(z);
                if (((Node) z.getLeftChild()).getBalanceF() < 0) {
                    z.setLeftChild(this.leftRotate((Node) z.getLeftChild()));
                }
                if (parent == null) {
                    this.root = rightRotate(z);
                } else {
                    switch (whichChild) {
                        case "left":
                            parent.setLeftChild(rightRotate(z));
                            break;
                        default:
                            parent.setRightChild(rightRotate(z));
                    }
                }
                return;
            }
            this.rebalance((Node) z.getLeftChild());
            z.updateHeight(false);

        } else {
            if (balance == -2) {
                Node parent = this.predecessor(z);
                if (((Node) z.getRightChild()).getBalanceF() > 0) {
                    z.setRightChild(
                            this.rightRotate((Node) z.getRightChild()));
                }
                if (parent == null) {
                    this.root = leftRotate(z);
                } else {
                    switch (whichChild) {
                        case "left":
                            parent.setLeftChild(leftRotate(z));
                            break;
                        default:
                            parent.setRightChild(leftRotate(z));
                    }
                }
                return;
            }
            this.rebalance((Node) z.getRightChild());
            z.updateHeight(false);
        }
    }

    /**
     * Return the height of the AVL tree. This is the longest path from.
     * the root to a leaf-node
     *
     * @return tree height
     */
    public int height() {
        return this.height;
    }

    /**
     * Return the root of your AVL tree.
     *
     * @return root of the AVL tree.
     */
    public INode getTree() {
        return this.root;
    }

    /**
     * return the size of the tree.
     **/
    public int getsize() {
        return this.size;
    }

    /** Displays tree in preOrder traversal.
     * @param node ;
     */
    void preOrder(final Node node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            preOrder((Node) node.getLeftChild());
            preOrder((Node) node.getRightChild());
        }
    }
}
