package ru.admin.oleg;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.admin.oleg.core.Sensor;
import ru.admin.oleg.core.SensorRoutes;
import ru.admin.oleg.core.SensorRuntime;
import ru.admin.oleg.simulator.SimulatorRuntime;

import java.util.List;

@Configuration
@ComponentScan(basePackages = {"ru.admin.oleg.core"})
public class ApplicationConfig {

    @Bean
    public ClassPathXmlApplicationContext xmlContext() {
        return new ClassPathXmlApplicationContext("ApplicationConfig.xml");
    }

    @Bean
    SensorRuntime sensorRuntime() {
        SimulatorRuntime r = new SimulatorRuntime();
        r.setSensors((List<Sensor>) xmlContext().getBean("sensors"));
        r.start();
        return r;
    }


    @Bean
    SensorRoutes sensorRoutes() {
        SensorRoutes routes = new SensorRoutes();
        return routes;
    }

    @Bean
    CamelContext camelContext() throws Exception {
        CamelContext ctx = new DefaultCamelContext();
        ctx.addRoutes(sensorRoutes());
        ctx.start();
        return ctx;
    }
}
