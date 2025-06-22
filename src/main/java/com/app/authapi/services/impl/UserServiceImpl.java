package com.app.authapi.services.impl;

import com.app.authapi.dtos.UserDto;
import com.app.authapi.enums.Role;
import com.app.authapi.mappers.IUserMapper;
import com.app.authapi.models.entities.User;
import com.app.authapi.repositories.IUserRepository;
import com.app.authapi.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    private final IUserMapper userMapper;

    public UserServiceImpl(IUserRepository userRepository, BCryptPasswordEncoder passwordEncoder, IUserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto registerUser(UserDto userDto) {

        User newUser = userMapper.toEntity(userDto);
        String encryptedPassword = passwordEncoder.encode(userDto.password());
        newUser.setPassword(encryptedPassword);
        if (userDto.role() == null) {
            newUser.setRoles(new HashSet<>(Set.of(Role.USER)));
        }else {
            newUser.setRoles(new HashSet<>(Set.of(userDto.role())));
        }

        userRepository.save(newUser);
        return userMapper.toDto(newUser);
    }
}
