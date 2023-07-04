package com.example.login.and.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class LoginService {
    @Autowired
    static
    LoginRepository loginRepository;
    public static void saveUser(LoginDto loginDto) {
        loginRepository.save(loginDto);
    }
    public static List<LoginDto> getUser() {
        return loginRepository.findAll();
    }

    public static ResponseEntity<Object> deleteByUserId(int id) {
        try {
            //check if employee exist in database
            Optional<LoginDto> stock = loginRepository.findById(id);
            if (stock != null) {
                loginRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static ResponseEntity<Object> updateUser(int id, LoginDto loginDto) {
        Optional<LoginDto> userObj = loginRepository.findById(id);
        LoginDto newLoginDto = userObj.get();
        if (userObj != null) {
            newLoginDto.setUserName(loginDto.getUserName());
            newLoginDto.setPassword(loginDto.getPassword());
            newLoginDto.setFirstName(loginDto.getFirstName());
            newLoginDto.setLastName(loginDto.getLastName());
            return new ResponseEntity<>(loginRepository.save(newLoginDto), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    }

