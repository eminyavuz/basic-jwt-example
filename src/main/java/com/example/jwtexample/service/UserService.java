package com.example.jwtexample.service;

import com.example.jwtexample.model.User;
import com.example.jwtexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepository repo;
    private BCryptPasswordEncoder encoder= new BCryptPasswordEncoder(12);
    @Transactional
    public User register(User user)
    {
     user.setPassword(encoder.encode(user.getPassword()));
    return repo.save(user);
    }
}
