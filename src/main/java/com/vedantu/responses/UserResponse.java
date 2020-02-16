package com.vedantu.responses;

import com.vedantu.requests.UserRequest;

public class UserResponse {
    String jwtToken;

    public UserResponse(){
        super();
    }

    public UserResponse(String jwtToken){
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
