package com.example.singhkiran.smartiot.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
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
import com.example.singhkiran.smartiot.R;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    //set API Server_url
    public static String Server_url = "http://10.0.2.2/api/users/login";


    RelativeLayout rellay1, rellay2;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
            rellay2.setVisibility(View.VISIBLE);
        }
    };
    private Button signup_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //set onclick listener for signup page button
        signup_page = (Button) findViewById(R.id.btn_signup);
        signup_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignupPage();
            }
        });

        rellay1 = (RelativeLayout) findViewById(R.id.rellay1);
        rellay2 = (RelativeLayout) findViewById(R.id.rellay2);

        handler.postDelayed(runnable, 2000); //2000 is the timeout for the splash
    }

    //open signup activity
    private void openSignupPage() {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

    public void login(View view) {
        //get value's from inputbox login and password
        final EditText username = findViewById(R.id.et_username);
        final EditText password = findViewById(R.id.et_password);


        final String username_result = username.getText().toString();
        final String password_result = password.getText().toString();
        Log.d("Server_url", "login: " + Server_url);

        //change server Server_url
        if (password_result.equals("sr")) {

            if (username_result.equals("")) {
                Toast.makeText(LoginActivity.this, "Server changed to => " + Server_url, Toast.LENGTH_SHORT).show();
                Log.d("Server_url", "login: " + Server_url);
            }
            if (!username_result.equals("")) {
                Server_url = "http://" + username_result + "/api/users/login";
                Toast.makeText(LoginActivity.this, "Server changed to => " + Server_url, Toast.LENGTH_SHORT).show();

            }
            return;
        }


        //make request to REST API

        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest PostRequest = new StringRequest(Request.Method.POST, Server_url,
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
                            Toast.makeText(LoginActivity.this, "Back-end Server is down!\nPlease contact the admin", Toast.LENGTH_SHORT).show();
                            Log.e("Volley TimeoutError: ", error.toString());
                        } else if (error instanceof NoConnectionError) {
                            Log.e("Volley NoConnection: ", error.toString());
                            Toast.makeText(LoginActivity.this, "No Connection!\nPlease contact the admin", Toast.LENGTH_SHORT).show();


                        } else if (error instanceof AuthFailureError) {
                            Toast.makeText(LoginActivity.this, "Invaild Username or Password", Toast.LENGTH_SHORT).show();
                            Log.e("Volley AuthFailure: ", error.toString());
                        } else if (error instanceof ServerError) {
                            Log.e("Volley ServerError: ", error.toString());
                        } else if (error instanceof NetworkError) {
                            Log.e("Volley NetworkError: ", error.toString());
                        } else if (error instanceof ParseError) {
                            Log.e("Volley ParseError: ", error.toString());
                        } else if (error instanceof ClientError) {
                            Log.e("Volley ClientError: ", error.toString());
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

        //set the delay for timeout error = 2sec
        PostRequest.setRetryPolicy(new DefaultRetryPolicy(
                200,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        //send request
        requestQueue.add(PostRequest);
    }


    public void signup_btn(View view) {

        //open signup page

        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);

    }
}
