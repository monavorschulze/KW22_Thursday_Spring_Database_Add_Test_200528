package de.neuefische.springgroupproject1.controller;


import de.neuefische.springgroupproject1.model.Order;
import de.neuefische.springgroupproject1.model.Product;
import de.neuefische.springgroupproject1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service){
        this.service = service;
    }

    @GetMapping
    public List<Product> listProductList(@RequestParam(name="q", required = false) String query) {
        return service.getProductList(query);

    }
    /*@PostMapping
    public Order addOrder(@RequestBody Order order){
        orderService.addOrder(order);
        return order;
    }*/

}
