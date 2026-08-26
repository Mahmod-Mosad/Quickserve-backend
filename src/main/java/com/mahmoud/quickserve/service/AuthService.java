package com.mahmoud.quickserve.service;

import com.mahmoud.quickserve.DTO.LoginRequest;
import com.mahmoud.quickserve.DTO.LoginResponse;
import com.mahmoud.quickserve.model.User;
import com.mahmoud.quickserve.repository.UserRepository;
import com.mahmoud.quickserve.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthService(AuthenticationManager authenticationManager,
                       UserRepository userRepository,
                       JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public LoginResponse login(LoginRequest request) {

        // 1. التحقق من الهوية (فاكرين الرحلة الكاملة اللي شرحناها قبل كده؟)
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        // 2. لو وصلنا هنا، يبقى الباسورد صح (لو غلط، السطر اللي فوق كان هيرمي Exception)
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 3. نولّد التوكن
        String token = jwtService.generateToken(user.getEmail());

        // 4. نرجع الرد
        LoginResponse response = new LoginResponse();
        response.setToken(token);
        response.setEmail(user.getEmail());
        response.setRole(user.getRole().name());

        return response;
    }
}