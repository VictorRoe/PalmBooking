package com.backend.palmbooking.Controller;

import com.backend.palmbooking.Exception.GlobalException;
import com.backend.palmbooking.Model.User;
import com.backend.palmbooking.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getProduct() {
        return userService.getUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserByID(@PathVariable Long id) throws GlobalException {
        User user = userService.getUserByID(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
    }

    @PostMapping
    public void addProduct(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping
    public ResponseEntity<User> editUser(@RequestBody User user) throws GlobalException {
        User searchUser = userService.getUserByID(user.getId());
        if (searchUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(userService.editUser(user));
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserByID(@PathVariable Long id) throws GlobalException {
        User searchUser = userService.getUserByID(id);
        if (searchUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        userService.deleteUserByID(id);
        return ResponseEntity.noContent().build();
    }
}
