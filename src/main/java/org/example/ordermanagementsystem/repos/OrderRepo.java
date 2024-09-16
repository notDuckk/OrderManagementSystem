package org.example.ordermanagementsystem.repos;

import org.example.ordermanagementsystem.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {
}
