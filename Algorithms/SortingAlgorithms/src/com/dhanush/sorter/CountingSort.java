package com.dhanush.sorter;

public class CountingSort {
    public void sort(int[] arr) {
        int max = 0;
        for (int item : arr)
            if (item > max)
                max = item;
        sort(arr, max);
    }

    public void sort(int[] arr, int max) {
        int[] counts = new int[max + 1];
        for (int item : arr)
            counts[item]++;

        int k = 0;

        for (int i = 0; i < counts.length; i++)
            for (int j = 0; j < counts[i]; j++)
                arr[k++] = i;
    }
}
