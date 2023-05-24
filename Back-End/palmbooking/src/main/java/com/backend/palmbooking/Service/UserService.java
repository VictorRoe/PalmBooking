package com.backend.palmbooking.Service;

import com.backend.palmbooking.Exception.GlobalException;
import com.backend.palmbooking.Model.User;
import com.backend.palmbooking.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public User getUserByID(Long id) throws GlobalException {
        Optional<User> searchUser = userRepository.findById(id);
        if (searchUser.isPresent()){
            return searchUser.get();
        } else {
            throw new GlobalException("ID NOT FOUND");
        }
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User editUser(User user) throws GlobalException {
        Optional<User> editUser = userRepository.findById(user.getId());
        if (editUser.isPresent()) {
            return userRepository.save(user);
        } else {
            throw new GlobalException("ID NOT FOUND");
        }

    }

    public void deleteUserByID(Long id) throws GlobalException {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new GlobalException("ID NOT FOUND");
        }
    }
}
