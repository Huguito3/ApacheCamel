package br.com.impacta.camel.quarkus;

import org.apache.camel.Exchange;

import java.util.List;

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
