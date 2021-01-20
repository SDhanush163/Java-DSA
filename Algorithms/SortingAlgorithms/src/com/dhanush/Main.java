package com.dhanush;

import com.dhanush.sorter.BubbleSort;
import com.dhanush.sorter.InsertionSort;
import com.dhanush.sorter.MergeSort;
import com.dhanush.sorter.SelectionSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n--------------- Bubble Sort ----------------");
	    int[] arr1 = {6,21,4,7,2,1};
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println("Unsorted : " + Arrays.toString(arr1));
        bubbleSort.sort(arr1);
        System.out.println("Sorted : " + Arrays.toString(arr1));

        System.out.println("\n-------------- Selection Sort --------------");
        int[] arr2 = {10,3,2,4,6,1,12};
        SelectionSort selectionSort = new SelectionSort();
        System.out.println("Unsorted : " + Arrays.toString(arr2));
        selectionSort.sort(arr2);
        System.out.println("Sorted : " + Arrays.toString(arr2));

        System.out.println("\n-------------- Insertion Sort --------------");
        int[] arr3 = {19,9,10,7,12,15};
        InsertionSort insertionSort = new InsertionSort();
        System.out.println("Unsorted : " + Arrays.toString(arr3));
        insertionSort.sort(arr3);
        System.out.println("Sorted : " + Arrays.toString(arr3));

        System.out.println("\n---------------- Merge Sort ----------------");
        int[] arr4 = {20,19,21,8,4,0};
        MergeSort mergeSort = new MergeSort();
        System.out.println("Unsorted : " + Arrays.toString(arr4));
        mergeSort.sort(arr4);
        System.out.println("Sorted : " + Arrays.toString(arr4));
    }
}
