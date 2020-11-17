package com.dhanush;

import com.dhanush.array.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Dynamic arrays project here");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("List  : " + list);
        System.out.println("Count : " + list.size());
    }
}
