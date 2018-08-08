package com.alevel.Module1.Task1;

public class Passngr_2cl implements Vagon {
    private int capacity;

    Passngr_2cl() {
        capacity = 100 + (int) (Math.random() * 200);
    }

    @Override
    public String display() {
        return "=[:passngr:2cl:" + capacity + ']';
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
