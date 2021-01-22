package com.dhanush.Heap;

import java.util.Arrays;

public class Heap<T extends Comparable<T>> {
    private T[] items;
    private int size;
    private int count;

    public Heap() {
        this.items = (T[]) new Comparable[10];
        this.size = 10;
    }

    public Heap(int size) {
        this.items = (T[]) new Comparable[size];
        this.size = size;
    }

    private void increaseArraySize() {
        size = (size < 100) ? size * 2 : size + 100;

        T[] resizedArray = (T[]) new Comparable[size];
        System.arraycopy(items, 0, resizedArray, 0, items.length);
        items = resizedArray;
    }

    public void insert(T item) {
        if(isFull())
            increaseArraySize();
        items[count++] = item;
        bubbleUp();
    }

    public void remove() {
        if (isEmpty()) {
            String errorMessage = "Cannot remove root as the Heap is empty";
            throw new IllegalStateException(errorMessage);
        }
        items[0] = items[count - 1];
        items[--count] = null;
        bubbleDown();
    }

    private void bubbleUp() {
        int index = count - 1;
        while (index > 0 && items[index].compareTo(items[parentIndex(index)]) > 0) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    private void bubbleDown() {
        int index = 0;
        while (index <= count && !isValidParent(index)) {
            swap(index, largerChildIndex(index));
            index = largerChildIndex(index);
        }
    }

    private void swap(int first, int second) {
        T temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }

    private boolean isValidParent(int index) {
        int leftChildIndex = leftChildIndex(index);
        int rightChildIndex = rightChildIndex(index);

        if (leftChildIndex > count - 1)
            return true;

        boolean isValid = items[index].compareTo(items[leftChildIndex]) >= 0;
        if (rightChildIndex <= count - 1)
            isValid = isValid && (items[index].compareTo(items[rightChildIndex]) >= 0);

        return isValid;
    }

    private int largerChildIndex(int index) {
        int leftChildIndex = leftChildIndex(index);
        int rightChildIndex = rightChildIndex(index);

        if (leftChildIndex > count)
            return index;
        if (rightChildIndex > count)
            return leftChildIndex;

        return (items[leftChildIndex].compareTo(items[rightChildIndex]) > 0) ?
                leftChildIndex : rightChildIndex;
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    public boolean isFull() {
        return count == size;
    }

    public  boolean isEmpty() {
        return count == 0;
    }

    public T max() {
        return items[0];
    }

    @Override
    public String toString() {
        T[] arrayItems = (T[]) new Comparable[count];
        if (count >= 0) System.arraycopy(items, 0, arrayItems, 0, count);
        return "Items=" + Arrays.toString(arrayItems)
                + "\nSize = " + count;
    }
}
