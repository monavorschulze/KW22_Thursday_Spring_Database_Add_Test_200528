package de.neuefische.springgroupproject1.controller;


import de.neuefische.springgroupproject1.model.Order;
import de.neuefische.springgroupproject1.model.Product;
import de.neuefische.springgroupproject1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {

private final OrderService orderService;

@Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getOrderList (){
        return orderService.getOrderList();
    }

    @PutMapping
    public Order addOrder(@RequestBody Order order){
        orderService.addOrder(order);
    return order;
    }

    @GetMapping("{id}")
    public Order getOrderID(@PathVariable String id) {
        return orderService.getOrderByID(id);
    }




}
