package com.alevel.Module1.Task1;

public class Passngr_1cl implements Vagon {
    private int capacity;

    Passngr_1cl() {
        capacity = (int) (Math.random() * 100);
    }

    @Override
    public String display() {
        return "=[:passngr:1cl:" + capacity + ']';
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

