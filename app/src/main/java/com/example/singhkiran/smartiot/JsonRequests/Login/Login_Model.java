package com.example.singhkiran.smartiot.JsonRequests.Login;

import java.io.Serializable;

public class Login_Model implements Serializable {

    private String id;
    private String name;
    private String username;
    private String password;
    private String email;
    private String role;
    private String message;
    private String status;

    public  Login_Model(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }
}
