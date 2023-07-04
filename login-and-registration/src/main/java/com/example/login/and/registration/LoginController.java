package com.example.login.and.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @DeleteMapping("/user/{id}")
    private ResponseEntity<Object> deleteUser(@PathVariable("id") int id){
        return LoginService.deleteByUserId(id);
    }

    @PutMapping("/user/{id}")
    private ResponseEntity<Object> updateUser(@PathVariable int id, @RequestBody LoginDto loginDto){
        return LoginService.updateUser(id, loginDto);
    }


}
