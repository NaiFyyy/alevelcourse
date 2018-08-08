package com.alevel.Module1.Task1;

public class Locomotive implements Vagon {
    private int capacity;

    Locomotive() {
    }

    @Override
    public String display() {
        return "<:locomotive]";
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
