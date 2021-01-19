package com.dhanush.sorter;

import com.dhanush.util.Swap;

public class SelectionSort {
    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++)  {
            int minIndex = i;

            for (int j = i; j < array.length; j++)
                // < for ascending, > for descending
                if (array[j] < array[minIndex])
                    minIndex = j;

            new Swap(array, minIndex, i);
        }
    }
}
