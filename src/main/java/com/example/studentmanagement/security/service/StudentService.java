package com.example.studentmanagement.security.service;

import com.example.studentmanagement.exception.ResourceNotFoundException;
import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student) {
        student.setCreatedAt(LocalDateTime.now());
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(String id) {
        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found with id: " + id));
    }

    public Student updateStudent(String id, Student updatedStudent) {
        Student existing = getStudentById(id);

        existing.setName(updatedStudent.getName());
        existing.setEmail(updatedStudent.getEmail());
        existing.setMobile(updatedStudent.getMobile());
        existing.setCourse(updatedStudent.getCourse());
        existing.setAge(updatedStudent.getAge());
        existing.setGender(updatedStudent.getGender());
        existing.setAddress(updatedStudent.getAddress());
        existing.setStatus(updatedStudent.getStatus());

        return studentRepository.save(existing);
    }

    public String deleteStudent(String id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
        return "Student deleted successfully with id: " + id;
    }

    public List<Student> searchByName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Student> searchByEmail(String email) {
        return studentRepository.findByEmailContainingIgnoreCase(email);
    }

    public List<Student> searchByMobile(String mobile) {
        return studentRepository.findByMobileContaining(mobile);
    }

    public List<Student> filterByCourse(String course) {
        return studentRepository.findByCourse(course);
    }

    public List<Student> filterByStatus(String status) {
        return studentRepository.findByStatus(status);
    }

    public List<Student> sortByName() {
        return studentRepository.findAll(
                Sort.by(Sort.Direction.ASC, "name")
        );
    }

    public List<Student> sortByAge() {
        return studentRepository.findAll(
                Sort.by(Sort.Direction.ASC, "age")
        );
    }

    public List<Student> sortByDate() {
        return studentRepository.findAll(
                Sort.by(Sort.Direction.DESC, "createdAt")
        );
    }

    public Page<Student> getStudentsWithPagination(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return studentRepository.findAll(pageable);
    }
}