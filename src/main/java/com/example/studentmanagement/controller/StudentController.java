package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.security.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin("*")
public class StudentController {


    @Autowired
    private StudentService studentService;


    // Add Student
    @PostMapping
    public ResponseEntity<Student> addStudent(
            @RequestBody Student student) {

        return ResponseEntity.ok(
                studentService.addStudent(student)
        );
    }


    // Get All Students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {

        return ResponseEntity.ok(
                studentService.getAllStudents()
        );
    }


    // Get Student By Id
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(
            @PathVariable String id) {

        return ResponseEntity.ok(
                studentService.getStudentById(id)
        );
    }


    // Update Student
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable String id,
            @RequestBody Student student) {

        return ResponseEntity.ok(
                studentService.updateStudent(id, student)
        );
    }


    // Delete Student
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(
            @PathVariable String id) {

        return ResponseEntity.ok(
                studentService.deleteStudent(id)
        );
    }


    // Search By Name
    @GetMapping("/search/name")
    public ResponseEntity<List<Student>> searchByName(
            @RequestParam String name) {

        return ResponseEntity.ok(
                studentService.searchByName(name)
        );
    }


    // Search By Email
    @GetMapping("/search/email")
    public ResponseEntity<List<Student>> searchByEmail(
            @RequestParam String email) {

        return ResponseEntity.ok(
                studentService.searchByEmail(email)
        );
    }


    // Search By Mobile
    @GetMapping("/search/mobile")
    public ResponseEntity<List<Student>> searchByMobile(
            @RequestParam String mobile) {

        return ResponseEntity.ok(
                studentService.searchByMobile(mobile)
        );
    }


    // Filter By Course
    @GetMapping("/filter/course")
    public ResponseEntity<List<Student>> filterByCourse(
            @RequestParam String course) {

        return ResponseEntity.ok(
                studentService.filterByCourse(course)
        );
    }


    // Filter By Status
    @GetMapping("/filter/status")
    public ResponseEntity<List<Student>> filterByStatus(
            @RequestParam String status) {

        return ResponseEntity.ok(
                studentService.filterByStatus(status)
        );
    }

    @GetMapping("/sort/name")
    public ResponseEntity<List<Student>> sortByName() {
        return  ResponseEntity.ok(studentService.sortByName());

    }

    @GetMapping("/sort/age")
    public ResponseEntity<List<Student>> sortByAge() {
        return  ResponseEntity.ok(studentService.sortByAge());

    }

    @GetMapping("sort/date")
    public ResponseEntity<List<Student>> sortByDate() {
        return ResponseEntity.ok(studentService.sortByDate());

    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<Student>> getStudentsWithPagination(@RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "5")int size){
        return ResponseEntity.ok(studentService.getStudentsWithPagination(page,size));
    }







}