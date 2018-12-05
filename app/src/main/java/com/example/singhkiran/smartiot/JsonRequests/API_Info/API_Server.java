package com.example.singhkiran.smartiot.JsonRequests.API_Info;

import java.io.Serializable;
import java.util.ArrayList;

public class API_Server implements Serializable {

    private String Server_url;
    public String DefualtServerURL = "http://192.168.0.213";

    public  void setServer_url(String url){
        this.Server_url = url;
    }

    public String getServer_url(){
        if (this.Server_url == null){
            return DefualtServerURL;
        }else {
            return this.Server_url;
        }
    }

}