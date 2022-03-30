package br.com.impacta.camel.quarkus;


import org.apache.camel.builder.RouteBuilder;

public class CBRRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:/tmp/input-quarkus/pedidos")
        .choice()
            .when(xpath("/Order/Country='USA'"))
              .log("Pedido USA Found")
              .log("FileName: ${in.header.CamelFileName} Content: ${body}")
              .to("rabbitmq://localhost:5672/spring-orders-us.exchange?queue=spring-orders-us")
            .when(xpath("/Order/Country='UK'"))
              .log("Pedido UK Found")
              .log("FileName: ${in.header.CamelFileName} Content: ${body}")
              .to("rabbitmq://localhost:5672/spring-orders-uk.exchange?queue=spring-orders-uk")
            .otherwise()
              .log("Pedido Default")
              .log("FileName: ${in.header.CamelFileName} Content: ${body}")
              .filter().xpath("/Order/Amount>10000")
              .log("FileName: ${in.header.CamelFileName} Content: ${body} will be Dispatched to RabbitMQ")
              .to("rabbitmq://localhost:5672/spring-orders.exchange?queue=spring-orders")
        .end();
    }
}