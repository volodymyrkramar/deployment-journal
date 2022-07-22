package com.dev.deploymentjournal.payload;

public class JWTTokenSucessResponse {
    private boolean success;
    private String token;

    public JWTTokenSucessResponse(boolean success, String token) {
        this.success = success;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "JWTTokenSucessResponse{" +
                "success=" + success +
                ", token='" + token + '\'' +
                '}';
    }
}
