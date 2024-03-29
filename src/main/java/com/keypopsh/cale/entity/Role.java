package com.keypopsh.cale.entity;

import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
public enum Role {
    USER(Set.of(Permission.USER_PERMISSION)),
    ADMIN(Set.of(Permission.ADMIN_PERMISSION, Permission.USER_PERMISSION)),
    OWNER(Set.of(Permission.OWNER_PERMISSION, Permission.USER_PERMISSION));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}

