package com.dhanush;

import com.dhanush.trie.Trie;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("root");
        trie.insert("robot");
        trie.insert("roost");
        trie.insert("rope");

        List<String> list1 = trie.getWords("rooo");
        List<String> list2 = trie.getWords("roo");
        List<String> list3 = trie.getWords();
        trie.remove("roost");
        List<String> list4 = trie.getWords();

        System.out.println("Get words that start with 'rooo' = " + list1.toString());
        System.out.println("Get words that start with 'roo'  = " + list2.toString());
        System.out.println("Before removing 'roost'          = " + list3.toString());
        System.out.println("After removing 'roost'           = " + list4.toString());
        System.out.println("Trie ends here");
    }
}
