package com.gomeschristopher.order.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gomeschristopher.order.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
