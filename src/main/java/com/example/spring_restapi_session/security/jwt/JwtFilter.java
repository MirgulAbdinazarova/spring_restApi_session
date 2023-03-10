package com.example.spring_restapi_session.security.jwt;

import com.example.spring_restapi_session.service.impl.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component

public class JwtFilter extends OncePerRequestFilter {

    private final UserService userService;
    private  final  JwtTokenUtil jwtTokenUtil;

    public JwtFilter(UserService userService, JwtTokenUtil jwtTokenUtil) {
        this.userService = userService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        final String tokenHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        String userName= null;
        String jwt = null;
        if(tokenHeader!=null  && tokenHeader.startsWith("Bearer") ){
            jwt = tokenHeader.substring(7);
            userName=jwtTokenUtil.getUserNameFromToken(jwt);
        }
         if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
             UserDetails userDetails = this.userService.loadUserByUsername(userName);
             if(jwtTokenUtil.validateToken(jwt,userDetails)){
                 UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken
                         (userDetails,null,userDetails.getAuthorities());
                 token.setDetails(new WebAuthenticationDetailsSource() .buildDetails(request));
                 SecurityContextHolder.getContext().setAuthentication(token);
             }
             filterChain.doFilter(request,response);
         }
    }
}
