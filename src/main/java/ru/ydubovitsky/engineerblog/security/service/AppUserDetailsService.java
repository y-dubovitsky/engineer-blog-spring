package ru.ydubovitsky.engineerblog.security.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.ydubovitsky.engineerblog.security.model.AppUser;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private final AppUserDaoService appUserDaoService;

    public AppUserDetailsService(@Qualifier("database") AppUserDaoService appUserDaoService) {
        this.appUserDaoService = appUserDaoService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUserByUsername = appUserDaoService.getAppUserByUsername(username);
        return appUserByUsername;
    }
}
