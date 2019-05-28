package com.example.singhkiran.smartiot.JsonRequests.SignUp;

public class Register_Model {
    private Integer status;
    private String message;
    private String name;
    private String email;
    private String username;
    private String password;
    private  String firebase_token;

    public Register_Model(String name, String email, String username, String password,String firebase_token) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.firebase_token = firebase_token;
    }

    public int getStatus() {
        return status;
    }
    public String getMessage() {
        return message;
    }

}