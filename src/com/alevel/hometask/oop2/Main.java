package com.alevel.hometask.oop2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите одно из веществ: water, iron, oxygen ?");
        Substance s = null;
        while (s == null) {
            String input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "water":
                    s = new Water();
                    break;
                case "iron":
                    s = new Iron();
                    break;
                case "oxygen":
                    s = new Oxygen();
                    break;
            }
        }

        double t;
        System.out.println("Введите значение t :");
        do {
            t = scanner.nextDouble();
            State state = s.heatUp(t);
            double currentTemp = s.getTemperature();
            System.out.println("Substance was heated up by " + t + " degrees");
            System.out.println("It's state is now " + state + " and it's temperature is now " + currentTemp);
        } while (t != 0);
    }
}