package com.dhanush;

import com.dhanush.tree.BinarySearchTree;

public class Main {

    public static void main(String[] args) {
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
        System.out.println("Binary Tree ends here ");
    }
}
