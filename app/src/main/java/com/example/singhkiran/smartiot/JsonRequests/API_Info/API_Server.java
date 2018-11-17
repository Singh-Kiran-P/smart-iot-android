package com.example.singhkiran.smartiot.JsonRequests.API_Info;

import java.util.ArrayList;

public class API_Server {

    private String Server_url;
    private ArrayList<String> api_info_list = new ArrayList<String>();
    public  void setServer_url(String url){
        this.Server_url = url;
        api_info_list.add(this.Server_url);
    }

    public String getServer_url(){
        String url = api_info_list.get(0);
        api_info_list.clear();
        return url;

    }

}