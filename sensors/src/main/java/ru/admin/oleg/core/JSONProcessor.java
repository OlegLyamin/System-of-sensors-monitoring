package ru.admin.oleg.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JSONProcessor implements Processor {


    @Override
    public void process(Exchange exchange) throws Exception {
        Object ob = exchange.getIn().getBody();
        List<Sensor> sensors;
        if (ob instanceof List) {
            if(((List)ob).size() > 0 && (((List)ob).get(0) instanceof Sensor)){
                sensors = (List<Sensor>) ob;
                exchange.getOut().setBody(this.convertToJson(sensors));
            }
        }
    }

    private String convertToJson(List<Sensor> sensors) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(new JSONSchema() {

            public String getTitle() {
                return "Oleg";
            }

            public List<Sensor> getSensors() {
                return sensors;
            }
        });
    }

}
