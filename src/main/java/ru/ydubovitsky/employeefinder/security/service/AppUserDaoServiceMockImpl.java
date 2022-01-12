package ru.ydubovitsky.employeefinder.security.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import ru.ydubovitsky.employeefinder.security.model.AppUser;
import ru.ydubovitsky.employeefinder.security.model.enums.AppUserRole;

import java.util.List;

@Repository("mock")
public class AppUserDaoServiceMockImpl implements AppUserDaoService {

    private final PasswordEncoder passwordEncoder;

    public AppUserDaoServiceMockImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AppUser getAppUserByUsername(String username) {
        return getAppUserList()
                .stream()
                .filter(appUser -> appUser.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException(String.format("%s not found", username)));
    }

    private List<AppUser> getAppUserList() {
        List<AppUser> appUserList = List.of(
                new AppUser(
                        "u",
                        passwordEncoder.encode("u"),
                        AppUserRole.USER.grantedAuthoritySet(),
                        true,
                        true,
                        true,
                        true
                )
        );

        return appUserList;
    }
}
