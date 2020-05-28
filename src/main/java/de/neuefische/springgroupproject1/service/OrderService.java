package de.neuefische.springgroupproject1.service;

import de.neuefische.springgroupproject1.db.OrderDB;
import de.neuefische.springgroupproject1.model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class OrderService {

    private final OrderDB orderDB;


    public OrderService(OrderDB orderDB) {
        this.orderDB = orderDB;
    }

    public List<Order> getOrderList(){
        return orderDB.getOrderList();
    }

    public void addOrder(Order order) {
        orderDB.addOrders(order);
    }

    public Order getOrderByID(String id) {
        for (Order order : orderDB.getOrderList()) {
            if (order.getId().equals(id)) {
                return order;
            }
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order does not exist!");
    }
}