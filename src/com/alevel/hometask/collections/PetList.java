package com.alevel.hometask.collections;

import java.util.Arrays;

class PetList<T> {
    private T[] info;
    private int position;

    PetList() {
        this(10);
    }

    private PetList(int quantity) {
        this.info = (T[]) new Object[quantity];
        this.position = 0;
    }

    int size() {
        return position;
    }


    void add(T element) {
        if (position == info.length - 1) {
            this.info = Arrays.copyOf(this.info, info.length * 2);
        }
        this.info[position] = element;
        position++;
    }

    T get(int index) {
        return info[index];
    }

    void print() {
        for (int i = 0; i < position; i++) {
            System.out.println(info[i]);
        }
    }
}