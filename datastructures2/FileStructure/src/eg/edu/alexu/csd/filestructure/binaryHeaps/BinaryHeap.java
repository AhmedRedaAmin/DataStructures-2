package eg.edu.alexu.csd.filestructure.binaryHeaps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by ahmed on 3/8/17.
 * who is a person
 */
public abstract class BinaryHeap {
    /**
     * main dataStructure in use.
     **/
    protected ArrayList<Integer> binHeap;

    /**
     * restructures the tree into a heap after deformation.
     **/
    private void heapify() {
        int i = 0;
        int j = actionToBeTaken(i);
        while (j > 0) {
            switch (j) {
                case 1:
                    Collections.swap(binHeap, i, getLeftChild(i));
                    i = getLeftChild(i);
                    break;
                case 2:
                    Collections.swap(binHeap, i, getRightChild(i));
                    i = getRightChild(i);
                    break;
                default:
                    j = 0;
            }
            j = actionToBeTaken(i);
        }


    }

    /**@param i ;
     * Carries all the node comparison logic.
     **/
    protected int actionToBeTaken(final int i) {
        //Different Implementations here
        return 0;
    }

    /**@param x ;
     * Uses a collection to build a heap from scratch.
     **/
    public void buildHeap(final Collection x) {
        Object[] elements = x.toArray();
        int i = 0;
        while (i < elements.length) {
            this.heapInsert((int) elements[i]);
            i++;
        }

    }

    /**
     * returns the heap arrayList.
     **/
    public ArrayList<Integer> getArrayList() {
        return binHeap;
    }

    /**@param k ;
     * Inserts an element in the last location in the heap.
     **/
    public void heapInsert(final int k) {

    }

    /**
     * Extracts the max element in heap [i.e the root of MaxHeap].
     **/
    public int heapExtractRoot() {
        if (binHeap.size() != 0) {
            int max = binHeap.get(0);
            Collections.swap(binHeap, 0, binHeap.size() - 1);
            binHeap.remove(binHeap.size() - 1);
            this.heapify();
            return (max);
        }
        return 0;
    }

    /**
     * Returns size of heap.
     **/
    public int heapSize() {
        return binHeap.size();
    }

    /**
     * Navigation Methods.
     **/
    protected int getParent(final int i) {
        return i / 2;
    }

    protected int getLeftChild(final int i) {
        if (i == 0) {
            return 1;
        }
        return 2 * i;
    }

    protected int getRightChild(final int i) {

        return (2 * i) + 1;
    }


}
