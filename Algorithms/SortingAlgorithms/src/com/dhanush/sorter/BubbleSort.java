package com.dhanush.sorter;

import com.dhanush.util.Swap;

public class BubbleSort {
    public void sort(int[] arr) {
        boolean isSorted;

        for (int i = 0; i < arr.length; i++) {
            isSorted = true;
            for (int j = 1; j < arr.length; j++)
                // < for ascending, > for descending
                if (arr[j] < arr[j - 1]) {
                    new Swap(arr, j, j - 1);
                    isSorted = false;
                }
            if (isSorted) return;
        }
    }
}
