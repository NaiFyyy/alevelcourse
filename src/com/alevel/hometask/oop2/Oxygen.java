package com.alevel.hometask.oop2;


public class Oxygen implements Substance {
    private double temp = 20;

    @Override
    public State heatUp(double t) {
        temp += t;
        State state;
        state = State.GAS;
        return state;
    }

    @Override
    public double getTemperature() {
        return temp;
    }
}
