package com.dhanush.sorter;

import com.dhanush.util.Merge;

public class MergeSort {
    public void sort(int[] arr) {
        if (arr.length < 2)
            return;
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        if (arr.length - mid >= 0)
            System.arraycopy(arr, mid, right, 0, arr.length - mid);

        sort(left);
        sort(right);
        new Merge(left, right, arr);
    }
}
