package com.devsuatt.todoApp.service;

import com.devsuatt.todoApp.exception.UserNotFoundException;
import com.devsuatt.todoApp.model.User;
import com.devsuatt.todoApp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    protected User findCustomerById(String id) {
        return userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("User could not find by id: " + id));
    }

}
