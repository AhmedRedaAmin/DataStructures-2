/**package for the FileStructure Course**/
package eg.edu.alexu.csd.filestructure.binaryHeaps;

import java.util.ArrayList;
import java.util.Collections;


/**
 * Created by ahmed on 3/10/17.
 *
 * Return ArrayList
 */
public class Sorter implements MultiSorterInterface {
    /** just an object that provides the Nlogn Algorithms functionality.**/
    private NlognSorterSuite sorter = new NlognSorterSuite();

    public ArrayList<Integer> heapSort(final ArrayList<Integer> sortee) {
        return sorter.heapSorter(sortee);
    }

    /**@param sortee Arraylist
     * Sorts the array using the  mergeSort Algorithm.
     **/
    public ArrayList<Integer> mergeSort(final ArrayList<Integer> sortee) {
        ArrayList<Integer> temp = new ArrayList<Integer>(sorter.mergeSort(sortee));
        return temp;

    }

    /**@param sortee Arraylist
     * Sorts the array using the quicksort Algorithm.
     **/
    public ArrayList<Integer> quickSort(final ArrayList<Integer> sortee) {
        sorter.updateList(sortee);
        sorter.quickSort(0, sortee.size() - 1);
        return sorter.getquickSortList();

    }

    /**@param sortee Arraylist
     * @return ArrayList
     * Sorts the array using the  insertionSort Algorithm.
     **/
    public ArrayList<Integer> insertionSort(final ArrayList<Integer> sortee) {
        int wall = sortee.size() - 1;
        while (wall != 0) {
            for (int j = wall; j <= sortee.size() - 1; j++) {
                if (sortee.get(j - 1) < sortee.get(j)) {
                    Collections.swap(sortee, j - 1, j);
                } else {
                    break;
                }
            }
            wall--;
        }
        return sortee;
    }

    /**@param sortee Arraylist
     * @return Arraylist
     * Sorts the array using the  selectionSort Algorithm
     **/
    public ArrayList<Integer> selectionSort(final ArrayList<Integer> sortee) {
        int lastIndex = sortee.size() - 1;
        while (lastIndex != 0) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0; j <= lastIndex; j++) {
                if (sortee.get(j) <= min) {
                    min = sortee.get(j);
                    minIndex = j;
                }
            }
            Collections.swap(sortee, minIndex, lastIndex);
            lastIndex--;
        }
        return sortee;
    }

    /**@param sortee
     *@return ArrayList
     * Sorts the array using the  bubbleSort Algorithm.
     **/
    public ArrayList<Integer> bubbleSort(final ArrayList<Integer> sortee) {
        int swap = 1;
        for (int i = 0; i < sortee.size(); i++) {
            if (swap == 0) {
                break;
            }
            swap = 0;
            for (int j = 1; j < sortee.size(); j++) {
                if (sortee.get(j - 1) < sortee.get(j)) {
                    Collections.swap(sortee, j - 1, j);
                    swap = 1;
                }
            }
        }
        return sortee;
    }


}
