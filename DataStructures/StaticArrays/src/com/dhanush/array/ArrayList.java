package com.dhanush.array;

import java.util.Arrays;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class ArrayList<T> {
    private final T[] items;
    private final int size;
    private int count = 0;

    public ArrayList(int initialSize) {
        this.items = (T[]) new Object[initialSize];
        this.size = initialSize;
    }

    public void add(T item) {
        if (count == size) {
            String errorMessage = "Given size [" + size + "] exceeded";
            throw new ArrayIndexOutOfBoundsException(errorMessage);
        }
        items[count++] = item;
    }

    public T get(int index) {
        if (isIndexOutOfBound(index)) {
            String errorMessage = "No value found at index " + index;
            throw new IndexOutOfBoundsException(errorMessage);
        }
        return items[index];
    }

    public int indexOf(T item) {
        for (int index = 0; index < items.length; index++)
            if (items[index] == item)
                return index;
        String errorMessage = "Could not find " + item + " in the array";
        throw new NoSuchElementException(errorMessage);
    }

    public void updateAt(int index, T item) {
        if (isIndexOutOfBound(index - 1)) {
            String errorMessage = "No value found at index " + index;
            throw new IndexOutOfBoundsException(errorMessage);
        }
        items[index - 1] = item;
    }

    public void removeAt(int index) {
        if (isIndexOutOfBound(index)) {
            String errorMessage = "No value found at index " + index;
            throw new IndexOutOfBoundsException(errorMessage);
        }
        if (count - 1 - index >= 0)
            System.arraycopy(items, index + 1,
                    items, index, count - 1 - index);
        count--;
    }

    private boolean isIndexOutOfBound(int index) {
        return index < 0 || index >= count;
    }

    @Override
    public String toString() {
        T[] stringArray = (T[]) new Object[count];
        if (count >= 0) System.arraycopy(items, 0, stringArray, 0, count);
        return "Items = " + Arrays.toString(stringArray) +
                "\nsize = " + size;
    }
}
