package org.example.ordermanagementsystem.service;

import org.example.ordermanagementsystem.models.Order;
import org.example.ordermanagementsystem.repos.OrderRepo;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public Order saveOrder(Order order) {
        return orderRepo.save(order);
    }

    public Order findOrderById(int id) {
        return orderRepo.findById(id).get();
    }

    public void deleteOrderById(int id) {
        orderRepo.deleteById(id);
    }


}
