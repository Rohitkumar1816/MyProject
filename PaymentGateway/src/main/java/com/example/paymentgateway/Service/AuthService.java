package com.example.paymentgateway.Service;

import com.example.paymentgateway.Entity.User;
import com.example.paymentgateway.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepo;

    // 🔥 FIX 1: encoder define karo
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String register(User user) {

        if (userRepo.findByEmail(user.getEmail()) != null) {
            return "User already exists";
        }

        // 🔐 encrypt password
        user.setPassword(encoder.encode(user.getPassword()));

        userRepo.save(user);
        return "User registered successfully";
    }

    public String login(String email, String password) {

        User user = userRepo.findByEmail(email);

        if (user == null) {
            return "User not found";
        }

        // 🔥 FIX 2: BCrypt match use karo
        if (!encoder.matches(password, user.getPassword())) {
            return "Invalid password";
        }

        return "Login successful";
    }

    public String resetPassword(String email, String newPassword) {

        User user = userRepo.findByEmail(email);

        if (user == null) {
            return "User not found";
        }

        // 🔥 FIX 3: new password bhi encrypt karo
        user.setPassword(encoder.encode(newPassword));

        userRepo.save(user);

        return "Password updated successfully";
    }
}