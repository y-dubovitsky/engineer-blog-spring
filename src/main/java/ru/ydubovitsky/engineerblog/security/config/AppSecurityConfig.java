package ru.ydubovitsky.engineerblog.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.ydubovitsky.engineerblog.security.jwt.JwtTokenVerifierFilter;
import ru.ydubovitsky.engineerblog.security.jwt.JwtUsernameAndPasswordAuthFilter;
import ru.ydubovitsky.engineerblog.security.service.AppUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final AppUserDetailsService appUserDetailsService;

    public AppSecurityConfig(PasswordEncoder passwordEncoder, AppUserDetailsService appUserDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.appUserDetailsService = appUserDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilter(new JwtUsernameAndPasswordAuthFilter(authenticationManager()));
        http.addFilterAfter(new JwtTokenVerifierFilter(), JwtUsernameAndPasswordAuthFilter.class);
        http.authorizeRequests().antMatchers("/api/auth/register").permitAll();
    }
}
