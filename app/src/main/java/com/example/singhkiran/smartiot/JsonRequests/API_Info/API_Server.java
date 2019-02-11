package com.example.singhkiran.smartiot.JsonRequests.API_Info;

import java.util.ArrayList;

public class API_Server {

    private static String Server_url;
    public static String DefauldServerURL = "https://smartiot.viewdns.net:8080";

    public  void setServer_url(String url) {
        this.Server_url = url;
    }

    public String getServer_url() {
        return this.Server_url;

    }

}