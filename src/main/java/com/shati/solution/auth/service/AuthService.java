package com.shati.solution.auth.service;

import com.shati.solution.auth.client.AuthClient;
import com.shati.solution.auth.model.dto.AuthenticationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class AuthService {

    @Autowired
    private AuthClient authClient;

    public AuthenticationDto createToken(String userId) {
        try {
            return authClient.createToken(userId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public AuthenticationDto validateToken(String userId, HttpServletRequest headers) {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(HttpHeaders.AUTHORIZATION, headers.getHeader(HttpHeaders.AUTHORIZATION));
            return authClient.validateToken(userId, httpHeaders);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
