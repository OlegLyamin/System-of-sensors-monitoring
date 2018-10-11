package ru.admin.oleg.simulator;

public interface SimulatorStrategy {

    void doSimulate(SensorSetter sensor);
    void setPulseCounter(int counter);

}
