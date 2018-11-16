package com.example.singhkiran.smartiot.JsonRequests.API_Info;

public class API_Server {

    private String Server_url ="http://192.168.0.213";
    public  void setServer_url(String url){
        this.Server_url = url;
    }

    public String getServer_url(){
         return Server_url;
    }

}