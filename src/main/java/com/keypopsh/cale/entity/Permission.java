package com.keypopsh.cale.entity;

import lombok.Getter;

@Getter
public enum Permission {
    USER_PERMISSION("user:perm"),
    OWNER_PERMISSION("owner:perm"),
    ADMIN_PERMISSION("admin:perm");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

}
