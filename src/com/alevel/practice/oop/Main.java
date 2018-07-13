package com.alevel.practice.oop;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        System.out.println("Введите имя посылки :");
        name = scanner.nextLine();
        double volume;
        System.out.println("Введите обьем посылки :");
        volume = scanner.nextDouble();
        double mass;
        System.out.println("Введите массу посылки :");
        mass = scanner.nextDouble();
        System.out.println("Выберите одно из видов транспорта: plane, train, car ?");
        Transport s = null;
        while (s == null) {
            String input = scanner.next().trim().toLowerCase();
            switch (input) {
                case "plane":
                    s = new Plane();
                    break;
                case "train":
                    s = new Train();
                    break;
                case "car":
                    s = new Car();
                    break;
            }
        }
        Package pkg = new Package(name, volume, mass);
        System.out.println("Введите начальный пункт: ");
        City city1 = City.valueOf(scanner.next().trim().toUpperCase());
        System.out.println("Введите конечный пункт: ");
        City city2 = City.valueOf(scanner.next().trim().toUpperCase());
        System.out.println("Package " + name + " доставили из " + city1 + " доставили в " + city2 + " Стоимость : " + s.calculateCost(pkg));


    }
}