package com.currencyexhange.currencyexchange.controller.user;

import com.currencyexhange.currencyexchange.model.user.User;
import com.currencyexhange.currencyexchange.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    UserService userService;

    @PostMapping("/add-user")
    public User addUser(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userService.addUser(user);
    }

    @GetMapping("/get-user-byemail/{email}")
    public User getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }

}
