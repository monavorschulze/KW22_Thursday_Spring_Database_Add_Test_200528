package de.neuefische.springgroupproject1.db;

import de.neuefische.springgroupproject1.model.Order;
import de.neuefische.springgroupproject1.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDB {

    private final List<Order> orderList = new ArrayList<>(List.of(

            new Order("1",List.of( new Product("3","Affe"))),
            new Order("2",List.of( new Product("7","Katze")))

    ));

    public void addOrders(Order order) {
        this.orderList.add(order);
    }

    public List<Order> getOrderList(){
        return orderList;
    }

}
