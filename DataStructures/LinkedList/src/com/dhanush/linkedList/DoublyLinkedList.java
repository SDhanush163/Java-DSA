package com.dhanush.linkedList;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> {
    private class Node {
        private T value;
        private Node prev;
        private Node next;

        public Node (T value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void addFirst(T item) {
        Node node = new Node(item);

        if (isEmpty())
            head = tail = node;
        else {
            head.prev = node;
            node.next = head;
            head = node;
        }
        size++;
    }

    public void addLast(T item) {
        Node node = new Node(item);

        if (isEmpty())
            head = tail = node;
        else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public void add(T item) {
        addLast(item);
    }

    public void removeFirst() {
        if (isEmpty()) {
            String errorMessage = "Could not find any item in the list";
            throw new NoSuchElementException(errorMessage);
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        Node temp = head.next;
        head.next = null;
        temp.prev = null;
        head = temp;
        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            String errorMessage = "Could not find any item in the list";
            throw new NoSuchElementException(errorMessage);
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        Node temp = tail.prev;
        tail.prev = null;
        temp.next = null;
        tail = temp;
        size--;
    }

    public int size() {
        return  size;
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
        return Arrays.toString(items);
    }

}
