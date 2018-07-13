package com.alevel.practice.oop;

public class Plane extends AbstractTransport {
    @Override
    protected int getCostMultiplier() {
        return 5;
    }

    @Override
    public double calculateCost(Package pkg) {
        return super.calculateCost(pkg);
    }
}
