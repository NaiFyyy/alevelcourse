package com.alevel.Proectis1;


import java.util.Scanner;

public class Task20 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите количество чисел: ");
        int a = s.nextInt();
        int[] mas = new int[a];
        System.out.println("Введите числа в массив: ");
        for (int i = 0; i < mas.length; i++) {
            mas[i] = s.nextInt();
        }
        int max = mas[0], min = mas[0];
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] > max) {
                max = mas[i];
            }
            if (mas[i] < min) {
                min = mas[i];
            }
        }
        System.out.println("Максимальное число: " + max);
        System.out.println("Минимальное число: " + min);
    }

}