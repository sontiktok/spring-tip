package com.sondev.repository;

import com.sondev.entity.user.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>, JpaSpecificationExecutor<UserEntity> {

    //use pageable
    Page<UserEntity> findByUserName(String userName, Pageable pageable);

    Page<UserEntity> findByUserNameContaining(String userName, Pageable pageable);
    UserEntity findByUserNameAndUserEmail(String userName, String userEmail);
    //
//    UserEntity findByUserName(String userName);
    //
    /**
     * WHERE userName like %?
     * */
    List<UserEntity> findByUserNameStartingWith(String userEmail);


    /**
     * WHERE userName like ?%
     * */
    List<UserEntity> findByUserNameEndingWith(String userEmail);


    /**
     * WHERE id < 1
     * */
    List<UserEntity> findByIdLessThan(Long id);

    //RAW - JPQL
    // extends: JpaSpecificationExecutor
    @Query("SELECT u FROM UserEntity u WHERE u.id = (SELECT MAX (p.id) FROM UserEntity p)")
    UserEntity findMaxIdUser();

    @Query("SELECT u FROM UserEntity u WHERE u.userName = ?1 and u.userEmail = ?2")
    List<UserEntity> getUserEntitiesBy(String userName,String userEmail);

    @Query("SELECT u FROM UserEntity u WHERE u.userName = :userName and u.userEmail = :userEmail")
    List<UserEntity> getUserEntitiesByTwo(@Param("userName") String userName,@Param("userEmail") String userEmail);

    /**
     * UPDATE, DELETE
     * */

    @Modifying
    @Query("UPDATE UserEntity u SET u.userEmail = :userName")
    @Transactional
    int updateUserName(@Param("userName") String userName);

    //NATIVE query
    /**
     * get count user use native query
     * */
    @Query(value = "SELECT count(id) FROM java_user_001", nativeQuery = true)
    long getTotalUser();
}
