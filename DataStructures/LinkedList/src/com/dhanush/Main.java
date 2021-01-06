package com.dhanush;

import com.dhanush.linkedList.SinglyLinkedList;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Singly Linked List part here");
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        System.out.println("List : " + list1.toString());
        System.out.println("Size : " + list1.size());
        System.out.println("END of Singly Linked list");
    }
}
