package com.gomeschristopher.order.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gomeschristopher.order.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
