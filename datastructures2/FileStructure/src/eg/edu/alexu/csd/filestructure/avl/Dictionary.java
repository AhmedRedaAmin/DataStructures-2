package eg.edu.alexu.csd.filestructure.avl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by ahmed on 3/22/17.
 * avl trees.
 */
public class Dictionary implements IDictionary {
    private AVLTree dictionary = new AVLTree();

    /**
     * Load the dictionary into an AVL Tree data structure. The file is text.
     * containing a list of words. Each word will be in a separate line
     *
     * @param file the dictionary file
     */
    public void load(final File file) {
        try {
            Scanner read = new Scanner(file);
            while (read.hasNext()) {
                dictionary.insert(read.nextLine());
            }
            read.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Takes a word and inserts it, only if it is not already in the dictionary.
     *
     * @param word word to insert
     * @return true if inserted successfully, false if already exists
     */
    public boolean insert(final String word) {
        if (!dictionary.search(word)) {
            dictionary.insert(word);
            return true;
        }
        return false;
    }

    /**
     * Takes a word from the user and checks whether it is found or not.
     *
     * @param word word to lookup
     * @return true if exists, false if not
     */
    public boolean exists(final String word) {
        return dictionary.search(word);
    }

    /**
     * Takes a word from the user and removes it from the dictionary.
     *
     * @param word word to delete
     * @return false if the word is not in the dictionary, true otherwise
     */
    public boolean delete(final String word) {
        return dictionary.delete(word);
    }

    /**
     * Prints the current size of your dictionary.
     *
     * @return dictionary size
     */
    public int size() {

        return dictionary.getsize();
    }

    /**
     * Print the maximum height of the current tree.
     *
     * @return AVL tree height
     */
    public int height() {

        return dictionary.height();
    }
}
