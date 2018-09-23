package com.alevel.Module2.Task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Thread potok = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("bamm");
            }
        });

        Scanner sc = new Scanner(System.in);
        potok.start();
        
    }
}
