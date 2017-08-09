package eg.edu.alexu.csd.filestructure.avl;

import eg.edu.alexu.csd.filestructure.avl.Dictionary;
import eg.edu.alexu.csd.filestructure.avl.AVLTree;

public class TestRunner {

    public static IAVLTree getImplementationInstance() {
        return new AVLTree();
    }

    public static IDictionary getDicImplementationInstance() {
        return new Dictionary();
    }

}
