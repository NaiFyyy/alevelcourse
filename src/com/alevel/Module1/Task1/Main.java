package com.alevel.Module1.Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> trainDisplay = new ArrayList<>();
        trainDisplay.add(new Locomotive().display());
        System.out.println("Make a train =)");
        while (true) {
            System.out.println("Выберите тип вагона: cargo, passngr_1cl, passngr_2cl ? Или end для завершения.");
            String input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "cargo":
                    trainDisplay.add(new Cargo().display());
                    continue;
                case "passngr_1cl":
                    trainDisplay.add(new Passngr_1cl().display());
                    continue;
                case "passngr_2cl":
                    trainDisplay.add(new Passngr_2cl().display());
                    continue;
            }
            if (input.equals("end"))
                break;
        }
        System.out.println();
        System.out.println("Choose the point of departure : Kharkov, Kyiv, Lviv");
        City start = null;
        String s = scanner.nextLine().trim().toUpperCase();
        start = City.valueOf(s);

        System.out.println();
        System.out.println("Select an arrival point : Kharkov, Kyiv, Lviv");
        City finish = null;
        String f = scanner.nextLine().trim().toUpperCase();
        finish = City.valueOf(f);

        System.out.println();
        System.out.println("Train goes from " + start + " to " + finish + ".");
        System.out.println("Train scheme:");
        System.out.print(trainDisplay.get(0));
        for (int i = 1; i < trainDisplay.size(); i++) {
            System.out.print(trainDisplay.get(i));
        }
    }
}