package br.com.impacta.camel.springboot.springapache;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component
public class UpperBean {

    public void upperCase(Exchange exchange) {
        String messageBody = (String)exchange.getIn().getBody();
        if (messageBody != null && !messageBody.isEmpty()) {
            System.out.println("Current MessageBody content BEFORE Transformation: " + messageBody);
            exchange.getIn().setBody(messageBody.toUpperCase());
            System.out.println("Current MessageBody content AFTER Transformation: " + (String)exchange.getIn().getBody());
        }
    }
}