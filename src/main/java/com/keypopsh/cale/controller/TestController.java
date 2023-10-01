package com.keypopsh.cale.controller;

import com.keypopsh.cale.config.ApplicationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    private final ApplicationConfiguration.Security security;

    @Autowired
    public TestController(ApplicationConfiguration configuration) {
        this.security = configuration.getSecurity();
    }

    @GetMapping("/")
    public ResponseEntity<?> read() {
        security.jwt();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
