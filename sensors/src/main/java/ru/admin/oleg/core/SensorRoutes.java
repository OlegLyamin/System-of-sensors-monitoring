package ru.admin.oleg.core;

import org.apache.camel.CamelContext;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public class SensorRoutes extends RouteBuilder {

    @Autowired
    private JSONProcessor jsonProcessor;

    @Autowired
    private SensorRuntimeProcessor sensorRuntimeProcessor;

    @Override
    public void configure() throws Exception {




            from("timer://timer?period=1000")
                    .process(this.sensorRuntimeProcessor)
                    .log("FIRSR ROUT")
                    .to("direct:json");


            from("direct:json")
                    .process(this.jsonProcessor)
                    .log("SECOND ROUT")
                    .to("direct:testJSON");


		/*from("direct:testJSON")
			.setHeader(Exchange.HTTP_METHOD, constant(org.apache.camel.component.http4.HttpMethods.POST))
			.to("http4:127.0.0.1:8080/backend/sensorendpoint")
			.log("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");*/

            from("direct:testJSON")
                    .process(new Processor() {

                        @Override
                        public void process(Exchange exchange) throws Exception {
                            log.info(exchange.getIn().getBody().toString());
                        }
                    });


    }
}
