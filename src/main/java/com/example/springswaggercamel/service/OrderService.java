package com.example.springswaggercamel.service;


import com.example.springswaggercamel.dto.Order;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService
{

    private List<Order> list = new ArrayList<Order>();


    /**
     * This Method get called before main method like commandLineRunner
     */
    @PostConstruct
    public void initDB() {
        list.add(new Order(67, "Mobile", 5000));
        list.add(new Order(89, "Book", 400));
        list.add(new Order(45, "AC", 15000));
        list.add(new Order(67, "Shoes", 4000));
    }


   // addOrder
    public Order addOrder(Order order)
    {
        list.add(order);
        return order;
    }



    //getOrders
    public List<Order> getOrders()
    {
        return list;
    }






}
