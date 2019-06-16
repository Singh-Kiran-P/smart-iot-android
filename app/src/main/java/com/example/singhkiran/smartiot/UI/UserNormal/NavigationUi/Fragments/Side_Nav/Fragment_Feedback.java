package com.example.singhkiran.smartiot.UI.UserNormal.NavigationUi.Fragments.Side_Nav;

        import android.content.Intent;
        import android.os.Bundle;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;

        import android.os.CountDownTimer;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.Toast;

        import com.airbnb.lottie.LottieAnimationView;
        import com.example.singhkiran.smartiot.JsonRequests.Login.Login_Model;
        import com.example.singhkiran.smartiot.JsonRequests.Nrml_Users.ChangeUserData.UserData_Request;
        import com.example.singhkiran.smartiot.JsonRequests.Nrml_Users.SendFeedback.SendFeedback_Request;
        import com.example.singhkiran.smartiot.JsonRequests.Nrml_Users.ShowLogs.ShowLogs_Request;
        import com.example.singhkiran.smartiot.R;
        import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Fragment_Feedback extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.nrml_fragment_feedback, null);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init_OnCliks(view);
    }


    private void init_OnCliks(View view) {
        EditText et_feedback = view.findViewById(R.id.et_feedback);
//        edit user info Profile page
        final FloatingActionButton send = view.findViewById(R.id.btn_send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_feedback.getText().toString().equals("")) {
                    Toast.makeText(getContext(), "Please fil the context", Toast.LENGTH_SHORT).show();

                }else {
                    Intent intent = getActivity().getIntent();
                    Login_Model login_response = (Login_Model) intent.getSerializableExtra("info");
                    new SendFeedback_Request(login_response.getId(),et_feedback.getText().toString(),getContext());

                }
            }
        });
    }

}




