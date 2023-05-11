package com.backend.palmbooking.Service;

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

    public Optional<User> getUserByID(Long id) {
        return userRepository.findById(id);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User editUser(User user) {
        Optional<User> editUser = userRepository.findById(user.getId());

        if (editUser.isPresent()) {
            return userRepository.save(user);
        } else {
            System.out.println("No se encontro una id para editar");
        }
        return user;
    }

    public void deleteUserByID(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
        }
    }
}
