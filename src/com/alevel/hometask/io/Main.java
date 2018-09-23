package com.alevel.hometask.io;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter input file name: ");
        String input = scan.nextLine();
        System.out.println("Enter number of lines to copy: ");
        int lines = scan.nextInt();
        System.out.println("Enter output file name: ");
        String output = scan.nextLine();
        InputOutput io = new InputOutput(input, lines, output);
        io.copyFile();
    }
}