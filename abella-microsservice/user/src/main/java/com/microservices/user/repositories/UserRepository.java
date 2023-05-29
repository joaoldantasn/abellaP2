package com.microservices.user.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.user.entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

}
