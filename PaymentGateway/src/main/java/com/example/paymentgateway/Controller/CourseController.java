package com.example.paymentgateway.Controller;

import com.example.paymentgateway.Entity.Course;
import com.example.paymentgateway.Entity.UserCourse;
import com.example.paymentgateway.Service.CourseService;
import com.example.paymentgateway.Service.UserCourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CourseController {

    private final CourseService courseService;
    private final UserCourseService userCourseService;

    public CourseController(CourseService courseService, UserCourseService userCourseService) {
        this.courseService = courseService;
        this.userCourseService = userCourseService;
    }

    // login se pehle available courses
    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courseService.getAllCourses();
    }

    // course purchase
    @PostMapping("/purchase")
    public UserCourse purchaseCourse(@RequestParam Long userId, @RequestParam Long courseId) {
        // yaha payment integration ke baad call hoga
        return userCourseService.purchaseCourse(userId, courseId);
    }
}