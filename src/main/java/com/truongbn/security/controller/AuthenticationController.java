package com.truongbn.security.controller;

import com.truongbn.security.dao.Version;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.truongbn.security.dao.request.SignUpRequest;
import com.truongbn.security.dao.request.SigninRequest;
import com.truongbn.security.dao.response.JwtAuthenticationResponse;
import com.truongbn.security.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private static final String template = "Backend Version: ";
    private final AuthenticationService authenticationService;
    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
    @GetMapping("/version")
    public Version version(String versionDate, String versionContent) {
        return new Version();
    }

}
