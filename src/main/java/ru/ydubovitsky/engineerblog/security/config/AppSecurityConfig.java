package ru.ydubovitsky.engineerblog.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.ydubovitsky.engineerblog.jwt.JwtTokenVerifierFilter;
import ru.ydubovitsky.engineerblog.jwt.JwtUsernameAndPasswordAuthFilter;
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
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernameAndPasswordAuthFilter(authenticationManager()))
                .addFilterAfter(new JwtTokenVerifierFilter(), JwtUsernameAndPasswordAuthFilter.class)
                .authorizeRequests()
                .antMatchers("index", "/", "/home", "/api/user/**")
                .permitAll()
                .anyRequest()
                .authenticated();
    }
}
