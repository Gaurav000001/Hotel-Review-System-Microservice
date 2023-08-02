package com.micro.user.service.repository;

import com.micro.user.service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    public Optional<User> findByEmail(String email);

    public Optional<User> findByPhone(String phone);
}
