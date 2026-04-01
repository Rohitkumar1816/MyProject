package com.example.paymentgateway.Controller;

import com.example.paymentgateway.Entity.User;
import com.example.paymentgateway.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        return authService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return authService.login(user.getEmail(), user.getPassword());
    }
    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestBody User user) {
        return authService.resetPassword(user.getEmail(), user.getPassword());
    }
}
