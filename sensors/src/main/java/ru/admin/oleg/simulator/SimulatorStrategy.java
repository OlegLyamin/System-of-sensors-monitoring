package ru.admin.oleg.simulator;
/* This interface for rules of simulation*/
public interface SimulatorStrategy {

    void doSimulate(SensorSetter sensor);
    void setPulseCounter(int counter);

}
