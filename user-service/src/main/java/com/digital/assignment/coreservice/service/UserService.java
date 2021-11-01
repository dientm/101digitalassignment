package com.digital.assignment.coreservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.assignment.coreservice.entity.Role;
import com.digital.assignment.coreservice.entity.User;
import com.digital.assignment.coreservice.repository.RoleRepository;
import com.digital.assignment.coreservice.repository.UserRepository;

import dto.UserDto;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public User save(UserDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());

        String role = dto.getRole();

        Role r = roleRepository.findByName(role)
            .orElseThrow(() -> new IllegalArgumentException("Role is not exist: " + role));
        user.getRoles().add(r);

        User entity = userRepository.save(user);
        return userRepository.findById(entity.getId()).orElse(null);
    }

    public User getById(long id) {
        return this.userRepository.findById(id).orElse(null);
    }
}
