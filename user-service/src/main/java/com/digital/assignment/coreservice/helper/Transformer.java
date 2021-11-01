package com.digital.assignment.coreservice.helper;

import java.util.Optional;

import com.digital.assignment.coreservice.entity.User;

import dto.user.UserDto;

public final class Transformer {

    public static UserDto transform(User user) {
        return Optional.ofNullable(user)
            .map(map -> new UserDto()
                .setId(user.getId())
                .setUsername(user.getUsername())
                .setRole(user.getRoles().stream().findFirst().get().getName())
            ).get();
    }



}
