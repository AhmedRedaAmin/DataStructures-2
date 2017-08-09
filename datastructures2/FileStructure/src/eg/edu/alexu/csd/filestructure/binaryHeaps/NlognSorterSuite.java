package eg.edu.alexu.csd.filestructure.binaryHeaps;


import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ahmed on 3/10/17.
 */
public class NlognSorterSuite {

    /** just override and put your own implementation. **/
    List<Integer> mergeSort(List<Integer> targetArray) {
        if (targetArray.size() == 1) {
            return targetArray;
        }
        int mid = targetArray.size() / 2;
        List<Integer> sublist1 = targetArray.subList(0, mid);
        List<Integer> sublist2 = targetArray.subList(mid, targetArray.size());
        // sublist takes from first element to last exclusive
        // "not including the last"
        targetArray = merge(mergeSort(sublist1), mergeSort(sublist2));

        return targetArray;
    }
    /** merges the two splitted lists.**/
    private List<Integer> merge(List<Integer> sublist1,
                                List<Integer> sublist2) {
        List<Integer> mergeList = new ArrayList<Integer>();
        int front1 = 0, front2 = 0;
        int i = 0;
        while (i < sublist1.size() - front1) {
            if (sublist2.size() - front2 != 0) {
                if (sublist1.get(front1) > sublist2.get(front2)) {
                    mergeList.add(sublist1.get(front1));
                    front1++;
                } else {
                    mergeList.add(sublist2.get(front2));
                    front2++;

                }
            } else {
                // sublist takes from first element to last exclusive
                // "not including the last"
                sublist1 = sublist1.subList(front1, sublist1.size());
                mergeList.addAll(sublist1);
                front1 = sublist1.size();
            }
        }


        if (sublist2.size() - front2 != 0) {
            // sublist takes from first element to last exclusive "not including the last"
            sublist2 = sublist2.subList(front2, sublist2.size());
            mergeList.addAll(sublist2);
        }
        //garbage collector
        sublist1 = null;
        sublist2 = null;


        return mergeList;
    }

    //Quick Sort Algorithm

    private ArrayList<Integer> quickSortList = new ArrayList<Integer>();

    public void updateList(final ArrayList<Integer> x) {

        this.quickSortList = x;
    }

    public void quickSort(int left, int right) {
        int saveLeftIndex = left;
        int saveRightIndex = right;
        int pivot = left;
        if (left >= right) {
            return;
        }
        while (left != right) {
            if (pivot == left) {
                while (quickSortList.get(left) >= quickSortList.get(right)
                        && left < right) {
                    right--;
                }
                Collections.swap(quickSortList, right, left);
                pivot = right;
            } else {
                while (quickSortList.get(right) <= quickSortList.get(left)
                        && right > left) {
                    left++;
                }
                Collections.swap(quickSortList, left, right);
                pivot = left;

            }
        }
        quickSort(saveLeftIndex, pivot - 1);
        quickSort(pivot + 1, saveRightIndex);
    }


    public ArrayList<Integer> getquickSortList() {
        return quickSortList;
    }

    public ArrayList<Integer> heapSorter(final ArrayList<Integer> sortee) {
        BinaryHeap maximumHeap = new MaxHeap(sortee);
        ArrayList<Integer> temp = new ArrayList<Integer>();
        while (maximumHeap.heapSize() != 0) {
            temp.add(maximumHeap.heapExtractRoot());
        }
        maximumHeap = null;
        return temp;
    }
}
