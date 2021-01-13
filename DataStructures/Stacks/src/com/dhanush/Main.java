package com.dhanush;

import com.dhanush.stack.ArrayStack;
import com.dhanush.stack.ListStack;

public class Main {

    public static void main(String[] args) {
        System.out.println("Array based Stack begins here");
        ArrayStack<Integer> stack1 = new ArrayStack<>(10);
        stack1.push(10);
        stack1.push(20);
        stack1.push(30);
        stack1.push(40);

        System.out.println("Stack before pop\n" + stack1.toString());
        System.out.println("Popping last element : " + stack1.pop());
        System.out.println("Stack after pop\n" + stack1.toString());
        System.out.println("Array based stack ends here");

        System.out.println("Linked list based Stack begins here");
        ListStack<Integer> stack2 = new ListStack<>();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        stack2.push(4);
        System.out.println("Stack before pop\n" + stack2.toString());
        System.out.println("Popping last element : " + stack2.pop());
        System.out.println("Stack after pop\n" + stack2.toString());
        System.out.println("Linked list based Stack ends here");
    }
}
