package com.sondev.service.impl;

import com.sondev.entity.user.UserEntity;
import com.sondev.repository.UserRepository;
import com.sondev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;


    @Override
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntity findByUserNameUserEmail(String userName, String userEmail) {
        return userRepository.findByUserNameAndUserEmail(userName,userEmail);
    }

}
