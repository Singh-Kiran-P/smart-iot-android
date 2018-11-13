package com.example.singhkiran.smartiot;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.ClientError;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.singhkiran.smartiot.R;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    RelativeLayout rellay1, rellay2;

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
            rellay2.setVisibility(View.VISIBLE);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        rellay1 = (RelativeLayout) findViewById(R.id.rellay1);
        rellay2 = (RelativeLayout) findViewById(R.id.rellay2);

        handler.postDelayed(runnable, 2000); //2000 is the timeout for the splash
    }

    public void login(View view) {
        //get value's from inputbox login and password
        final EditText username = findViewById(R.id.et_username);
        final EditText password = findViewById(R.id.et_password);

        final String username_result = username.getText().toString();
        final String password_result = password.getText().toString();


        //check if Fields have values
        if (username_result == "w") {
            Toast.makeText(getApplicationContext(), "Username is Empty!", Toast.LENGTH_SHORT).show();

        }
        if (password_result == "") {
            Toast.makeText(getApplicationContext(), "Password is Empty!", Toast.LENGTH_SHORT).show();


        }
        if (password_result == "" && username_result == "") {
            Toast.makeText(getApplicationContext(), "Username and Password Fields are empty!", Toast.LENGTH_SHORT).show();


        } else {

            //make request to REST API
            String url = "http://84.192.126.235/api/users/login";
            final RequestQueue requestQueue = Volley.newRequestQueue(this);
            StringRequest PostRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // response
                            Log.d("Response", response);
                            Toast.makeText(LoginActivity.this, response, Toast.LENGTH_SHORT).show();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        // error handeling
                        public void onErrorResponse(VolleyError error) {

                            if (error instanceof TimeoutError) {
                                Toast.makeText(LoginActivity.this, "Main Server is down!", Toast.LENGTH_SHORT).show();
                                Log.e("VolleyError TimeoutError: ", error.toString());
                            } else if (error instanceof NoConnectionError) {
                                Log.e("VolleyError NoConnectionError: ", error.toString());
                            } else if (error instanceof AuthFailureError) {
                                Toast.makeText(LoginActivity.this, "Invaild Username or Password", Toast.LENGTH_SHORT).show();
                                Log.e("VolleyError AuthFailureError: ", error.toString());
                            } else if (error instanceof ServerError) {
                                Log.e("VolleyError ServerError: ", error.toString());
                            } else if (error instanceof NetworkError) {
                                Log.e("VolleyError NetworkError: ", error.toString());
                            } else if (error instanceof ParseError) {
                                Log.e("VolleyError ParseError: ", error.toString());
                            } else if (error instanceof ClientError) {
                                Log.e("VolleyError ClientError: ", error.toString());
                                Toast.makeText(LoginActivity.this, "Username and Password are required!", Toast.LENGTH_SHORT).show();
                            }

                        }
                    }
            ) {

                //Make a JsonObject

                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<String, String>();

                    String username_result = username.getText().toString();
                    String password_result = password.getText().toString();
                    Log.d("login", username_result + " " + password_result);
                    params.put("username", username_result);
                    params.put("password", password_result);


                    return params;
                }
            };

            requestQueue.add(PostRequest);

        }
    }
}
