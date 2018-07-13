package com.alevel.practice.oop;

public class Car extends AbstractTransport {
    @Override
    protected int getCostMultiplier() {
        return 0;
    }

    @Override
    public double calculateCost(Package pkg) {
        return super.calculateCost(pkg);
    }
}

