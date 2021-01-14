package com.dhanush;

import com.dhanush.queue.ArrayQueue;
import com.dhanush.queue.StackedQueue;

public class Main {

    public static void main(String[] args) {
        System.out.println("Array Queue begins here");
        ArrayQueue<Integer> queue1 = new ArrayQueue<>();
        queue1.add(10);
        queue1.add(20);
        queue1.add(30);
        int size1 = queue1.size();
        for (int i = 0 ; i < size1; i++)
            System.out.println(queue1.poll());
        System.out.println("Array queue ends here");

        System.out.println("Stack queue starts here");
        StackedQueue<Integer> queue2 = new StackedQueue<>();
        queue2.add(10);
        queue2.add(20);
        queue2.add(30);
        int size2 = queue2.size();
        for (int i = 0 ; i < size2; i++)
            System.out.println(queue2.poll());
        System.out.println("Stack queue ends here");
    }
}
