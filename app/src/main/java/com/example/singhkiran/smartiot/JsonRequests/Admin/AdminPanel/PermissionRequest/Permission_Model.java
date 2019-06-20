package com.example.singhkiran.smartiot.JsonRequests.Admin.AdminPanel.PermissionRequest;

public class Permission_Model {
    private String route_permissionId;
    private String endPoint ;
    private String id;
    private String userId;
    private String permsTblId;
    private String permission;
    private String message;
    private String status;

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

    public Permission_Model(String endPoint, String permsTblId, String userId, String permission) {
        this.endPoint = endPoint;
        this.permsTblId = permsTblId;
        this.userId = userId;
        this.permission = permission;
    }

    public String getPermsTblId() {
        return permsTblId;
    }

    public void setPermsTblId(String permsTblId) {
        this.permsTblId = permsTblId;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;



    public String getRoute_permissionId() {
        return route_permissionId;
    }

    public void setRoute_permissionId(String route_permissionId) {
        this.route_permissionId = route_permissionId;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
