package com.example.studentmanagement.repository;

import com.example.studentmanagement.model.User;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

    // Login ke time email se user find karne ke liye
    Optional<User> findByEmail(String email);

    // Check karne ke liye ki email already exist hai ya nahi
    boolean existsByEmail(String email);

}