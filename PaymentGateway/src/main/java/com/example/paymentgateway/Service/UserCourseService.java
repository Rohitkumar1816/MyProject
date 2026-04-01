package com.example.paymentgateway.Service;

import com.example.paymentgateway.Entity.UserCourse;

import com.example.paymentgateway.Repo.UserCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserCourseService {
@Autowired
    private final UserCourseRepository userCourseRepository;

    public UserCourseService(UserCourseRepository userCourseRepository) {
        this.userCourseRepository = userCourseRepository;
    }

    public UserCourse purchaseCourse(Long userId, Long courseId) {
        UserCourse userCourse = new UserCourse();
        userCourse.setUserId(userId);
        userCourse.setCourseId(courseId);
        userCourse.setPurchaseDate(LocalDateTime.now());

        return userCourseRepository.save(userCourse);
    }
}