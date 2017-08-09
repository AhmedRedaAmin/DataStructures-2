package TrialPackage;

import eg.edu.alexu.csd.filestructure.binaryHeaps.BinaryHeap;
import eg.edu.alexu.csd.filestructure.binaryHeaps.MaxHeap;
import eg.edu.alexu.csd.filestructure.binaryHeaps.MultiSorterInterface;
import eg.edu.alexu.csd.filestructure.binaryHeaps.Sorter;

import java.util.ArrayList;

/**
 * Created by ahmed on 3/17/17.
 */
public class Thread1 extends Thread{
    public void run (){
        BinaryHeap binaryHeap;
        MultiSorterInterface MultiSort = new Sorter();

//        Fruit[] fruits = new Fruit[4];
        ArrayList<Integer> fruitList = new ArrayList<Integer>();
//        Fruit pineappale = new Fruit("Pineapple", "Pineapple description", 80);
//        Fruit apple = new Fruit("Apple", "Apple description", 100);
//        Fruit orange = new Fruit("Orange", "Orange description", 70);
//        Fruit banana = new Fruit("Banana", "Banana description", 90);
        // Heap - HeapSort
        fruitList.clear();
        fruitList.add(10);
        fruitList.add(13);
        fruitList.add(9);
        fruitList.add(81);
        fruitList.add(11);
        fruitList.add(12);
        fruitList.add(4);
        fruitList.add(1);
        fruitList.add(102);
        fruitList.add(133);
        fruitList.add(91);
        fruitList.add(831);
        fruitList.add(101);
        fruitList.add(73);
        fruitList.add(95);
        fruitList.add(67);
        fruitList.add(45);
        fruitList.add(190);
        fruitList.add(450);
        fruitList.add(13);
//        fruits[0] = pineappale;
//        fruits[1] = apple;
//        fruits[2] = orange;
//        fruits[3] = banana;
        binaryHeap = new MaxHeap(fruitList);
//        binaryHeap.heapInsert(30);
//        binaryHeap.heapInsert(40);
//        binaryHeap.heapInsert(50);
//        binaryHeap.heapInsert(60);
//        binaryHeap.heapInsert(370);
//        binaryHeap.heapInsert(70);
//        binaryHeap.heapInsert(80);
//        binaryHeap.heapInsert(90);binaryHeap.heapInsert(320);
//        binaryHeap.heapInsert(310);
        long start = System.nanoTime();
        fruitList = MultiSort.heapSort(fruitList);
        long end = System.nanoTime();
        long period = end - start ;
        System.out.println(period+" heap");

        int i = 0;
        for(Integer temp: fruitList){
            System.out.println("fruits " + ++i + " : " + temp );
        }

        // merge sort
        fruitList = new ArrayList<Integer>();
        fruitList.add(10);
        fruitList.add(13);
        fruitList.add(9);
        fruitList.add(81);
        fruitList.add(11);
        fruitList.add(12);
        fruitList.add(4);
        fruitList.add(1);
        fruitList.add(102);
        fruitList.add(133);
        fruitList.add(91);
        fruitList.add(831);
        fruitList.add(101);
        fruitList.add(73);
        fruitList.add(95);
        fruitList.add(67);
        fruitList.add(45);
        fruitList.add(190);
        fruitList.add(450);
        fruitList.add(13);
        fruitList.add(20);
        fruitList.add(30);
        fruitList.add(40);
        fruitList.add(50);
        fruitList.add(60);
        fruitList.add(65);
        fruitList.add(70);
        fruitList.add(75);
        fruitList.add(80);
        fruitList.add(90);
        fruitList.add(85);


        start = System.nanoTime();
        fruitList = MultiSort.mergeSort(fruitList);
        end = System.nanoTime();
        period = end - start ;
        System.out.println(period + " merge");
        i = 0;
        for(Integer temp: fruitList){
            System.out.println("fruits " + ++i + " : " + temp);
        }
        //quickSort
        fruitList.clear();
        fruitList.add(10);
        fruitList.add(13);
        fruitList.add(9);
        fruitList.add(81);
        fruitList.add(11);
        fruitList.add(12);
        fruitList.add(4);
        fruitList.add(1);
        fruitList.add(102);
        fruitList.add(133);
        fruitList.add(91);
        fruitList.add(831);
        fruitList.add(101);
        fruitList.add(73);
        fruitList.add(95);
        fruitList.add(67);
        fruitList.add(45);
        fruitList.add(190);
        fruitList.add(450);
        fruitList.add(13);
        fruitList.add(20);
        fruitList.add(30);
        fruitList.add(40);
        fruitList.add(50);
        fruitList.add(60);
        fruitList.add(65);
        fruitList.add(70);
        fruitList.add(75);
        fruitList.add(80);
        fruitList.add(90);
        fruitList.add(85);


        start = System.nanoTime();
        fruitList = MultiSort.quickSort(fruitList);
        end = System.nanoTime();
        period = end - start ;

        System.out.println(period + " quick");
        i = 0;
        for(Integer temp: fruitList){
            System.out.println("fruits " + ++i + " : " + temp);
        }
        //insertion Sort
        fruitList.clear();
        fruitList.add(10);
        fruitList.add(13);
        fruitList.add(9);
        fruitList.add(81);
        fruitList.add(11);
        fruitList.add(12);
        fruitList.add(4);
        fruitList.add(1);
        fruitList.add(102);
        fruitList.add(133);
        fruitList.add(91);
        fruitList.add(831);
        fruitList.add(101);
        fruitList.add(73);
        fruitList.add(95);
        fruitList.add(67);
        fruitList.add(45);
        fruitList.add(190);
        fruitList.add(450);
        fruitList.add(13);
        fruitList.add(20);
        fruitList.add(30);
        fruitList.add(40);
        fruitList.add(50);
        fruitList.add(60);
        fruitList.add(65);
        fruitList.add(70);
        fruitList.add(75);
        fruitList.add(80);
        fruitList.add(90);
        fruitList.add(85);


        start = System.nanoTime();
        fruitList = MultiSort.insertionSort(fruitList);
        end = System.nanoTime();
        period = end - start ;

        System.out.println(period + " insertion");
        i = 0;
        for(Integer temp: fruitList){
            System.out.println("fruits " + ++i + " : " + temp);
        }
        //selection Sort
        fruitList.clear();
        fruitList.add(10);
        fruitList.add(13);
        fruitList.add(9);
        fruitList.add(81);
        fruitList.add(11);
        fruitList.add(12);
        fruitList.add(4);
        fruitList.add(1);
        fruitList.add(102);
        fruitList.add(133);
        fruitList.add(67);
        fruitList.add(45);
        fruitList.add(190);
        fruitList.add(450);
        fruitList.add(13);
        fruitList.add(20);
        fruitList.add(30);
        fruitList.add(40);
        fruitList.add(50);
        fruitList.add(60);
        fruitList.add(65);
        fruitList.add(70);
        fruitList.add(75);
        fruitList.add(80);
        fruitList.add(90);
        fruitList.add(85);


        start = System.nanoTime();
        fruitList = MultiSort.selectionSort(fruitList);
        end = System.nanoTime();
        period = end - start ;

        System.out.println(period + " selection");
        i = 0;
        for(Integer temp: fruitList){
            System.out.println("fruits " + ++i + " : " + temp);
        }
        //bubbleSort
        fruitList.clear();
        fruitList.add(10);
        fruitList.add(13);
        fruitList.add(9);
        fruitList.add(81);
        fruitList.add(11);
        fruitList.add(12);
        fruitList.add(4);
        fruitList.add(1);
        fruitList.add(102);
        fruitList.add(133);
        fruitList.add(91);
        fruitList.add(831);
        fruitList.add(101);
        fruitList.add(73);
        fruitList.add(95);
        fruitList.add(67);
        fruitList.add(45);
        fruitList.add(190);
        fruitList.add(450);
        fruitList.add(13);
        fruitList.add(20);
        fruitList.add(30);
        fruitList.add(40);
        fruitList.add(50);
        fruitList.add(60);
        fruitList.add(65);
        fruitList.add(70);
        fruitList.add(75);
        fruitList.add(80);
        fruitList.add(90);
        fruitList.add(85);


        start = System.nanoTime();
        fruitList = MultiSort.bubbleSort(fruitList);
        end = System.nanoTime();
        period = end - start ;

        System.out.println(period + " bubble");
        i = 0;
        for(Integer temp: fruitList){
            System.out.println("fruits " + ++i + " : " + temp);
        }
    }




}
