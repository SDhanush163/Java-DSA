package com.dhanush.searcher;

public class TernarySearch {
    public int search(int[] arr, int target) {
        return search(arr, target, 0, arr.length - 1);
    }

    private int search(int[] arr, int target, int left, int right) {
        if (right < left)
            return -1;

        int partSize = (right - left) / 2;
        int mid1 = left + partSize;
        int mid2 = right - partSize;

        if (arr[mid1] == target)
            return mid1;
        if (arr[mid2] == target)
            return mid2;

        if (arr[mid1] > target)
            return search(arr, target, left, mid1 - 1);
        if (arr[mid2] < target)
            return search(arr, target, mid2 + 1, right);
        return search(arr, target, mid1 + 1, mid2 - 1);
    }
}
