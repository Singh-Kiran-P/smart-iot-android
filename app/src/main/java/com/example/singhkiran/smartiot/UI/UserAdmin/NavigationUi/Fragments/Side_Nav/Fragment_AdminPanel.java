package com.example.singhkiran.smartiot.UI.UserAdmin.NavigationUi.Fragments.Side_Nav;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.singhkiran.smartiot.JsonRequests.Login.Login_Model;
import com.example.singhkiran.smartiot.R;
import com.example.singhkiran.smartiot.UI.UserAdmin.AdminPanel.DevicesActivity;
import com.example.singhkiran.smartiot.UI.UserAdmin.AdminPanel.FeedbackActivity;
import com.example.singhkiran.smartiot.UI.UserAdmin.AdminPanel.RequestsActivity;


public class Fragment_AdminPanel extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.admin_fragment_admin_panel, null);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        Toast.makeText(getContext(), "Admin pannel", Toast.LENGTH_SHORT).show();
        init_OnCliks();

    }

    private void init_OnCliks() {

        LinearLayout devices =  getActivity().findViewById(R.id.click_devices);
        devices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getContext(), "Profile edit", Toast.LENGTH_SHORT).show();
                Intent intent = getActivity().getIntent();
                Login_Model login_response = (Login_Model) intent.getSerializableExtra("info");
                Intent intent2 = new Intent(getContext(), DevicesActivity.class);
                intent2.putExtra("info", login_response);
                startActivity(intent2);
            }
        });

        LinearLayout logs =  getActivity().findViewById(R.id.click_logs);
        logs.setOnClickListener(v -> {
//            Toast.makeText(getContext(), "Profile edit", Toast.LENGTH_SHORT).show();
        });

        LinearLayout feedback =  getActivity().findViewById(R.id.click_feedback);
        feedback.setOnClickListener(v -> {
//            Toast.makeText(getContext(), "Profile edit", Toast.LENGTH_SHORT).show();
            Intent intent = getActivity().getIntent();
            Login_Model login_response = (Login_Model) intent.getSerializableExtra("info");
            Intent intent2 = new Intent(getContext(), FeedbackActivity.class);
            intent2.putExtra("info", login_response);
            startActivity(intent2);
        });

        LinearLayout request =  getActivity().findViewById(R.id.click_requests);
        request.setOnClickListener(v -> {
//            Toast.makeText(getContext(), "Profile edit", Toast.LENGTH_SHORT).show();
            Intent intent = getActivity().getIntent();
            Login_Model login_response = (Login_Model) intent.getSerializableExtra("info");
            Intent intent2 = new Intent(getContext(), RequestsActivity.class);
            intent2.putExtra("info", login_response);
            startActivity(intent2);
        });

        LinearLayout users =  getActivity().findViewById(R.id.click_showUsers);
        users.setOnClickListener(v -> {
//            Toast.makeText(getContext(), "Profile edit", Toast.LENGTH_SHORT).show();
        });
    }


}

