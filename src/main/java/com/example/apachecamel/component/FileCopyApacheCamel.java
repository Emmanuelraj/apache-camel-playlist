package com.example.apachecamel.component;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class FileCopyApacheCamel
{


    @Bean
    public void  copyFile()throws Exception
    {
        //init camelContext
        CamelContext context = new DefaultCamelContext();

        //add routes
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                 from("file:input_folder?noop=true")
                         .to("file:output_folder");
            }
        });

        while(true)
        {
            //start camelContext
            context.start();
        }
    }
}
