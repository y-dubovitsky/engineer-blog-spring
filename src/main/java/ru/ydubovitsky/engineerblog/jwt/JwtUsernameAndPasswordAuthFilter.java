package ru.ydubovitsky.engineerblog.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.ydubovitsky.engineerblog.jwt.request.UsernameAndPasswordAuthReq;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

@Slf4j
public class JwtUsernameAndPasswordAuthFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private String key = "authentication.AnonymousAuthenticationFilter@69c0bae6, org.springframework.security.web.session.SessionManagementFilter@393e7546, org.springframework.security.web.access";

    public JwtUsernameAndPasswordAuthFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws AuthenticationException {
        try {
            UsernameAndPasswordAuthReq authReq = new ObjectMapper()
                    .readValue(request.getInputStream(), UsernameAndPasswordAuthReq.class);

            Authentication authentication =
                    new UsernamePasswordAuthenticationToken(
                            authReq.getUsername(),
                            authReq.getPassword()
                    );
            logger.info(String.format("Attempt auth by user %s", authentication.getPrincipal()));
            return authenticationManager.authenticate(authentication);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain,
            Authentication authResult
    ) throws IOException, ServletException {
        String token = Jwts.builder()
                .setSubject(authResult.getName())
                .claim("authorities", authResult.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(30)))
                .signWith(Keys.hmacShaKeyFor(this.key.getBytes()))
                .compact();

        response.addHeader("Authorization", "Bearer " + token);
    }
}
