package com.alevel.hometask.collections;

import java.util.Arrays;

public class PetList<T> {
    private T[] info;
    private int position;

    PetList() {
        this(10);
    }

    PetList(int quantity) {
        this.info = (T[]) new Object[quantity];
        this.position = 0;
    }

    public int size() {
        return this.info.length;
    }

    public void add(T element) {
        if (position == size()) {
            T[] temp;
            temp = Arrays.copyOf(this.info, size());
            this.info = temp;
        }
        this.info[position] = element;
        position++;
    }

    public void print() {
        for (T element : this.info) {
            if (element == null) {
                break;
            }
            System.out.println(element.toString());
        }
    }
}