package com.alevel.hometask.Exceptions;

public class ArithmeticProgression {

    private final int initial;
    private final int step;

    public ArithmeticProgression(int initial, int step) throws ProgressionConfigurationException {
        if (step == 0) {
            throw new ProgressionConfigurationException("The step is zero! Again");
        }
        this.initial = initial;
        this.step = step;
    }

    int calculate(int n) throws ProgressionConfigurationException {
        if (n <= 0) {
            throw new ProgressionConfigurationException("Need n > 0");
        }
        return initial + step * (n - 1);

    }

}