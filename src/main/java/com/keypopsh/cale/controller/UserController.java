package com.keypopsh.cale.controller;


import com.keypopsh.cale.entity.dto.UserDto;
import com.keypopsh.cale.entity.User;
import com.keypopsh.cale.entity.mapper.UserMapper;
import com.keypopsh.cale.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/welcome")
    public ResponseEntity<String> welcome() {
        log.info("HERE!!");
        return ResponseEntity.ok("Welcome this endpoint is not secure");
    }

    @PostMapping("/")
    public ResponseEntity<User> addNewUser(@RequestBody UserDto user) {
        User userForCreation = UserMapper.mapToEntity(user);
        User userCreated = userService.createUser(userForCreation);
        return ResponseEntity.ok(userCreated);
    }

    @GetMapping("/user/test")
//    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String userProfile() {
        return "Welcome to User Profile";
    }

    @GetMapping("/admin/test")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }
}
  
