package ru.admin.oleg.simulator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.admin.oleg.core.SensorRuntime;
import ru.admin.oleg.core.Sensor;


import java.util.List;

public class SimulatorRuntime extends Thread implements SensorRuntime {

    private static Logger Log = LoggerFactory.getLogger(SimulatorRuntime.class);
    private List<Sensor> sensors;

    @Override
    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }
    public void run(){
        while (true){
            this.emulate();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void emulate() {
        this.sensors
                .stream()
                .forEach(sensor -> {
                    if (sensor instanceof SensorSimulator) {
                        SensorSimulator s = (SensorSimulator) sensor;
                        s.emulate();
                        //log.info("INTERVAL:" + Integer.toString(this.runtimeInterval));
                        //log.info(s.getImei() + " = " + s.getValue());
                    }
                });
    }


}
