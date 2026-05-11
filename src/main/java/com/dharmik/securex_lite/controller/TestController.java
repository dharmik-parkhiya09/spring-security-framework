package com.dharmik.securex_lite.controller;

import com.dharmik.securex_lite.annotations.Secure;
import com.dharmik.securex_lite.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final JwtUtil jwtUtil;

    @GetMapping("/token")
    public String token() {

        return jwtUtil.generateJwtToken(
                "dharmik",
                "ADMIN"
        );
    }

    @Secure(role = "ADMIN")
    @GetMapping("/admin")
    public String admin() {
        return "Welcome Admin";
    }

    @Secure(role = "USER")
    @GetMapping("/user")
    public String user() {
        return "Welcome User";
    }
}
