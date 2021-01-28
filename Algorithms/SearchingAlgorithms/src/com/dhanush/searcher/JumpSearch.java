package com.dhanush.searcher;

public class JumpSearch {
    public int search(int[] arr, int target) {
        int block = (int) Math.sqrt(arr.length);
        int start = 0;
        int next = block;

        while (start < arr.length && arr[next - 1] < target) {
            start = next;
            next += block;

            if (next > arr.length)
                next = arr.length;
        }

        for (int i = start; i < next; i++)
            if (arr[i] == target)
                return i;
        return -1;
    }
}
