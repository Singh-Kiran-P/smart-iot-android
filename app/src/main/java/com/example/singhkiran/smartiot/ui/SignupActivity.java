package com.example.singhkiran.smartiot.ui;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
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
import com.example.singhkiran.smartiot.R;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

    }

    public void signup_btn(View view) {

        //get url from login page
       // String Server_url = LoginActivity.Server_url;
        String Server_url = "http://10.0.2.2/api/users/register";


        //get value's from inputbox login and password
        final EditText name = findViewById(R.id.et_name);
        final EditText email = findViewById(R.id.et_email);
        final EditText username = findViewById(R.id.et_username);
        final EditText password = findViewById(R.id.et_password);
        final EditText password2 = findViewById(R.id.et_password2);


        //setting up json request


        Log.d("Server_url", "login: " + Server_url);


        //make request to REST API

        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest PostRequest = new StringRequest(Request.Method.POST, Server_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // response
                        Log.d("Response", response);
                        Toast.makeText(SignupActivity.this, response, Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    // error handeling
                    public void onErrorResponse(VolleyError error) {

                        if (error instanceof TimeoutError) {
                            Toast.makeText(SignupActivity.this, "Back-end Server is down!\nPlease contact the admin", Toast.LENGTH_SHORT).show();
                            Log.e("Volley TimeoutError: ", error.toString());
                        } else if (error instanceof NoConnectionError) {
                            Log.e("Volley NoConnection: ", error.toString());
                            Toast.makeText(SignupActivity.this, "No Connection!\nPlease contact the admin", Toast.LENGTH_SHORT).show();


                        } else if (error instanceof AuthFailureError) {
                            Toast.makeText(SignupActivity.this, "Invaild credentials ", Toast.LENGTH_SHORT).show();
                            Log.e("Volley AuthFailure: ", error.toString());
                        } else if (error instanceof ServerError) {
                            Log.e("Volley ServerError: ", error.toString());
                        } else if (error instanceof NetworkError) {
                            Log.e("Volley NetworkError: ", error.toString());
                        } else if (error instanceof ParseError) {
                            Log.e("Volley ParseError: ", error.toString());
                        } else if (error instanceof ClientError) {
                            Log.e("Volley ClientError: ", error.toString());
                            Toast.makeText(SignupActivity.this, "All Fields are required!", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
        ) {

            //Make a JsonObject

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();

                String name_res = name.getText().toString();
                String email_res = email.getText().toString();
                String username_res = username.getText().toString();
                String pass_res = password.getText().toString();
                String pass2_res = password2.getText().toString();

                Log.d("Register", name_res + " " + email_res);

                params.put("name", name_res);
                params.put("email", email_res);
                params.put("username", username_res);
                params.put("password", pass_res);
                params.put("password2", pass2_res);


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
}
