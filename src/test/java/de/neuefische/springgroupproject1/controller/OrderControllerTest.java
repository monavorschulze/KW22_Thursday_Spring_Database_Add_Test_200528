package de.neuefische.springgroupproject1.controller;

import de.neuefische.springgroupproject1.db.OrderDB;
import de.neuefische.springgroupproject1.model.Order;
import de.neuefische.springgroupproject1.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.rsocket.context.LocalRSocketServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderControllerTest {

    @LocalRSocketServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private OrderDB orderDB;

   /*
    @BeforeEach
    public void resetDatabase(){
        orderDB.clearDB();
    }*/

    @Test
    public void putOrdersShouldAddOrderDatabase(){
        //GIVEN
        ArrayList<String> productId = new ArrayList<>();
        HttpEntity<Order> requestEntity = new HttpEntity<>(new Order("1",productId));

        //WHEN##
        ResponseEntity<Order> postResponse = restTemplate.exchange("http//localhost" + port + "/orders", HttpMethod.PUT, requestEntity, Order.class);

        //THEN
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        assertEquals(new Order("1","Liste ?"), postResponse.getBody());
        assertTrue(orderDB.getOrderList().contains(new Order("1","Liste ?")));
    }

    @Test
    public void getOrdersShouldReturnAllOrders(){
        //GIVEN
        orderDB.add(new Order("1","Affe"));
        orderDB.add(new Order("7","Katze"));

        //WHEN
        ResponseEntity<Order[]> postResponse = restTemplate.postForEntity("http://localhost:" + port + "/orders", new Order("3","Affe"));
        HttpStatus statusCode = response.getStatusCode();
        Order[] products = response.getBody();

        //THEN
        assertEquals(HttpStatus.OK, statusCode);
        assertEquals(2,orders.length);
        assertEquals(new Product("3","Affe"), orders[0]);




}
}