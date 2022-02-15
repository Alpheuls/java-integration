package com.shati.solution.auth.client;

import com.shati.solution.auth.model.dto.AuthenticationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "authIntegration",
url = "http://localhost:8081/solution-api-authentication",
path = "/auth")
public interface AuthClient {

    @PostMapping("/{userId}")
    AuthenticationDto createToken(@PathVariable String userId, @RequestHeader HttpHeaders headers);

    @GetMapping("/{userId}")
    AuthenticationDto validateToken(@PathVariable String userId,@RequestHeader HttpHeaders request);

    }
