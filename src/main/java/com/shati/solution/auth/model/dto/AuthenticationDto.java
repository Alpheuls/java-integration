package com.shati.solution.auth.model.dto;

public class AuthenticationDto {

    private String userId;
    private String authToken;

    public AuthenticationDto() {
    }

    public AuthenticationDto(String userId, String authToken) {
        this.userId = userId;
        this.authToken = authToken;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
