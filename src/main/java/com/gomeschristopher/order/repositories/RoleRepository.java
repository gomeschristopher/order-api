package com.gomeschristopher.order.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gomeschristopher.order.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
