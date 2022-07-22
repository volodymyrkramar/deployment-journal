package com.dev.deploymentjournal.service;

import com.dev.deploymentjournal.domain.User;
import com.dev.deploymentjournal.exception.UserAlreadyExistsException;
import com.dev.deploymentjournal.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        // p and pc match
        //dont persist to db confirm password
        try {
            user.setConfirmedPassword("***");
            return userRepository.save(user);
        } catch (Exception e) {
            //should be unique
            throw new UserAlreadyExistsException("User " + user.getUsername() + " already exists");
        }

    }
}
