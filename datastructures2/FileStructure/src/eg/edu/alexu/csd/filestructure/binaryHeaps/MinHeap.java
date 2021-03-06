package eg.edu.alexu.csd.filestructure.binaryHeaps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by ahmed on 3/17/17.
 * who is a person
 */
public class MinHeap extends BinaryHeap {
    /**this constructor builds the heap. **/
    public MinHeap(final Collection x) {
        binHeap = new ArrayList<Integer>();
        this.buildHeap(x);
    }
    /** just override and put your own implementation. **/
    @Override
    protected int actionToBeTaken(final int i) {
        int action = 0;
        if (getLeftChild(i) < binHeap.size()) {
            if (getRightChild(i) < binHeap.size()) {
                if (binHeap.get(getLeftChild(i))
                        >= binHeap.get(getRightChild(i))
                        && binHeap.get(getRightChild(i)) < binHeap.get(i)) {
                    action = 2;
                    //swap right child with parent
                } else if (binHeap.get(getLeftChild(i))
                        <= binHeap.get(getRightChild(i))
                        && binHeap.get(getLeftChild(i)) < binHeap.get(i)) {
                    action = 1;
                    //swap left child with parent
                } else {
                    action = 0;
                    //terminate
                }
            } else {
                if (binHeap.get(i) > binHeap.get(getLeftChild(i))) {
                    action = 1;
                } else {
                    action = 0;
                }
            }
        }
        return action;
    }

    // for testing
    /** just override and put your own implementation. **/
    @Override
    public void heapInsert(final int k) {
        if (binHeap.size() == 0) {
            binHeap.add(k);
        } else {
            binHeap.add(k);
            int i = binHeap.size() - 1;
            while (i >= 0 && binHeap.get(i) < binHeap.get(this.getParent(i))) {
                Collections.swap(binHeap, i, this.getParent(i));
                i = this.getParent(i);

            }
        }

    }
}