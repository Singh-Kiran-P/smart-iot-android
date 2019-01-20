package com.example.singhkiran.smartiot.JsonRequests.SignUp;

public class Register_Model {
    private Integer status;
    private String message;
    private String name;
    private String email;
    private String username;
    private String password;

    public Register_Model(String name, String email, String username, String password) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getStatus() {
        return status;
    }
    public String getMessage() {
        return message;
    }

}