package org.example.services;


import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void loginUser(){
        System.out.println("User services is called for login");
        throw new RuntimeException("Failed to login");
    }
}
