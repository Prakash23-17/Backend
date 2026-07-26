package com.example.studentmanagement.security.service;

import com.example.studentmanagement.dto.DashboardResponse;
import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    @Autowired
    private StudentRepository studentRepository;


    public DashboardResponse getDashboardData() {

        // Total students
        long totalStudents = studentRepository.count();


        // Get all students
        List<Student> students = studentRepository.findAll();


        // Active students count
        long activeStudents = students.stream()
                .filter(student ->
                        "ACTIVE".equalsIgnoreCase(student.getStatus()))
                .count();


        // Inactive students count
        long inactiveStudents = students.stream()
                .filter(student ->
                        "INACTIVE".equalsIgnoreCase(student.getStatus()))
                .count();

        long maleStudents = students.stream()
                .filter(s -> "Male".equalsIgnoreCase(s.getGender()))
                .count();

        long femaleStudents = students.stream()
                .filter(s -> "Female".equalsIgnoreCase(s.getGender()))
                .count();


        // Course wise statistics
        Map<String, Long> courseStatistics = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getCourse,
                        Collectors.counting()
                ));


        // Recently added students (last 5)
        List<Student> recentStudents = students.stream()
                .sorted((s1, s2) ->
                        s2.getCreatedAt()
                                .compareTo(s1.getCreatedAt()))
                .limit(5)
                .collect(Collectors.toList());


        return new DashboardResponse(
                totalStudents,
                activeStudents,
                inactiveStudents,
                courseStatistics,
                recentStudents,
                maleStudents,
                femaleStudents
        );
    }
}