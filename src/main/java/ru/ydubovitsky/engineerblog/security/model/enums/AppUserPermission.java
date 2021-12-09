package ru.ydubovitsky.engineerblog.security.model.enums;

public enum AppUserPermission {

    USER_PROFILE_READ("user_profile:read"),
    USER_PROFILE_WRITE("user_profile:write");

    public final String permission;

    AppUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
