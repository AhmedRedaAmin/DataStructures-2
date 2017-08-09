package eg.edu.alexu.csd.filestructure.binaryHeaps;

import java.util.ArrayList;

/**
 * Created by ahmed on 3/10/17.
 * who is a person
 */
public interface MultiSorterInterface {
    /**@ param
     * Sorts the array using the  heapSort Algorithm and heap structure.
     **/
    ArrayList<Integer> heapSort(ArrayList<Integer> sortee);

    /**@ param
     * Sorts the array using the  mergeSort Algorithm.
     **/
    ArrayList<Integer> mergeSort(ArrayList<Integer> sortee);

    /**@ param
     * Sorts the array using the quicksort Algorithm.
     **/
    ArrayList<Integer> quickSort(ArrayList<Integer> sortee);

    /**
     * Sorts the array using the  insertionSort Algorithm.
     **/
    ArrayList<Integer> insertionSort(ArrayList<Integer> sortee);

    /**
     * Sorts the array using the  selectionSort Algorithm.
     **/
    ArrayList<Integer> selectionSort(ArrayList<Integer> sortee);

    /**
     * Sorts the array using the  bubbleSort Algorithm.
     **/
    ArrayList<Integer> bubbleSort(ArrayList<Integer> sortee);

}
