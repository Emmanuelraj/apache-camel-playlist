package com.example.springapachecamel.component;


import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This Component class provides
 *
 */
@Component
public class MyRoute  extends RouteBuilder
{



    @Override
    public void configure() throws Exception
    {


        System.out.println("configure method");
        from("file:input_folder?noop=true")
         .to("file:output_folder");
    }




}
