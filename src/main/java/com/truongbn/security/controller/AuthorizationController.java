package com.truongbn.security.controller;

import com.truongbn.security.dao.Version;
import com.truongbn.security.dao.request.SigninRequest;
import com.truongbn.security.entities.Role;
import com.truongbn.security.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/resource")
@RequiredArgsConstructor
public class AuthorizationController {
    @GetMapping
/*    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Here is your resource");
    } */
/*    public Version version(String versionDate, String versionContent) {
        return new Version();
    } */
    public SigninRequest user (){
        SigninRequest myUser= new SigninRequest("a@gmail.com","1234");
        myUser.setEmail("a.gmail.com");
        return myUser;
    }
}
