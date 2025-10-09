package com.mthsgimenez.participe.mapper;

import com.mthsgimenez.participe.domain.user.User;
import com.mthsgimenez.participe.domain.user.UserResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserResponseDTO toUserResponseDTO(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getRole(),
                user.getCompany()
        );
    }

    public static List<UserResponseDTO> toUserResponseDTOList(List<User> users) {
        return users.stream()
                .map(user -> new UserResponseDTO(
                        user.getId(),
                        user.getName(),
                        user.getRole(),
                        user.getCompany()
                )).collect(Collectors.toList());
    }
}
