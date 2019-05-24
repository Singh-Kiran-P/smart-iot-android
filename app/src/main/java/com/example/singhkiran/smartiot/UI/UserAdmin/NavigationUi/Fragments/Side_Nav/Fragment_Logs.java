package com.example.singhkiran.smartiot.UI.UserAdmin.NavigationUi.Fragments.Side_Nav;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;
import com.example.singhkiran.smartiot.R;

public class Fragment_Logs extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.nrml_fragment_logs, null);
}

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//
//        new CountDownTimer(30000, 1000) {
//
//            public void onTick(long millisUntilFinished) {
//
//            }
//
//            public void onFinish() {
//                LottieAnimationView animationView = getActivity().findViewById(R.id.animation_view);
//                animationView.setVisibility(view.INVISIBLE);
//            }
//
//        }.start();
    }



}

