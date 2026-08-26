package com.mahmoud.quickserve.service;

import com.mahmoud.quickserve.DTO.CustomerRegisterRequest;
import com.mahmoud.quickserve.mapper.UserMapper;
import com.mahmoud.quickserve.model.User;
import com.mahmoud.quickserve.model.enums.Role;
import com.mahmoud.quickserve.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final  UserMapper mapper;

    public UserService(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           UserMapper mapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
    }

    public User registerCustomer(CustomerRegisterRequest customerRegisterRequest) {

        if (userRepository.findByEmail(customerRegisterRequest.getEmail()).isPresent()) {
            throw new IllegalArgumentException("email already exists");
        }

        User user = mapper.toEntity(customerRegisterRequest);

        user.setPassword(
                passwordEncoder.encode(customerRegisterRequest.getPassword())
        );

        user.setRole(Role.CUSTOMER);

        return userRepository.save(user);
    }

    public Optional <User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(User user,Long id) {
      User  userOld =  userRepository.findById(id).orElse(null);
      if (userOld == null) {
          return null;
      }

        if (user.getUserName() != null) {
            userOld.setUserName(user.getUserName());
        }
        if (user.getPhone() != null) {
            userOld.setPhone(user.getPhone());
        }
        return   userRepository.save(userOld);


    }
    public User suspendUser(Long id) {
        User userOld = userRepository.findById(id).orElse(null);
        if (userOld == null) {
            return null;
        }
        userOld.setEnabled(false);
        return userRepository.save(userOld);
    }


    public Boolean deleteUser(Long id) {
        Boolean exists = userRepository.existsById(id);
        if (exists) {
            userRepository.deleteById(id);

        }
        return exists;

    }

}
