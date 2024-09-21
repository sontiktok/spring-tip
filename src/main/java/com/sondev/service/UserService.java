package com.sondev.service;

import com.sondev.entity.user.UserEntity;
import org.springframework.stereotype.Service;


@Service
public interface UserService {
    UserEntity createUser(UserEntity user);

    UserEntity findByUserNameUserEmail(String userName,String userEmail);
}
