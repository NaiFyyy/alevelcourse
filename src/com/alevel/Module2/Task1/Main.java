package com.alevel.Module2.Task1;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Anton");
        list.add("Misha");
        list.add("Mama");
        list.add("Papa",3);
        System.out.println(list.get(1));
        System.out.println(list.size() + " elements");
        list.remove(0);
        System.out.println(list.size() + " elements");
        list.printList();
    }
}
