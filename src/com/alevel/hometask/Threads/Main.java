package com.alevel.hometask.Threads;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Input inputCheck = new Input();
        Thread t = new Thread(inputCheck);
        t.start();
        while (true) {
            System.out.println("Please input the text or type (quit)");
            String input = scanner.nextLine();
            inputCheck.addString(input);
            if (input.equals("quit")) {
                break;
            }
        }
    }
}