package com.backend.palmbooking.Controller;

import com.backend.palmbooking.Model.Category;
import com.backend.palmbooking.Model.User;
import com.backend.palmbooking.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUser() {
        return userService.getUser();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserByID(@PathVariable Long id) {
        return userService.getUserByID(id);
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping
    public ResponseEntity<Void> editUser(@RequestBody User user) {
        Optional<User> searchUser = userService.getUserByID(user.getId());

        if (searchUser.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        userService.editUser(user);
        return ResponseEntity.status(202).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserByID(@PathVariable Long id) {
        Optional<User> searchUser = userService.getUserByID(id);

        if (searchUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        userService.deleteUserByID(id);
        return ResponseEntity.status(204).build();
    }
}
