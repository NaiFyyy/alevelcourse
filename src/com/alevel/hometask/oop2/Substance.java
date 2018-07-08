package com.alevel.hometask.oop2;

import javax.swing.plaf.nimbus.State;

public interface Substance {
    State heatUp(double t);
    double getTemperature();

}
