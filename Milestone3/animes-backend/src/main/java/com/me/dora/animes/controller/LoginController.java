package com.me.dora.animes.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
@RequestMapping("auth/login")
@RestController
public class LoginController {

    @GetMapping
    void login(Principal principal) {
    }
}

