package com.wudi.redditclone.controller;

import com.wudi.redditclone.dto.RegisterDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/register")
    public void register (@RequestBody RegisterDTO registerDTO){

    }
}
