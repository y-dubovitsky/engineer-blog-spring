package ru.ydubovitsky.engineerblog.security.model.enums;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum AppUserRole {
    USER(Set.of(AppUserPermission.USER_PROFILE_READ)),
    ADMIN(Set.of(
            AppUserPermission.USER_PROFILE_WRITE,
            AppUserPermission.USER_PROFILE_READ)
    );

    private final Set<AppUserPermission> permissions;

    AppUserRole(Set<AppUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<AppUserPermission> getPermissions() {
        return permissions;
    }

    public Set<GrantedAuthority> grantedAuthoritySet() {
        Set<GrantedAuthority> grantedAuthorities = this.permissions.stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return grantedAuthorities;
    }
}
