package br.com.impacta.camel.springboot.springapache;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SpringapacheRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("timer:example?period=1000")
            .log("Hello World");
    }
}
