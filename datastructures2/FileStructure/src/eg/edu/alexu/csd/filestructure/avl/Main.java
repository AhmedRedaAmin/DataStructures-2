package eg.edu.alexu.csd.filestructure.avl;

/**
 * Created by ahmed on 4/16/17.
 */
public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        /* Constructing tree given in the above figure */
        /*tree.insert( 10);
        tree.insert( 20);
        tree.insert( 30);
        tree.insert( 40);
        tree.insert( 50);
        tree.insert( 25);*/


        tree.insert( 9);
        tree.insert( 5);
        tree.insert(10);
        tree.insert( 0);
        tree.insert( 6);
        tree.insert( 11);
        tree.insert( -1);
        tree.insert( 1);
        tree.insert( 2);
        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
        /* The constructed AVL Tree would be
           9
          /  \
         1    10
        /  \    \
        0    5    11
        /    /  \
        -1   2    6
         */
        System.out.println("Preorder traversal of "+
                "constructed tree is : ");
        tree.preOrder((Node)tree.getTree());

        tree.delete( 10);

        /* The AVL Tree after deletion of 10
           1
          /  \
         0    9
        /     / \
        -1    5   11
        /  \
        2    6
         */
        System.out.println("Preorder traversal" +
                " of constructed tree is : ");
        tree.preOrder((Node)tree.getTree());
        System.out.println("just for debug " + tree.delete(20)+ " ");
        tree.insert(0);
        tree.preOrder((Node)tree.getTree());

    }
}
