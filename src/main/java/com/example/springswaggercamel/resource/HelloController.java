package com.example.springswaggercamel.resource;

import com.example.springswaggercamel.dto.Order;
import com.example.springswaggercamel.processor.OrderProcessor;
import com.example.springswaggercamel.service.OrderService;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * for get
 *
 * For POST Mapping in apache camel you need processor proccess methods
 */
@Component
public class HelloController extends RouteBuilder
{

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderProcessor orderProcessor;

    @Override
    public void configure() throws Exception
    {


        log.info("configure method");
           //Enable Camel Servlet
        restConfiguration().component("servlet").port(3000).host("localhost").bindingMode(RestBindingMode.json);

         //specify the rest http method url and expected method
        rest().get("/hello-world").produces(MediaType.APPLICATION_JSON_VALUE).route().setBody(constant("GET MAPPING"));

        //specify the rest http method url and expected method for post
        rest().get("/getOrders").produces(MediaType.APPLICATION_JSON_VALUE).route().setBody(()->orderService.getOrders());

       //post routes you need to use processor en
        rest().post("/addOrders").consumes(MediaType.APPLICATION_JSON_VALUE).type(Order.class).outType(Order.class).route().process(orderProcessor).endRest();
    }




}
