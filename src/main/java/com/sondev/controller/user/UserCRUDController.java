package com.sondev.controller.user;

import com.sondev.entity.user.UserEntity;
import com.sondev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserCRUDController {

    @Autowired
    UserService userService;

    //
    @PostMapping("/add")
    public UserEntity addUser(@RequestBody UserEntity userEntity){
        return userService.createUser(userEntity);
    }

    @GetMapping("/search")
    public UserEntity search(@RequestParam String userName, @RequestParam String useEmail){
        return userService.findByUserNameUserEmail(userName, useEmail);
    }
}
