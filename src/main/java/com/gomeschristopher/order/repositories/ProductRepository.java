package com.gomeschristopher.order.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gomeschristopher.order.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
