package com.grh.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grh.model.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
