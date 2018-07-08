package com.alevel.hometask.oop;

public class ContractStudent extends Student {
    private double value;

    public ContractStudent(String name, int age, double value) {
        super(name, age);
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
