package ru.admin.oleg.simulator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiscreteStrategy implements SimulatorStrategy {
    private static Logger Log = LoggerFactory.getLogger(DiscreteStrategy.class);
    private int counter;
    private int value;
    private int pulse;

    public DiscreteStrategy() {
        Log.info("СОЗДАНИЕ ДИСКРЕТНОЙ СТРАТЕГИИ ИЗ БИНА");
        this.value = 0;
        this.pulse = 1;
    }
    @Override
    public void doSimulate(SensorSetter sensor) {
        if (this.pulse % this.counter == 0 ) {
            if (this.value == 0) {
                this.value = 1;
            } else {
                this.value = 0;
            }
            this.pulse = 1;
        } else {
            this.pulse ++;
        }
        sensor.setValue(value);
    }

    @Override
    public void setPulseCounter(int counter) {
        this.counter = counter;
    }
}
