package com.wudi.redditclone.controller;

import com.wudi.redditclone.dto.RegisterDTO;
import com.wudi.redditclone.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register (@RequestBody RegisterDTO registerDTO){
        authService.register(registerDTO);
        return new ResponseEntity<>("User Registration Success.", HttpStatus.OK);
    }

}
