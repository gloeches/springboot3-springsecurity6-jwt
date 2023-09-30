package com.truongbn.security.controller;

import com.truongbn.security.dao.Version;
import com.truongbn.security.dao.request.Enterprise;
import com.truongbn.security.dao.request.Keypass;
import com.truongbn.security.service.impl.EnterpriseService;
import com.truongbn.security.repository.EnterpriseRepository;
import com.truongbn.security.dao.request.SigninRequest;
import com.truongbn.security.entities.Role;
import com.truongbn.security.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthorizationController {
    @Autowired
    EnterpriseRepository enterpriseRepository;
    @Autowired
    private EnterpriseService enterpriseService;
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
/*    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Here is your resource");
    } */
/*    public Version version(String versionDate, String versionContent) {
        return new Version();
    } */
    @GetMapping("/resource")
    public SigninRequest user (){
        SigninRequest myUser= new SigninRequest("a@gmail.com","1234");
        myUser.setEmail("a.gmail.com");
        return myUser;
    }
    @GetMapping("/enterprises")
    public ResponseEntity<List<Enterprise>> getAllEnterprises(@RequestParam(required=false)  String name){
        return enterpriseService.getAllEnterprises(name);
    }
    @GetMapping("/enterprises/{enterpriseId}/keypass")
    public ResponseEntity<List<Keypass>> getAllkeypassByEnterpriseID(@PathVariable(value="enterpriseId") long enterpriseId){
        return enterpriseService.getAllKeypassByEnterpriseId(enterpriseId);
    }
    @PostMapping("/enterprise")
    public ResponseEntity<Enterprise> createEnterprise(@RequestBody Enterprise enterprise){
        Enterprise _enterprise= enterpriseRepository.save (new Enterprise(enterprise.getName(),enterprise.getProjectLeader()));
        return new ResponseEntity<>(_enterprise, HttpStatus.CREATED);
    }

    @PostMapping("/enterprises/{enterpriseId}/keypass")
    public ResponseEntity<Keypass>  createKeypass(@PathVariable(value="enterpriseId") Long enterpriseId, @RequestBody Keypass keypassRequest){
        return enterpriseService.createKeypass(enterpriseId,keypassRequest);
    }
    @GetMapping("/resource2")
    public SigninRequest user2 (){
        SigninRequest myUser= new SigninRequest("a@gmail.com","1234");
        myUser.setEmail("b.gmail.com");
        return myUser;
    }
}
