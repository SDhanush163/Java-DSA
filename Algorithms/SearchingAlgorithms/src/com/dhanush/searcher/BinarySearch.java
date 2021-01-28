package com.dhanush.searcher;

public class BinarySearch {
    public int search(int[] arr, int target) {
        return search(arr, target, 0 , arr.length - 1);
    }

    // Recursion
    private int search(int[] arr, int target, int left, int right) {
        if (right < left)
            return -1;
        int mid = (left + right) / 2;

        if (arr[mid] == target)
            return mid;

        if (arr[mid] > target)
            return search(arr, target, left, mid - 1);
        return search(arr, target, mid + 1, right);
    }

    // Iteration
    private int search2(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return -1;
    }
}
