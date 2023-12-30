package com.example.sampleproject.service;

import com.example.sampleproject.model.Application;
import com.example.sampleproject.model.User;

public interface UserService {

    User AddUser(User user);
    User registerUser(User user);

    User login(String username, String password);

    Application createApplication(Long userId, String applicationName);



}
