package com.nikkhat.UserService.repository;

import com.nikkhat.UserService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

    //if u want  to implement any custom method or query
}
