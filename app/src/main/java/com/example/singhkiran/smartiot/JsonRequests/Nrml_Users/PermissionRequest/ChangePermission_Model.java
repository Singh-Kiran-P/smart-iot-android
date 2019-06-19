package com.example.singhkiran.smartiot.JsonRequests.Nrml_Users.PermissionRequest;

public class ChangePermission_Model {
    private String userId;
    private String endpoint;
    private String message;
    private String status;

    public ChangePermission_Model(String userId, String endpoint) {
        this.userId = userId;
        this.endpoint = endpoint;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
