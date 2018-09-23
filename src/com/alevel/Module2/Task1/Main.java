package com.alevel.Module2.Task1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Tom");
        names.add("Kate");
        names.add("Misha");

        names.add(3, "Anton");
        names.add(4, "Ira");

        System.out.println("First element :");
        System.out.println(names.get(0));
        System.out.println("Second element :");
        System.out.println(names.get(1));

        names.remove("Misha");
        names.remove(3);


        System.out.println();
        System.out.println("Our Arraylist - names :");
        System.out.println(names);
    }
}
