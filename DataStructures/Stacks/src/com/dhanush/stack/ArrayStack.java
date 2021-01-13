package com.dhanush.stack;

import java.util.Arrays;

public class ArrayStack<T> {
    private T[] items;
    private int count;
    private final int size;

    public ArrayStack(int size) {
        this.items = (T[]) new Object[size];
        this.size = size;
        this.count = 0;
    }

    public void push(T item) {
        if (isFull()) {
            String errorMessage = "Stack size limit reached. Current size : " + size;
            throw new StackOverflowError(errorMessage);
        }
        items[count++] = item;
    }

    public T pop() {
        if (isEmpty()) {
            String errorMessage = "Stack is empty";
            throw new IllegalStateException(errorMessage);
        }
        return items[--count];
    }

    public T peek() {
        if (isEmpty()) {
            String errorMessage = "Stack is empty";
            throw new IllegalStateException(errorMessage);
        }
        return items[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == size;
    }

    @Override
    public String toString() {
        T[] stringArray = Arrays.copyOfRange(items, 0, count);
        return "Items = " + Arrays.toString(stringArray) +
                "\nsize = " + count;
    }

}
