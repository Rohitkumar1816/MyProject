package com.example.paymentgateway.Service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class OtpService {

    private Map<String, String> otpStorage = new HashMap<>(); // email -> otp

    public String generateOtp(String email) {
        String otp = String.format("%06d", new Random().nextInt(999999));
        otpStorage.put(email, otp);
        System.out.println("Generated OTP for " + email + ": " + otp); // For testing, print OTP
        return otp;
    }

    public boolean validateOtp(String email, String otp) {
        if (!otpStorage.containsKey(email)) return false;
        boolean valid = otpStorage.get(email).equals(otp);
        if (valid) otpStorage.remove(email); // OTP one-time use
        return valid;
    }
}