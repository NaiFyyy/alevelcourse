package com.alevel.practice.oop;

public abstract   class AbstractTransport implements Transport {

    protected abstract int getCostMultiplier();

    @Override
    public double calculateCost(Package pkg) {
        return pkg.getMass() * pkg.getVolume() *getCostMultiplier();
    }
}
