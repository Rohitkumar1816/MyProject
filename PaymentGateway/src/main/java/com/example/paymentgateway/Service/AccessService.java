package com.example.paymentgateway.Service;

import com.example.paymentgateway.Entity.Course;
import com.example.paymentgateway.Entity.PaymentOrder;
import com.example.paymentgateway.Repo.CourseRepository;
import com.example.paymentgateway.Repo.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AccessService {

    @Autowired
    private PaymentRepo paymentRepo;
    @Autowired
    private CourseRepository courseRepo;

    public List<Course> getUserCourses(String email) {

        List<PaymentOrder> orders = paymentRepo.findAllByEmailAndStatus(email, "SUCCESS");

        if (orders.isEmpty()) {
            return new ArrayList<>();
        }

        List<Long> courseIds = orders.stream()
                .map(PaymentOrder::getCourseId)
                .distinct()
                .toList();

        return courseRepo.findAllById(courseIds);
    }
}