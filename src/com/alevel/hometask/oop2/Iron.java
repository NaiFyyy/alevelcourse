package com.alevel.hometask.oop2;

public final class Iron implements Substance {
    private double temp = 20;

    @Override
    public State heatUp(double t) {
        temp += t;
        State state;
        if (temp > 1538) {
            state = State.LIQUID;
        } else {
            state = State.SOLID;
        }
        return state;
    }

    @Override
    public double getTemperature() {
        return temp;
    }
}
