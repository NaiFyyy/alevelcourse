package com.alevel.hometask.Exceptions;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            System.out.println("Введите initial :");
            int initial = scanner.nextInt();
            System.out.println("Введите step:");
            int step = scanner.nextInt();
            System.out.println("Введите n:");
            int n = scanner.nextInt();
            try {
                System.out.print("Result : ");
                System.out.println(new ArithmeticProgression(initial, step).calculate(n));
            } catch (ProgressionConfigurationException e) {
                System.err.println(e.getMessage());
            }
    }
}