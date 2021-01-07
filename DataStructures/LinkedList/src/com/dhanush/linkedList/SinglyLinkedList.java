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

    private Node head;
    private Node tail;
    private int size;

    public void addFirst(T item) {
        Node node = new Node(item);

        if (isEmpty())
            head = tail = node;
        else {
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

        tail = getPreviousNode(tail);
        tail.next = null;
        size--;
    }

    public void reverse() {
        if(isEmpty())
            return;

        Node previous = head;
        Node current = head.next;

        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        tail = head;
        tail.next = null;
        head = previous;
    }

    public int indexOf(T item) {
        int index = 0;
        Node currentNode = head;

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
        return head == null;
    }

    public int size () {
        return size;
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


    // Helper methods
    private Node getPreviousNode(Node node) {
        Node currentNode = head;
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
