package com.dhanush.tree;

import java.util.ArrayList;

public class AVLTree<T extends Comparable<T>> {
    private class Node {
        private T value;
        private int height;
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
        root = insert(root, value);
    }

    private Node insert(Node root, T value) {
        if (root == null)
            return new Node(value);

        if (value.compareTo(root.value) < 0)
            root.left = insert(root.left, value);
        else
            root.right = insert(root.right, value);
        setHeight(root);
        return balance(root);
    }

    private Node balance(Node root) {
        if (balanceFactor(root) > 1) {
            if (balanceFactor(root.left) < 0)
                root.left = rol(root.left);
            return ror(root);
        }
        else if (balanceFactor(root) < -1) {
            if (balanceFactor(root.right) > 0)
                root.right = ror(root.right);
            return rol(root);
        }
        return root;
    }

    private Node rol(Node root) {
        Node newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private Node ror(Node root) {
        Node newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private void setHeight(Node node) {
        node.height = Math.max(height(node.left),
                height(node.right)) + 1;
    }

    private int balanceFactor(Node node) {
        return (node == null) ?
                0 : height(node.left) - height(node.right);
    }

    private int height(Node node) {
        return  (node == null) ?  -1 : node.height;
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

    public boolean equals(AVLTree other) {
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

    @Override
    public String toString() {
        return traverseInOrder().toString();
    }
}
