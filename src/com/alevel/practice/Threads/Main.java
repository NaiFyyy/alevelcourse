package com.alevel.practice.Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<RaceHorse> list = new ArrayList<>();
        Hippodrome hippodrome = new Hippodrome();
        list.add(new RaceHorse("horse 1", hippodrome));
        list.add(new RaceHorse("horse 1", hippodrome));
        list.add(new RaceHorse("horse 1", hippodrome));
        list.add(new RaceHorse("horse 1", hippodrome));
        Scanner sc = new Scanner(System.in);
        System.out.println("Choice the horse : " + list + " ?");
        String k = null;
        while (k == null) {
            k = sc.nextLine().trim().toLowerCase();
            switch (k) {
                case "horse1":
                    System.out.println("Bet on horse1 $$$");
                    break;
                case "horse2":
                    System.out.println("Bet on horse2 $$$");
                    break;
                case "horse3":
                    System.out.println("Bet on horse3 $$$");
                    break;
                case "horse4":
                    System.out.println("Bet on horse4 $$$");
                    break;
            }
        }
        for (RaceHorse raceHorse : list) {
            new Thread(raceHorse).start();
        }
    }
}