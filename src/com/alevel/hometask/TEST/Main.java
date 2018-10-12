package com.alevel.hometask.TEST;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {20, 10, 50, 30, 40};
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                swap(array, i, i + 1);
            }
        }
        System.out.println(Arrays.toString(array));

    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;

    }
}
