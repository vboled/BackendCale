package com.keypopsh.cale.controller;


import com.keypopsh.cale.entity.User;
import com.keypopsh.cale.entity.dto.AuthDto;
import com.keypopsh.cale.entity.dto.UserDto;
import com.keypopsh.cale.service.JwtService;
import com.keypopsh.cale.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
@Slf4j
public class UserController {

    private final UserService userService;

    private final ModelMapper modelMapper;
    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper,
                          JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok("Welcome this endpoint is not secure");
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('admin:perm')")
    public ResponseEntity<String> admin() {
        return ResponseEntity.ok("Hello, Admin!");
    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('user:perm')")
    public ResponseEntity<String> user() {
        return ResponseEntity.ok("Hello, User!");
    }

    @PostMapping("/")
    public ResponseEntity<User> addNewUser(@RequestBody UserDto userDto) {
        User userForCreation = modelMapper.map(userDto, User.class);
        User userCreated = userService.createUser(userForCreation);
        return ResponseEntity.ok(userCreated);
    }

    @PostMapping("/token")
    public ResponseEntity<String> authenticateAndGetToken(@RequestBody AuthDto authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return ResponseEntity.ok(jwtService.generateToken(authRequest.getUsername()));
        } else {
            throw new UsernameNotFoundException("Invalid user request !");
        }
    }
}
  
