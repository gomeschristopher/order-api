package com.gomeschristopher.order.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gomeschristopher.order.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
