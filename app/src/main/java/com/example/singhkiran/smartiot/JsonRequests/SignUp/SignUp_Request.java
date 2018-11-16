package com.example.singhkiran.smartiot.JsonRequests.SignUp;

import android.content.Context;
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
import com.example.singhkiran.smartiot.R;
import com.example.singhkiran.smartiot.JsonRequests.API_Info.API_Server;
import com.example.singhkiran.smartiot.UI.SignupActivity;

import java.util.HashMap;
import java.util.Map;

public class SignUp_Request {

    public void MakeRequest(final Context context){

        //get url en set signup url
        API_Server api_server = new API_Server();
        String Url_Register = api_server.getServer_url()+"/api/users/register";


        //get value's from inputbox login and password
        final EditText name = ((SignupActivity)context).findViewById(R.id.et_name);
        final EditText email = ((SignupActivity)context).findViewById(R.id.et_email);
        final EditText username = ((SignupActivity)context).findViewById(R.id.et_username);
        final EditText password = ((SignupActivity)context).findViewById(R.id.et_password);
        final EditText password2 = ((SignupActivity)context).findViewById(R.id.et_password2);

        //setting up json request
        Log.d("Server_url", "login: " + Url_Register);

        //make request to REST API
        final RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest PostRequest = new StringRequest(Request.Method.POST, Url_Register,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // response
                        Log.d("Response", response);
                        Toast.makeText(context, response, Toast.LENGTH_SHORT).show();
                    }
                },
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
                            Toast.makeText(context, "Invaild credentials ", Toast.LENGTH_SHORT).show();
                            Log.e("Volley AuthFailure: ", error.toString());
                        } else if (error instanceof ServerError) {
                            Log.e("Volley ServerError: ", error.toString());
                        } else if (error instanceof NetworkError) {
                            Log.e("Volley NetworkError: ", error.toString());
                        } else if (error instanceof ParseError) {
                            Log.e("Volley ParseError: ", error.toString());
                        } else if (error instanceof ClientError) {
                            Log.e("Volley ClientError: ", error.toString());
                            Toast.makeText(context, "All Fields are required!", Toast.LENGTH_SHORT).show();
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
                500,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        //send request
        requestQueue.add(PostRequest);
    }
}
