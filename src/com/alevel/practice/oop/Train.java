package com.alevel.practice.oop;

public class Train extends AbstractTransport {
    @Override
    protected int getCostMultiplier() {
        return 1;
    }

    @Override
    public double calculateCost(Package pkg) {
        return super.calculateCost(pkg);
    }
}
