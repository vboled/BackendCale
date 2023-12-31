package com.keypopsh.cale.service.impl;

import com.keypopsh.cale.entity.User;
import com.keypopsh.cale.repository.UserRepository;
import com.keypopsh.cale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    @Autowired
    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User createUser(User user) {
        return userRepository.saveAndFlush(user);
    }
}
