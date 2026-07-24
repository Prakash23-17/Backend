package com.example.studentmanagement.dto;

import com.example.studentmanagement.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardResponse {

    // Total students count
    private long totalStudents;

    // Active students count
    private long activeStudents;

    // Inactive students count
    private long inactiveStudents;

    // Course wise statistics
    // Example: Java -> 20, React -> 15
    private Map<String, Long> courseStatistics;

    // Recently added students
    private List<Student> recentStudents;

}