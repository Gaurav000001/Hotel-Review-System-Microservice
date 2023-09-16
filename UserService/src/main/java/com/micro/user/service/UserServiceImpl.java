package com.micro.user.service;

import com.micro.user.exception.UserException;
import com.micro.user.repository.UserRepository;
import com.micro.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        Optional<User> emailOpt = userRepository.findByEmail(user.getEmail());
        Optional<User> phoneOpt = userRepository.findByPhone(user.getPhone());

        if(emailOpt.isPresent()) throw new UserException("User already present with Email: " + user.getEmail());
        if(phoneOpt.isPresent()) throw new UserException("User already present with Phone: " + user.getPhone());

        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = userRepository.findAll();

        if(users.isEmpty()) throw new UserException("Users not found");

        return users;
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UserException("User not found with userId: " + userId));
    }
}
