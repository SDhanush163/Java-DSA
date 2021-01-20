package com.dhanush.tree;

import java.util.ArrayList;

public class BinarySearchTree<T extends Comparable<T>> {
    private class Node {
        private T value;
        private Node right;
        private Node left;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    private Node root;

    public void insert(T value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        while (true) {
            if (value.compareTo(current.value) < 0) {
                if (current.left == null) {
                    current.left = newNode;
                    break;
                }
                current = current.left;
            }
            else {
                if (current.right == null) {
                    current.right = newNode;
                    break;
                }
                current = current.right;
            }
        }
    }

    public boolean find(T value) {
        Node current = root;

        while (current != null)
            if (value.compareTo(current.value) < 0)
                current = current.left;
            else if (value.compareTo(current.value) > 0)
                current = current.right;
            else
                return true;

        return false;
    }

    public ArrayList<T> traversePreOrder() {
        ArrayList<T> list = new ArrayList<>();
        traversePreOrder(root, list);
        return list;
    }

    public ArrayList<T> traverseInOrder() {
        ArrayList<T> list = new ArrayList<>();
        traverseInOrder(root, list);
        return list;
    }

    public ArrayList<T> traversePostOrder() {
        ArrayList<T> list = new ArrayList<>();
        traversePostOrder(root, list);
        return list;
    }

    public ArrayList<T> traverseLevelOrder() {
        ArrayList<T> list = new ArrayList<>();
        for (int i = 0; i <= height(); i++) {
            list.addAll(getNodesAtDistance(i));
        }
        return list;
    }

    private void traversePreOrder(Node root, ArrayList<T> list) {
        if (root == null)
            return;

        list.add(root.value);
        traversePreOrder(root.left, list);
        traversePreOrder(root.right, list);

    }

    private void traverseInOrder(Node root, ArrayList<T> list) {
        if (root == null)
            return;

        traverseInOrder(root.left, list);
        list.add(root.value);
        traverseInOrder(root.right, list);
    }

    private void traversePostOrder(Node root, ArrayList<T> list) {
        if (root == null)
            return;

        traversePostOrder(root.left, list);
        traversePostOrder(root.right, list);
        list.add(root.value);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null)
            return -1;
        if (root.left == null && root.right == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public T min() {
        if (root == null) {
            String errorMessage = "Tree is empty";
            throw new IllegalStateException(errorMessage);
        }

        Node current = root;
        Node last = null;
        while (current != null) {
            last = current;
            current = current.left;
        }
        return last.value;
    }

    public T max() {
        if (root == null) {
            String errorMessage = "Tree is empty";
            throw new IllegalStateException(errorMessage);
        }

        Node current = root;
        Node last = null;
        while (current != null) {
            last = current;
            current = current.right;
        }
        return last.value;
    }

    public boolean equals(BinarySearchTree other) {
        if (other == null)
            return false;
        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null)
            return true;
        if (first != null && second != null)
            return first.value == second.value
                    && equals(first.left, second.left)
                    && equals(first.right, second.right);
        return false;
    }

    public ArrayList<T> getNodesAtDistance(int distance) {

        // Get the nodes at k distance and store it in the list
        ArrayList<T> list = new ArrayList<>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    private void getNodesAtDistance(Node root, int distance, ArrayList<T> list) {

        if (root == null) return;
        if (distance == 0) {
            list.add(root.value);
            return;
        }

        getNodesAtDistance(root.left, distance - 1, list);
        getNodesAtDistance(root.right, distance - 1, list);
    }

    @Override
    public String toString() {
        return traverseInOrder().toString();
    }
}
