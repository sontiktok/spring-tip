package com.sondev.service;

import com.sondev.entity.user.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public interface UserService {
    UserEntity createUser(UserEntity user);

    UserEntity findByUserNameUserEmail(String userName,String userEmail);

    //get all by limit offset
    Page<UserEntity> findAllUsers(Pageable pageable);
    //get search by limit offset
    Page<UserEntity> findByUserName(String userName,Pageable pageable);
}
