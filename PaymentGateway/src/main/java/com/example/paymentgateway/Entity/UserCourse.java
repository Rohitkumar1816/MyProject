package com.example.paymentgateway.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class UserCourse {
    @Id
    @GeneratedValue
    private Long id;

    private Long userId;
    private Long courseId;
    private LocalDateTime purchaseDate;

    public UserCourse() {
    }

    public UserCourse(Long id, Long userId, Long courseId, LocalDateTime purchaseDate) {
        this.id = id;
        this.userId = userId;
        this.courseId = courseId;
        this.purchaseDate = purchaseDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}