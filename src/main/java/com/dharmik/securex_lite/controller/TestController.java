package com.dharmik.securex_lite.controller;

import com.dharmik.securex_lite.annotations.CurrentUser;
import com.dharmik.securex_lite.annotations.Secure;
import com.dharmik.securex_lite.jwt.JwtUtil;
import com.dharmik.securex_lite.model.UserContext;
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
    @GetMapping("/profile")
    public String profile(
            @CurrentUser UserContext user
    ) {

        return "Hello "
                + user.getUsername()
                + " Role: "
                + user.getRole();
    }
}