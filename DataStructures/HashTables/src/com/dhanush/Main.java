package com.dhanush;

import com.dhanush.hashtable.HashTable;

public class Main {

    public static void main(String[] args) {
        HashTable<Integer, String> table = new HashTable<>();
        table.put(1, "A");
        table.put(2, "B");
        table.put(3, "C");
        table.put(4, "D");
        table.put(5, "E");
        System.out.println(table);
        System.out.println("Get value at 3 : " + table.get(3));
        System.out.println("contains key 6? : " + table.containsKey(6));
        System.out.println("Contains val 'A'? : " + table.containsValue("A"));

        table.remove(4);
        System.out.println("\nAfter removing value at key 4");
        System.out.println(table);

    }
}
