package com.example.studentmanagement.repository;

import com.example.studentmanagement.model.Student;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    // Search student by name
    List<Student> findByNameContainingIgnoreCase(String name);

    // Search student by email
    List<Student> findByEmailContainingIgnoreCase(String email);

    // Search student by mobile number
    List<Student> findByMobileContaining(String mobile);

    // Filter by course
    List<Student> findByCourse(String course);

    // Filter by status (ACTIVE / INACTIVE)
    List<Student> findByStatus(String status);

    // Pagination
    Page<Student> findAll(Pageable pageable);

}