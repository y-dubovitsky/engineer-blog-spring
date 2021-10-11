package ru.ydubovitsky.engineerblog.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.ydubovitsky.engineerblog.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public JwtUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ru.ydubovitsky.engineerblog.entity.User user = userRepository.findByUsername(username); //FIXME
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        } else {
            return new User(
                    user.getUsername(),
                    user.getPassword(),
                    new ArrayList<>()
            ) {
            };
        }
    }
}
