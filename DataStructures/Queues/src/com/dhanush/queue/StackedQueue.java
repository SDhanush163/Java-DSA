package com.dhanush.queue;

import java.util.Stack;

public class StackedQueue<T> {
    private Stack<T> s1 = new Stack<>();
    private Stack<T> s2 = new Stack<>();
    private int count = 0;

    public void add(T item) {
        s1.push(item);
        count++;
    }

    public T remove() {
        if (isEmpty()) {
            String errorMessage = "Queue is empty";
            throw new IllegalStateException(errorMessage);
        }
        moveS1toS2();
        count--;
        return s2.pop();
    }

    public T poll() {
        if (isEmpty())
            return null;
        moveS1toS2();
        count--;
        return s2.pop();
    }

    public T peek() {
        if (isEmpty()) {
            String errorMessage = "Queue is empty";
            throw new IllegalStateException(errorMessage);
        }
        moveS1toS2();
        return s2.peek();
    }

    public T element() {
        if (isEmpty())
            return null;
        moveS1toS2();
        return s2.peek();
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    private void moveS1toS2() {
        if (s2.isEmpty())
            while (!s1.isEmpty())
                s2.push(s1.pop());
    }

    public int size() {
        return count;
    }

}
