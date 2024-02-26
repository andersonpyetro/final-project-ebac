package br.com.pyetro.user.controller;

import br.com.pyetro.user.entities.User;
import br.com.pyetro.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping
    public Iterable<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    public Optional<User> findUserById(@PathVariable User userId){
        return userService.findUserById(userId);
    }

    @GetMapping("/random")
    public Optional<User> findRandomUser(){
        return userService.findRandomUser();
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable User userId, @RequestBody User user) {
        return userService.updateUser(userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable User userId) {
        userService.deleteUserById(userId);
    }
}