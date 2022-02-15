package com.shati.solution.auth.service;

import com.shati.solution.auth.client.AuthClient;
import com.shati.solution.auth.model.dto.AuthenticationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthClient authClient;

    public AuthenticationDto createToken(String userId, HttpHeaders headers) {
        try {
            return authClient.createToken(userId, headers);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public AuthenticationDto validateToken(String userId, HttpHeaders headers) {
        try {
            return authClient.validateToken(userId, headers);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
