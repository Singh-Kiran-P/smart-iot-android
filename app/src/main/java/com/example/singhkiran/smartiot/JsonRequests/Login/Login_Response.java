package com.example.singhkiran.smartiot.JsonRequests.Login;

public class Login_Response {

    private String Id;
    private String Name;
    private String Username;
    private String Email;
    private String Role;
    private String Succes;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getSucces() {
        return Succes;
    }

    public void setSucces(String succes) {
        Succes = succes;
    }
}
