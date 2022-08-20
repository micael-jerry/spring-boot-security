package com.example.helloworldapi;

import com.example.helloworldapi.model.MyUser;
import com.example.helloworldapi.repository.MyUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@AllArgsConstructor
public class HelloWorldApiApplication {
    private MyUserRepository myUserRepository;

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApiApplication.class, args);
    }


    @PostConstruct
    public void addAdmin() {
        myUserRepository.save(new MyUser(1, "admin", "$2a$10$1czBVmTIBi4WXK5aP9wkbe2A7NwmDnxT4tl03sAe3ex4i98Mj5mS2", "admin"));
    }
}
