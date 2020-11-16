package com.dhanush;

import com.dhanush.array.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Static arrays project here");
        ArrayList<Integer> list = new ArrayList<>(3);
        list.add(1);
        list.add(2);
        list.add(10);
        int index = list.indexOf(2);

        System.out.println("Index of 2 : " + index);
        System.out.println("Initial list details : \n" + list);

        list.updateAt(3, 3);
        list.removeAt(1);
        System.out.println("Final list details : \n" + list);
    }
}
