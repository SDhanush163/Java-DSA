package com.dhanush.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {
    public static int ALPHABET_SIZE = 26;

    private class Node {
        private char value;
        private Map<Character, Node> kids = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        // Abstractions

        public void addKid(char ch) {
            kids.put(ch, new Node(ch));
        }

        public Node getKid(char ch) {
            return kids.get(ch);
        }

        public void removeKid(char ch) {
            kids.remove(ch);
        }

        public boolean hasKid(char ch) {
            return kids.containsKey(ch);
        }

        public Node[] getKids() {
            return kids.values().toArray(new Node[0]);
        }

        public boolean hasKids() {
            return !kids.isEmpty();
        }

        @Override
        public String toString() {
            return "value=" + value;
        }
    }

    private Node root = new Node(' ');

    public void insert(String word) {
        Node current = root;

        for (char ch : word.toCharArray()) {
            if (!current.hasKid(ch))
                current.addKid(ch);
            current = current.getKid(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean contains(String word) {
        if (word == null)
            return false;

        Node current = root;
        for (char ch : word.toCharArray()) {
            if (!current.hasKid(ch))
                return false;
            current = current.getKid(ch);
        }
        return current.isEndOfWord;
    }

    public void remove(String word) {
        if (word == null)
            return;
        remove(root, word, 0);
    }

    private void remove(Node root, String word, int index) {
        if (index == word.length()) {
            root.isEndOfWord = false;
            return;
        }

        char ch = word.charAt(index);
        Node kid = root.getKid(ch);
        if (kid == null)
            return;

        remove(kid, word, index + 1);

        if (!kid.hasKids() && !kid.isEndOfWord)
            root.removeKid(ch);
    }

    public List<Character> traverse() {
        List<Character> chars = new ArrayList<>();
        traverse(root, chars);
        return chars;
    }

    private void traverse(Node root, List<Character> chars) {
        chars.add(root.value);
        for (Node kid : root.getKids())
            traverse(kid, chars);
    }

    public List<String> getWords() {
        List<String> words= new ArrayList<>();
        getWords(root,"", words);
        return words;
    }

    public List<String> getWords(String prefix) {
        List<String> words = new ArrayList<>();
        Node lastNode = findLastNodeOf(prefix);
        getWords(lastNode,prefix,words);
        return words;
    }

    private void getWords(Node root, String prefix, List<String> words) {
        if (root == null)
            return;
        if (root.isEndOfWord)
            words.add(prefix);
        for (Node kid : root.getKids())
            getWords(kid, prefix + kid.value, words);
    }

    private Node findLastNodeOf(String prefix) {
        Node current = root;
        for (char ch : prefix.toCharArray()) {
            Node kid = current.getKid(ch);
            if (kid == null)
                return null;
            current = kid;
        }
        return current;
    }
}
