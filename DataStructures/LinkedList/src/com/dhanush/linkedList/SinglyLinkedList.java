package com.dhanush.linkedList;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
    private class Node {
        private T value;
        private Node next;

        public Node (T value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void addFirst(T item) {
        Node node = new Node(item);

        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public void addLast(T item) {
        Node node = new Node(item);

        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
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

        if (first == last) {
            first = last = null;
            return;
        }

        Node temp = first.next;
        first.next = null;
        first = temp;
        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            String errorMessage = "Could not find any item in the list";
            throw new NoSuchElementException(errorMessage);
        }

        if (first == last) {
            first = last = null;
            return;
        }

        last = getPreviousNode(last);
        last.next = null;
        size--;
    }

    public void reverse() {
        if(isEmpty())
            return;

        Node previous = first;
        Node current = first.next;

        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    public int indexOf(T item) {
        int index = 0;
        Node currentNode = first;

        while (currentNode != null) {
            if (currentNode.value == item)
                return  index;
            currentNode = currentNode.next;
            index++;
        }
        return -1;
    }

    public boolean contains(T item) {
        return indexOf(item) != -1;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size () {
        return size;
    }

    public T[] toArray() {
        T[] array = (T[]) new Object[size];
        int index = 0;
        Node current = first;

        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }


    // Helper methods
    private Node getPreviousNode(Node node) {
        Node currentNode = first;
        while (currentNode != null) {
            if (currentNode.next == node)
                return  currentNode;
            currentNode = currentNode.next;
        }
        return null;
    }

    @Override
    public String toString() {
        T[] items = toArray();
        return Arrays.toString(items);
    }
}
