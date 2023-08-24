package com.nikkhat.UserService.service;

import com.nikkhat.UserService.entity.User;

import java.util.List;

public interface UserService {

    User saveUser (User user);

    List<User> getAllUser();

    User getUser(String userID);

    //delete & Update

}
