package com.shati.solution.auth.controller;

import com.shati.solution.auth.client.AuthClient;
import com.shati.solution.auth.model.dto.AuthenticationDto;
import com.shati.solution.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/{userId}")
    public ResponseEntity<String> createToken(@PathVariable String userId, @RequestHeader HttpHeaders headers) {
        AuthenticationDto authenticationDto = new AuthenticationDto();
        try {
            authenticationDto = authService.createToken(userId, headers);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("access_token", authenticationDto.getAuthToken());
            return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body("Ok");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(authenticationDto.getAuthToken());
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<String> validateToken(@PathVariable String userId,@RequestHeader HttpHeaders headers) {
        AuthenticationDto authenticationDto = new AuthenticationDto();
        try {
            authenticationDto = authService.validateToken(userId, headers);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("access_token", authenticationDto.getAuthToken());
            return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body("Ok");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(authenticationDto.getAuthToken());
        }
    }

}
