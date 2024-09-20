package com.sondev.service;

import com.sondev.entity.user.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity createUser(UserEntity user);
    List<UserEntity> getAllUsers();
}
