package com.example.login.and.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/getUser")
    private List<LoginDto> getUser() { return LoginService.getUser(); }
    @PostMapping("/registerUser")
    private LoginDto saveUser(@RequestBody LoginDto loginDto){
        LoginService.saveUser(loginDto);
        return loginDto;
    }
}
