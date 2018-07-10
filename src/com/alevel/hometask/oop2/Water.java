package com.alevel.hometask.oop2;

public final class Water implements Substance {

    private double temp = 20;


    @Override
    public State heatUp(double t) {
        temp += t;
        State state;
        if (temp > 100) {
            state = State.GAS;
        } else if (temp < 0) {
            state = State.SOLID;
        } else {
            state = State.LIQUID;
        }
        return state;
    }

    @Override
    public double getTemperature() {
        return temp;
    }
}
