package com.dhanush;

import com.dhanush.searcher.BinarySearch;
import com.dhanush.searcher.JumpSearch;
import com.dhanush.searcher.LinearSearch;
import com.dhanush.searcher.TernarySearch;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n------------- Linear search -------------");
        int[] arr1 = {10,23,19,9,12};
        LinearSearch linearSearch = new LinearSearch();
        System.out.println("Array         : " + Arrays.toString(arr1));
        System.out.println("Index of '23' : " + linearSearch.search(arr1, 23));
        System.out.println("Index of '1'  : " + linearSearch.search(arr1, 1));

        System.out.println("\n------------- Binary search -------------");
        int[] arr2 = {2,4,6,8,10,12,14,16};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println("Array         : " + Arrays.toString(arr2));
        System.out.println("Index of '8'  : " + binarySearch.search(arr2, 8));
        System.out.println("Index of '13' : " + binarySearch.search(arr2, 13));

        System.out.println("\n------------- Ternary search ------------");
        int[] arr3 = {1,3,5,7,9,11,13,15};
        TernarySearch ternarySearch = new TernarySearch();
        System.out.println("Array        : " + Arrays.toString(arr3));
        System.out.println("Index of '5' : " + linearSearch.search(arr3, 5));
        System.out.println("Index of '8' : " + linearSearch.search(arr3,8));

        System.out.println("\n-------------- Jump search --------------");
        int[] arr4 = {2,4,8,16,32,64,128,256,512,1024};
        JumpSearch jumpSearch = new JumpSearch();
        System.out.println("Array          : " + Arrays.toString(arr4));
        System.out.println("Index of '64'  : " + jumpSearch.search(arr4, 64));
        System.out.println("Index of '127' : " + jumpSearch.search(arr4,127));
    }
}
