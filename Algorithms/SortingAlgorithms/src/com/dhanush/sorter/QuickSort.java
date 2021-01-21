package com.dhanush.sorter;

import com.dhanush.util.Swap;

public class QuickSort {
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int start, int end) {
        if (start >= end)
            return;
        int boundary = partition(arr, start, end);
        sort(arr, start, boundary-1);
        sort(arr, boundary+1, end);
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int boundary = start-1;

        for (int i = start; i <= end; i++)
            if (arr[i] <= pivot)
                new Swap(arr, i, ++boundary);
        return boundary;
    }
}
