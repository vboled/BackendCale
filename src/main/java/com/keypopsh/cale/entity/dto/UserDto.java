package com.keypopsh.cale.entity.dto;

import com.keypopsh.cale.entity.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
public class UserDto {
    private int id;
    private String userName;
    private String email;
    private String password;
    private Role role;
}
