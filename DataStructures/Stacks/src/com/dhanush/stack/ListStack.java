package com.dhanush.stack;

import java.util.Arrays;

public class ListStack<T> {
    private class Node {
        private T value;
        private Node next;

        public Node (T value) {
            this.value = value;
        }
    }

    private Node head;
    private int size;

    public void push(T item) {
        Node tmp = head;
        head = new Node(item);
        head.next = tmp;
        size++;
    }

    public T pop(){
        if (isEmpty()) {
            String errorMessage = "Stack is empty";
            throw new IllegalStateException(errorMessage);
        }
        T value = head.value;
        head = head.next;
        size--;
        return value;
    }

    public T peek(){
        if (isEmpty()) {
            String errorMessage = "Stack is empty";
            throw new IllegalStateException(errorMessage);
        }
        return head.value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public T[] toArray() {
        T[] array = (T[]) new Object[size];
        int index = 0;
        Node current = head;

        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    @Override
    public String toString() {
        T[] items = toArray();
        return "Items = " + Arrays.toString(items) +
                "\nsize = " + size;
    }
}
