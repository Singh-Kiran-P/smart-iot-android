package com.example.singhkiran.smartiot.UI.UserNormal.NavigationUi.Fragments.Side_Nav;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.cardview.widget.CardView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.Toast;

import com.example.singhkiran.smartiot.JsonRequests.Login.Login_Model;
import com.example.singhkiran.smartiot.R;
import com.example.singhkiran.smartiot.UI.UserNormal.Acticitys.Iot_Devices.LedActivity;
import com.example.singhkiran.smartiot.UI.UserNormal.Acticitys.Iot_Devices.Temp_HumidityActivity;
import com.example.singhkiran.smartiot.UI.UserNormal.Acticitys.Iot_Devices.UltraSensorActivity;


public class Fragment_Iot extends Fragment {
    GridLayout mainGrid;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.nrml_fragment_iot, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainGrid = (GridLayout) getActivity().findViewById(R.id.mainGrid);

        //Set Event
        setSingleEvent(mainGrid);
        //setToggleEvent(mainGrid);
    }

    private void setToggleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        Toast.makeText(getContext(), "State : True", Toast.LENGTH_SHORT).show();

                    } else {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(getContext(), "State : False", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setSingleEvent(GridLayout mainGrid) {
//        //Loop all child item of Main Grid
//        for (int i = 0; i < mainGrid.getChildCount(); i++) {
//            //You can see , all child item is CardView , so we just cast object to CardView
//            CardView cardView = (CardView) mainGrid.getChildAt(i);
//            final int finalI = i;
//            cardView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = getActivity().getIntent();
//                    Login_Model login_response = (Login_Model) intent.getSerializableExtra("info");
//                    Intent intent2 = new Intent(getContext(), LedActivity.class);
//                    intent2.putExtra("info",login_response);
//                    startActivity(intent2);
//
//                }
//            });
        CardView cardViewLed = (CardView) mainGrid.getChildAt(0);
        cardViewLed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getActivity().getIntent();
                Login_Model login_response = (Login_Model) intent.getSerializableExtra("info");
                Intent intent2 = new Intent(getContext(), LedActivity.class);
                intent2.putExtra("info", login_response);
                startActivity(intent2);
            }
        });
        CardView cardViewUltra = (CardView) mainGrid.getChildAt(1);
        cardViewUltra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getActivity().getIntent();
                Login_Model login_response = (Login_Model) intent.getSerializableExtra("info");
                Intent intent2 = new Intent(getContext(), UltraSensorActivity.class);
                intent2.putExtra("info", login_response);
                startActivity(intent2);
            }
        });
        CardView cardViewTemp = (CardView) mainGrid.getChildAt(2);
        cardViewTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getActivity().getIntent();
                Login_Model login_response = (Login_Model) intent.getSerializableExtra("info");
                Intent intent2 = new Intent(getContext(), Temp_HumidityActivity.class);
                intent2.putExtra("info", login_response);
                startActivity(intent2);
            }
        });
    }
}

