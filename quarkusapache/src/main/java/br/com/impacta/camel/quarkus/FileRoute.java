package br.com.impacta.camel.quarkus;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.springframework.stereotype.Component;

@Component
public class FileRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        BindyCsvDataFormat csvDataFormat = new BindyCsvDataFormat(Customer.class);

        from("file:/tmp/input-quarkus")
                .log("FileName: ${in.header.CamelFileName} Content: ${body}")
                .split(body().tokenize("/n")).unmarshal(csvDataFormat)
                .log("Reading File Line >> ${body}")
                .convertBodyTo(Customer[].class)
                .bean(CustomerBean.class, "printClass");
    }
}