package com.example.studentmanagement.controller;

import com.example.studentmanagement.dto.DashboardResponse;
import com.example.studentmanagement.security.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin("*")
public class DashboardController {


    @Autowired
    private DashboardService dashboardService;


    // Get Dashboard Data
    @GetMapping
    public ResponseEntity<DashboardResponse> getDashboard() {

        return ResponseEntity.ok(
                dashboardService.getDashboardData()
        );
    }

}