package com.jlucas.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jlucas.users.entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

}
