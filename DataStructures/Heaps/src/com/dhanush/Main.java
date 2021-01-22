package com.dhanush;

import com.dhanush.Heap.Heap;

public class Main {

    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>();
        heap.insert(20);
        heap.insert(10);
        heap.insert(15);
        heap.insert(4);
        heap.insert(5);
        heap.insert(21);
        System.out.println("Max : " + heap.max());
        System.out.println("Original : " + heap);
        heap.remove();
        heap.remove();
        System.out.println("After remove : " + heap);
    }
}
