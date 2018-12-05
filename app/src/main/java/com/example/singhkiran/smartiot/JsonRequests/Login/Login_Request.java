package com.example.singhkiran.smartiot.JsonRequests.Login;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.ClientError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.singhkiran.smartiot.JsonRequests.API_Info.API_Server;
import com.example.singhkiran.smartiot.R;
import com.example.singhkiran.smartiot.UI.LoginActivity;
import com.example.singhkiran.smartiot.UI.Main_Page;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Login_Request {

    API_Server api_server = new API_Server();

    public void MakeRequest(final Context context) {


        //get value's from inputbox login and password
        final EditText username = ((LoginActivity) context).findViewById(R.id.et_username);
        final EditText password = ((LoginActivity) context).findViewById(R.id.et_password);

        final String username_result = username.getText().toString();
        final String password_result = password.getText().toString();
        Log.d("Server_url", "login: " + api_server.getServer_url());

        //change server Server_url
        if (password_result.equals("sr")) {

            if (username_result.equals("")) {
                Toast.makeText(context, "Server changed to => " + api_server.getServer_url(), Toast.LENGTH_SHORT).show();
                Log.d("Server_url", "login: " + api_server.getServer_url());
            }
            if (!username_result.equals("")) {
                api_server.setServer_url("http://" + username_result);
                Toast.makeText(context, "Server changed to => " + api_server.getServer_url(), Toast.LENGTH_SHORT).show();

            }

        }


        //get url en set signup url
        String Url_Login;
        if (api_server.getServer_url() == null) {
            Url_Login = api_server.DefauldServerURL + "/api/users/login";
        } else {
            Url_Login = api_server.getServer_url() + "/api/users/login";
        }
        //make request to REST API
        final RequestQueue requestQueue = Volley.newRequestQueue(context);

        StringRequest PostRequest = new StringRequest(Request.Method.POST, Url_Login,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // response
                        Log.d("Response", response);
                        //create A Login respone object form response JSON
                        ObjectMapper objectMapper = new ObjectMapper();
                        Login_Response login_response = null;
                        try {
                            login_response = objectMapper.readValue(response, Login_Response.class);
                            Intent intent = new Intent(context, Main_Page.class);

                            intent.putExtra("info", login_response);
                            context.startActivity(intent);
                            Toast.makeText(context, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                },
                //when there are errors

                new Response.ErrorListener() {

                    @Override
                    // error handeling
                    public void onErrorResponse(VolleyError error) {
                        if (error instanceof TimeoutError) {
                            Toast.makeText(context, "Back-end Server is down!\nPlease contact the admin", Toast.LENGTH_SHORT).show();
                            Log.e("Volley TimeoutError: ", error.toString());
                        } else if (error instanceof NoConnectionError) {
                            Log.e("Volley NoConnection: ", error.toString());
                            Toast.makeText(context, "No Connection!\nPlease contact the admin", Toast.LENGTH_SHORT).show();
                        } else if (error instanceof AuthFailureError) {
                            Toast.makeText(context, "Invaild Username or Password", Toast.LENGTH_SHORT).show();
                            Log.e("Volley AuthFailure: ", error.toString());
                        } else if (error instanceof ServerError) {
                            Log.e("Volley ServerError: ", error.toString());
                        } else if (error instanceof NetworkError) {
                            Log.e("Volley NetworkError: ", error.toString());
                        } else if (error instanceof ParseError) {
                            Log.e("Volley ParseError: ", error.toString());
                        } else if (error instanceof ClientError) {
                            Log.e("Volley ClientError: ", error.toString());
                            Toast.makeText(context, "Username and Password are required!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        ) {

            //Make a JsonObject
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                Log.d("login", username_result + " " + password_result);
                params.put("username", username_result);
                params.put("password", password_result);

                return params;
            }
        };

        //set the delay for timeout error = 2sec
        PostRequest.setRetryPolicy(new DefaultRetryPolicy(
                500,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        //send request
        requestQueue.add(PostRequest);
    }
}
