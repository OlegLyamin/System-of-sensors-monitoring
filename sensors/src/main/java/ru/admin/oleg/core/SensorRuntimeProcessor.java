package ru.admin.oleg.core;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SensorRuntimeProcessor implements Processor {

    @Autowired
    SensorRuntime sensorRuntime;

    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.getOut().setBody(this.sensorRuntime.getSensors());
    }
}
