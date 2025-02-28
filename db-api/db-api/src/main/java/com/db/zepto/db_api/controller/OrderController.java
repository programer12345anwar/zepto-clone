package com.db.zepto.db_api.controller;

import com.db.zepto.db_api.model.AppOrder;
import com.db.zepto.db_api.repository.AppUserRepository;
import com.db.zepto.db_api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/db/order")
public class OrderController {
    // Implement the API endpoints for managing app orders
    OrderRepository orderRepository;
    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository=orderRepository;
    }

    @PostMapping("/save")
    public AppOrder createOrder(@RequestBody AppOrder order){
         return orderRepository.save(order);
    }
}
