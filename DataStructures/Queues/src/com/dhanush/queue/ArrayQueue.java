package com.dhanush.queue;

import java.util.Arrays;

public class ArrayQueue<T> {
    private final T[] items;
    private final int size;
    private int count;

    private int front = 0;
    private int rear = 0;

    public ArrayQueue() {
        this.items = (T[]) new Object[5];
        this.size = 5;
    }

    public ArrayQueue(int capacity) {
        this.items = (T[]) new Object[capacity];
        this.size = capacity;
    }

    public void add(T item) {
        if (isFull()) {
            String errorMessage = "Queue is full";
            throw new StackOverflowError(errorMessage);
        }
        items[rear] = item;
        rear = (rear + 1) % size;
        count++;
    }

    public void offer(T item) {
        if (isFull())
            return;
        items[rear] = item;
        rear = (rear + 1) % size;
        count++;
    }

    public T remove() {
        if (isEmpty()) {
            String errorMessage = "Queue is empty";
            throw new IllegalStateException(errorMessage);
        }
        T item = items[front];
        items[front] = null;
        front = (front + 1) % size;
        count--;
        return item;
    }

    public T poll() {
        if (isEmpty())
            return null;
        T item = items[front];
        items[front] = null;
        front = (front + 1) % size;
        count--;
        return item;
    }

    public T peek() {
        if (isEmpty())
            return null;
        return items[front];
    }

    public T element() {
        if (isEmpty()){
            String errorMessage = "Queue is empty";
            throw new IllegalStateException(errorMessage);
        }
        return items[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == size;
    }

    public int size() {
        return count;
    }
}
