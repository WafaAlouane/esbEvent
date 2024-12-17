package com.example.eventesb.controllers;

import com.example.eventesb.entities.User;
import com.example.eventesb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/showbyid/{id}")
    public User getUtilisateurById(@PathVariable Long id) {
        return userService.getuserById(id);
    }

    @PostMapping("/addUser")
    public User createUtilisateur(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/updateUser/{id}")
    public User updateUtilisateur(@PathVariable Long id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUtilisateur(@PathVariable Long id) {
        userService.deleteuser(id);
    }
}
