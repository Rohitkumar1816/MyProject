package com.example.paymentgateway.Controller;

import com.example.paymentgateway.Service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/otp")
@CrossOrigin("*")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @PostMapping("/send")
    public String sendOtp(@RequestParam String email) {
        String otp = otpService.generateOtp(email);

        // Email service se send karne ka code yaha add kar sakte ho
        System.out.println("OTP sent to " + email + ": " + otp);

        return "OTP sent to your email!";
    }

    @PostMapping("/verify")
    public String verifyOtp(@RequestParam String email, @RequestParam String otp) {
        boolean valid = otpService.validateOtp(email, otp);
        return valid ? "Login successful" : "Invalid OTP";
    }
}