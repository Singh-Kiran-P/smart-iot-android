package com.example.singhkiran.smartiot.JsonRequests.API_Info;

import java.util.ArrayList;

public class API_Server {

    private String Server_url;
    public String DefauldServerURL = "http://192.168.0.198";

    public  void setServer_url(String url){
        this.Server_url = url;
    }

    public String getServer_url(){
        return this.Server_url;

    }

}