package com.mahmoud.quickserve.service;

import com.mahmoud.quickserve.model.User;
import com.mahmoud.quickserve.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {

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
