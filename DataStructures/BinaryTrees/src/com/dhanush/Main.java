package com.dhanush;

import com.dhanush.tree.AVLTree;
import com.dhanush.tree.BinarySearchTree;

public class Main {

    public static void main(String[] args) {
        System.out.println("Binary Tree begins here");
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(10);
        tree.insert(12);
        tree.insert(13);
        tree.insert(14);
        tree.insert(8);
        tree.insert(9);
        tree.insert(7);

        System.out.println("Found (value = 15)? : " + tree.find(15));
        System.out.println(tree);
        System.out.println("Min value : " + tree.min());
        System.out.println("Max value : " + tree.max());
        System.out.println("Binary Tree ends here");

        System.out.println("\nAVL Tree begins here");
        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.insert(1);
        avlTree.insert(2);
        avlTree.insert(3);
        avlTree.insert(4);
        avlTree.insert(5);
        avlTree.insert(6);
        avlTree.insert(7);
        System.out.println("Found (value = 3)? : " + avlTree.find(3));
        System.out.println(avlTree);
        System.out.println("Min value : " + avlTree.min());
        System.out.println("Max value : " + avlTree.max());
        System.out.println("AVL Tree Ends here");
    }
}


