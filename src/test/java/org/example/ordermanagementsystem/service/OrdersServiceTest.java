package org.example.ordermanagementsystem.service;

import org.example.ordermanagementsystem.models.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OrdersServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void testSaveOrder() {
        Order order = new Order();
        order.setDate(new Date());

        Order savedOrder = orderService.saveOrder(order);
        assertNotNull(savedOrder);
        assertEquals(order.getDate(), savedOrder.getDate());
    }

    @Test
    public void testFindOrderById() {
        Order order = new Order();
        order.setDate(new Date());
        Order savedOrder = orderService.saveOrder(order);

        Order foundOrder = orderService.findOrderById(savedOrder.getId());
        assertNotNull(foundOrder);
        assertEquals(savedOrder.getId(), foundOrder.getId());
    }

    @Test
    public void testDeleteOrderById() {
        Order order = new Order();
        order.setDate(new Date());
        Order savedOrder = orderService.saveOrder(order);

        orderService.deleteOrderById(savedOrder.getId());

        assertThrows(Exception.class, () -> {
            orderService.findOrderById(savedOrder.getId());
        });
    }
}
