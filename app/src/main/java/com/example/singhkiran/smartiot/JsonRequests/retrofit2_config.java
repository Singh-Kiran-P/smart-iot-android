package com.example.singhkiran.smartiot.JsonRequests;

import com.example.singhkiran.smartiot.JsonRequests.API_Info.API_Server;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofit2_config {
    API_Server api_server = new API_Server();

    private static String url;
    public Retrofit retrofit;

    public retrofit2_config() {
        url = api_server.getServer_url();
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }


}
