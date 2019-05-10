package com.example.singhkiran.smartiot.UI.UserNormal.NavigationUi.Fragments.Side_Nav;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.singhkiran.smartiot.JsonRequests.Login.Login_Model;
import com.example.singhkiran.smartiot.R;


public class Fragment_Profile extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.nrml_fragment_profile1, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showinfo();
        init_OnCliks(view);


    }

    public void showinfo() {
        Intent intent = getActivity().getIntent();
        Login_Model login_response = (Login_Model) intent.getSerializableExtra("info");
        //Toast.makeText(this, login_response.getEmail(), Toast.LENGTH_SHORT).show();

        //TextView id = findViewById(R.id.tv_id);
        //id.setText(login_response.getId());

        TextView name = getActivity().findViewById(R.id.tv_name);
        name.setText(login_response.getName());

        TextView username = getActivity().findViewById(R.id.tv_username);
        username.setText(login_response.getUsername());


        TextView email = getActivity().findViewById(R.id.tv_email);

        email.setText(login_response.getEmail());

        TextView role = getActivity().findViewById(R.id.tv_role);
        role.setText(login_response.getRole());

        TextView message = getActivity().findViewById(R.id.tv_message);
        message.setText(login_response.getMessage());
    }

    private void init_OnCliks(View view) {

//        edit user info Profile page
        final ImageView loginButton =  view.findViewById(R.id.click_Edit);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Toast.makeText(getContext(), "Profile edit", Toast.LENGTH_SHORT).show();
            }
        });
    }



}

