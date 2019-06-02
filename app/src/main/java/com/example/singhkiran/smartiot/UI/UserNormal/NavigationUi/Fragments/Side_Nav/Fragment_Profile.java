package com.example.singhkiran.smartiot.UI.UserNormal.NavigationUi.Fragments.Side_Nav;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.singhkiran.smartiot.JsonRequests.ChangeUserData.UserData_Request;
import com.example.singhkiran.smartiot.JsonRequests.Login.Login_Model;
import com.example.singhkiran.smartiot.R;


public class Fragment_Profile extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.nrml_fragment_profile, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showinfo();
        init_OnCliks(view);


    }

    Intent intent;
    Login_Model login_response;
    TextView name;
    EditText username;
    EditText password;
    EditText email;
    EditText role;
    EditText message;

    public void showinfo() {

        //Toast.makeText(this, login_response.getEmail(), Toast.LENGTH_SHORT).show();

        //TextView id = findViewById(R.id.tv_id);
        //id.setText(login_response.getId());
        intent = getActivity().getIntent();
        login_response = (Login_Model) intent.getSerializableExtra("info");

        name = getActivity().findViewById(R.id.tv_name);
        username = getActivity().findViewById(R.id.tv_username);
        password = getActivity().findViewById(R.id.tv_password);
        email = getActivity().findViewById(R.id.tv_email);
        role = getActivity().findViewById(R.id.tv_role);
        message = getActivity().findViewById(R.id.tv_message);


        name.setText(login_response.getName());


        username.setText(login_response.getUsername());


        email.setText(login_response.getEmail());


        role.setText(login_response.getRole());

        message.setText(login_response.getMessage());
    }

    private void init_OnCliks(View view) {

//        edit user info Profile page
        final ImageView loginButton = view.findViewById(R.id.click_Edit);
        loginButton.setOnClickListener(v ->
                new UserData_Request(login_response.getId(), name.getText().toString(), email.getText().toString(), password.getText().toString(), getContext()));
    }


}

