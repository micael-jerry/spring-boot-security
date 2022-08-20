package com.example.helloworldapi.controller;

import com.example.helloworldapi.model.MyUser;
import com.example.helloworldapi.repository.MyUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HelloWorldController {
    private MyUserRepository myUserRepository;

    @GetMapping("/hello")
    public String helloWorld() {
        return "hello world";
    }
    @GetMapping("/bonjour")
    public String bonjour() {
        return "bonjour tout le monde";
    }

    @PostMapping("/")
    public MyUser createAdmin(
            @RequestBody MyUser myUser
    ) {
        return myUserRepository.save(myUser);
    }
}
