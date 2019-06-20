package com.example.singhkiran.smartiot.UI.UserAdmin.AdminPanel.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.singhkiran.smartiot.JsonRequests.Admin.AdminPanel.Feedback.Feedback_Model;
import com.example.singhkiran.smartiot.JsonRequests.Admin.AdminPanel.PermissionRequest.Permission_Model;
import com.example.singhkiran.smartiot.JsonRequests.Nrml_Users.ShowLogs.ShowLogs_Model;
import com.example.singhkiran.smartiot.R;
import com.example.singhkiran.smartiot.UI.UserAdmin.AdminPanel.FeedbackActivity;

import java.util.List;


public class FeedbackAdapter extends RecyclerView.Adapter<FeedbackAdapter.ViewHolder> {
    Context context;
    List<Feedback_Model> list;

    public FeedbackAdapter(Context context, List<Feedback_Model> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.admin_feedback_recycler_items, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.user.setText(list.get(position).getName());
        holder.feedback.setText(list.get(position).getFeedback());
        holder.platform.setText(list.get(position).getPlatform());


    }



    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView user;
        TextView feedback;
        TextView platform;

        public ViewHolder(View itemView) {
            super(itemView);

            user = (TextView) itemView.findViewById(R.id.txtUser);
            feedback = (TextView) itemView.findViewById(R.id.txt_feedback);
            platform = (TextView) itemView.findViewById(R.id.txt_platform);


        }
    }
}
