package ru.admin.oleg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.admin.oleg.core.Sensor;
import ru.admin.oleg.core.SensorRuntime;
import ru.admin.oleg.simulator.SimulatorRuntime;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Logger Log = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
        Log.info("СТАРТ ПРОГРАММЫ");
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);

        while(true) {

        }

        //SensorRuntime sr =(SimulatorRuntime) ctx.getBean("sensorRuntime");

    }
}
