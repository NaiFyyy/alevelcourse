package com.alevel.practice.oop;

public class Package {
    private final String name;
    private final double volume;
    private final double mass;

    public Package(String name, double volume, double mass) {
        this.name = name;
        this.volume = volume;
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public double getVolume() {
        return volume;
    }

    public double getMass() {
        return mass;
    }
}

