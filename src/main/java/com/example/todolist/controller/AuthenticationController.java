package com.example.todolist.controller;

import com.example.todolist.web.AuthenticationRequestDto;
import com.example.todolist.web.AuthenticationResponseDto;
import com.example.todolist.service.AuthenticationService;
import com.example.todolist.web.RegisterRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/api/auth/register")
    public ResponseEntity<AuthenticationResponseDto> register(@RequestBody RegisterRequestDto request){
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/api/auth/authenticate")
    public ResponseEntity<AuthenticationResponseDto> authenticationRequest(@RequestBody AuthenticationRequestDto request){
        return ResponseEntity.ok(service.authenticate(request));

    }
}
