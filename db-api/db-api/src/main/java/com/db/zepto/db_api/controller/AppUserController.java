package com.db.zepto.db_api.controller;

import com.db.zepto.db_api.model.AppUser;
import com.db.zepto.db_api.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db")
public class AppUserController {
    private AppUserRepository appUserRepository;
    @Autowired
    public AppUserController(AppUserRepository appUserRepository) {
        this.appUserRepository=appUserRepository;
    }

    @RequestMapping("/{userId}")
    public AppUser getUserById(@PathVariable UUID userId){
        return appUserRepository.findById(userId).orElse(null);
    }

    @GetMapping("/email/{userEmail}")
    public ResponseEntity getUserEmail(@PathVariable String userEmail){
        AppUser user=appUserRepository.findByEmail(userEmail);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    public AppUser saveUser(@RequestBody AppUser user){
        appUserRepository.save(user);
        return user;
    }
    //here why we don't need userId, how to update particular user
    @PutMapping("/update")
    public AppUser updateUser(@RequestBody AppUser user){
        appUserRepository.save(user);
        return user;
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable UUID userId){
        appUserRepository.deleteById(userId);
    }


}
