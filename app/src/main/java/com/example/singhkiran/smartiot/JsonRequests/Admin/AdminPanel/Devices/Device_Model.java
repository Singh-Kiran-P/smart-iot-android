package com.example.singhkiran.smartiot.JsonRequests.Admin.AdminPanel.Devices;

public class Device_Model {
    private String name;
    private String id;
    private String message;
    private String status;

    public Device_Model(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
