package com.alevel.hometask.oop2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        Substance s = null;
        while (s == null) {
            String input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "water":
                    s = new Water();
                    break;
            }
        }
    }
}