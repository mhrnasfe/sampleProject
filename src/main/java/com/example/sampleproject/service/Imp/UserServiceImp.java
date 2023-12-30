package com.example.sampleproject.service.Imp;

import com.example.sampleproject.exception.Exception;
import com.example.sampleproject.model.Application;
import com.example.sampleproject.model.User;
import com.example.sampleproject.repository.ApplicationRepository;
import com.example.sampleproject.repository.UserRepository;
import com.example.sampleproject.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final ApplicationRepository applicationRepository;
//    private final PasswordEncoder passwordEncoder;

    public User AddUser(User user) {
        User user1 = new User();
        user1.setPassword(user.getPassword());
        user1.setUsername(user.getUsername());
        user1.setEmail(user.getEmail());
        return userRepository.save(user1);
    }

    @Override
    public User registerUser(User user) {
        Optional<User> user1 = userRepository.findByEmail(user.getEmail());
        if (user1.isPresent()) {
            User savedUser = new User();
            savedUser.setUsername(user.getUsername());
            savedUser.setPassword(user.getPassword());
            return userRepository.save(savedUser);
        }
        throw new Exception.NotFoundException("registration failed");
    }

    @Override
    public User login(String username, String password) {
        Optional<User> user1 = userRepository.findByUsername(username);
        Optional<User> user2 = userRepository.findByPassword(password);
        if (user1.isEmpty() && user2.isEmpty()) {
            User user = new User();
            user.setUsername(user.getUsername());
            user.setPassword(user.getPassword());
            return userRepository.save(user);
        } else {
            throw new Exception.NotFoundException("login failed");
        }

    }

    @Override
    public Application createApplication(Long userId, String applicationName) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Application application = new Application();
        application.setApplicationName(applicationName);
        application.setUser(user);
        application.setId(UUID.randomUUID());

        applicationRepository.save(application);

        return application;
    }
}
//    private final DtoMapper mapper;
//
//    @Override
//    public User AddUser(User user) {
//        Optional<User> user1 = userRepository.findById(user.getId());
//        user1.ifPresent(user2 -> {
//            throw new UserAlreadyExists("User already exists");
//        });
//
//        User user2 = new User();
//        user2.setUsername(user.getUsername());
//        user2.setPassword(user.getPassword());
//        return userRepository.save(user2);
//    }
//
//
//    @Override
//    public User registerUser(UserRequestDto userRequestDto) {
//        Optional<User> user1 = userRepository.findByUsername(userRequestDto.getUsername());
//        user1.ifPresent(user -> {
//            throw new UserAlreadyExists("User already exists");
//        });
//        User saveUser = new User();
//        saveUser.setUsername(userRequestDto.getUsername());
//        saveUser.setPassword(userRequestDto.getPassword());
//        User savedUser = userRepository.save(saveUser);
//        return savedUser;
//    }
//
//    @Override
//    public Optional<User> login(String username, String password) {
//        Optional<User> user = userRepository.findByUsernameAndPassword(username, password);
//        return user;
//    }

