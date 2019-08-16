package com.example.springswaggercamel.processor;

import com.example.springswaggercamel.dto.Order;
import com.example.springswaggercamel.service.OrderService;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;
@Configuration
public class OrderProcessor implements Processor {


    @Autowired
    private OrderService service;

    @Override
    public void process(Exchange exchange) throws Exception {
        service.addOrder(exchange.getIn().getBody(Order.class));
    }


}
