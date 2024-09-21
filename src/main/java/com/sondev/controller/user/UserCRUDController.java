package com.sondev.controller.user;

import com.sondev.entity.user.UserEntity;
import com.sondev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @GetMapping("/getAll")
    public Page<UserEntity> getAll(@RequestParam int page,
                                   @RequestParam int size,
                                   @RequestParam(defaultValue = "id") String sort,
                                   @RequestParam(defaultValue = "desc") String direction){
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection, sort);
        Pageable pageable = PageRequest.of(page, size, sortBy);
        return userService.findAllUsers(pageable);
    }


    @GetMapping("/searchPage")
    public Page<UserEntity> searchPageUsername(
                                   @RequestParam String name,
                                   @RequestParam int page,
                                   @RequestParam int size,
                                   @RequestParam(defaultValue = "id") String sort,
                                   @RequestParam(defaultValue = "desc") String direction){
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection, sort);
        Pageable pageable = PageRequest.of(page, size, sortBy);
        return userService.findByUserName(name,pageable);
    }
}
