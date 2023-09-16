package com.micro.user.service;

import com.micro.user.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userId);
}
