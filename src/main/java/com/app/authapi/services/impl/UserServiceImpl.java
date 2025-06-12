package com.app.authapi.services.impl;

import com.app.authapi.dtos.UserDto;
import com.app.authapi.enums.Role;
import com.app.authapi.mappers.IUserMapper;
import com.app.authapi.models.entities.User;
import com.app.authapi.repositories.IUserRepository;
import com.app.authapi.services.interfaces.IUserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final IUserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(IUserRepository userRepository, IUserMapper userMapper, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto registerUser(UserDto userDto) {

        User newUser = userMapper.toEntity(userDto);
        String encryptedPassword = passwordEncoder.encode(userDto.password());
        newUser.setPassword(encryptedPassword);
        if (newUser.getRoles().isEmpty()) {
            newUser.getRoles().add(Role.USER);
        }

        userRepository.save(newUser);
        return userMapper.toDto(newUser);
    }
}
