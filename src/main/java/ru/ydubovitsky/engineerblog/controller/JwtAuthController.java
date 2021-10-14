package ru.ydubovitsky.engineerblog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.ydubovitsky.engineerblog.dto.UserDto;
import ru.ydubovitsky.engineerblog.payload.request.JwtRequest;
import ru.ydubovitsky.engineerblog.payload.response.JwtResponse;
import ru.ydubovitsky.engineerblog.security.JwtTokenUtil;
import ru.ydubovitsky.engineerblog.service.UserDetailsServiceImpl;
import ru.ydubovitsky.engineerblog.service.UserService;

@RestController
public class JwtAuthController {

    private AuthenticationManager authenticationManager;

    private UserService userService;

    private JwtTokenUtil jwtTokenUtil;

    private UserDetailsServiceImpl userDetailsService;

    public JwtAuthController(AuthenticationManager authenticationManager, UserService userService, JwtTokenUtil jwtTokenUtil, UserDetailsServiceImpl userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        UserDto userDto = new UserDto(); //TODO Подумать как улучшить
        userDto.setUsername(userDetails.getUsername());

        return ResponseEntity.ok(new JwtResponse(token, userDto));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDto userDto) throws Exception {
        return ResponseEntity.ok(userService.save(userDto));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
