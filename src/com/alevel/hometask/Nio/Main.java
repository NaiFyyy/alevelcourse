package com.alevel.hometask.Nio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter input file name: ");
        String input = scanner.nextLine();
        System.out.println("Enter number of lines to copy: ");
        int lines = scanner.nextInt();
        System.out.println("Enter output file name: ");
        String output = scanner.nextLine();
        NewInputOutput nio = new NewInputOutput(input, lines, output);
        nio.CopyFail();
    }
}
