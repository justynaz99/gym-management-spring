package com.gymmanagement.gymmanagement.jwt.resource;

import java.io.Serializable;

public class JwtTokenRequest implements Serializable {

    private static final long serialVersionUID = -5616176897013108345L;

    private String username;
    private String password;

//    {
//        "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqdXN0eW5hejk5IiwiZXhwIjoxNjI5NzkzNTc3LCJpYXQiOjE2MjkxODg3Nzd9.1MWPiym3OoDAfIzDr3BsO2Q1Qc8nCL1DRa7TukeHmQJFSDpfQBHE76Xx3cmNcUO-wvaA2WXhMIfYd-5xpkMC7A"
//    }

    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}