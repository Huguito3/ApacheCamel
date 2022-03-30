package br.com.impacta.camel.springboot.springapache;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerBean {

    public void printClass(Exchange exchange) {
        List<Customer> customerList = (List<Customer>)exchange.getIn().getBody(List.class);
        customerList.stream().forEach(customer ->
                System.out.println(
                    " Customer ID: " + customer.getCustomerId() +
                    " Customer First Name: " + customer.getFirstName() +
                    " Customer Last Name: " + customer.getLastName()
                )
        );
    }
}