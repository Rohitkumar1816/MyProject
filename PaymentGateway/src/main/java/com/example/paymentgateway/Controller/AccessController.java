package com.example.paymentgateway.Controller;

import com.example.paymentgateway.Entity.Course;
import com.example.paymentgateway.Service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/access")
@CrossOrigin("*")
public class AccessController {

    @Autowired
    private AccessService accessService;

    @GetMapping("/courses")
    public List<Course> getUserCourses(@RequestParam String email) {
        return accessService.getUserCourses(email);
    }
}