package ru.ydubovitsky.engineerblog.jwt;

import com.google.common.base.Strings;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class JwtTokenVerifierFilter extends OncePerRequestFilter {
    private String key = "authentication.AnonymousAuthenticationFilter@69c0bae6, org.springframework.security.web.session.SessionManagementFilter@393e7546, org.springframework.security.web.access";

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

        if(Strings.isNullOrEmpty(authHeader) || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.replace("Bearer " , "");
        try {
            Jws<Claims> claimsJws = Jwts.parser()
                    .setSigningKey(key.getBytes())
                    .parseClaimsJws(token);
            Claims body = claimsJws.getBody();
            String username = body.getSubject();
            var authorities = (List<Map<String, String>>) body.get("authorities");

            List<SimpleGrantedAuthority> authoritiesList = authorities.stream()
                    .map(authority -> new SimpleGrantedAuthority(authority.get("authority")))
                    .collect(Collectors.toList());

            Authentication authentication =
                    new UsernamePasswordAuthenticationToken(
                            username, null, authoritiesList
                    );
            SecurityContextHolder.getContext().setAuthentication(authentication);

            log.info(String.format("%s authenticated", username));
        } catch (JwtException e) {
            throw new IllegalStateException(String.format("Token: %s can not be trusted", token));
        }

        filterChain.doFilter(request, response);
    }
}
