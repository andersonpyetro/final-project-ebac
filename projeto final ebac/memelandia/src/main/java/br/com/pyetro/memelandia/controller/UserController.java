package br.com.pyetro.memelandia.controller;

import br.com.pyetro.memelandia.dto.NewUserDTO;
import br.com.pyetro.memelandia.services.NewUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final NewUserService userService;

    @Autowired
    public UserController(NewUserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public NewUserDTO createNewUser(@RequestBody NewUserDTO userDTO) {
        return userService.createNewUser(userDTO);
    }

    @GetMapping
    public Iterable<NewUserDTO> findAll() {
        return userService.findAll();
    }
}
