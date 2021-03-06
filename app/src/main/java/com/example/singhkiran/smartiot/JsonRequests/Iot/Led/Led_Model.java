package com.example.singhkiran.smartiot.JsonRequests.Iot.Led;

import java.io.Serializable;

public class Led_Model implements Serializable {
    private String userId;
    private String action;
    private String endPoint;

    public String getFirebase_token() {
        return firebase_token;
    }

    public void setFirebase_token(String firebase_token) {
        this.firebase_token = firebase_token;
    }

    private String firebase_token;


    public Led_Model(String action,String userId,String endPoint,String firebase_token){
        this.userId = userId;
        this.action = action;
        this.endPoint = endPoint;
        this.firebase_token = firebase_token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String message;
    private String permission;
    private String status;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }
}
