package com.micro.user.service.service;

import com.micro.user.service.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userId);
}
