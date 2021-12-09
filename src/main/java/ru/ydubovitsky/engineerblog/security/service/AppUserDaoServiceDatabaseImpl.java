package ru.ydubovitsky.engineerblog.security.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ydubovitsky.engineerblog.entity.User;
import ru.ydubovitsky.engineerblog.repository.UserRepository;
import ru.ydubovitsky.engineerblog.security.model.AppUser;

import java.util.stream.Collectors;

@Service("database")
public class AppUserDaoServiceDatabaseImpl implements AppUserDaoService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AppUserDaoServiceDatabaseImpl(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AppUser getAppUserByUsername(String username) {
        User user = userRepository.findByUsername(username);

        //FIXME Улучшить
        if (user != null) {
            AppUser appUser = new AppUser(
                    user.getUsername(),
                    //FIXME Кодируется ли?
                    user.getPassword(),
                    user.getRoles().stream()
                            .map(role -> new SimpleGrantedAuthority(role.getName()))
                            .collect(Collectors.toSet()),
                    true,
                    true,
                    true,
                    true
            );

            return appUser;
        }
        //FIXME
        return null;
    }

}
