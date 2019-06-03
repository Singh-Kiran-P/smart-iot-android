package com.example.singhkiran.smartiot.UI.UserNormal.Adapters;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.singhkiran.smartiot.JsonRequests.AdminPanel.Devices.Device_Model;
import com.example.singhkiran.smartiot.R;
import com.example.singhkiran.smartiot.UI.UserAdmin.AdminPanel.Adapters.DeviceAdapter;

import java.util.List;

public class LogsAdapter extends RecyclerView.Adapter<LogsAdapter.ViewHolder> {
    Context context;
    List<Device_Model> list;

    public LogsAdapter(Context context,List<Device_Model> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public LogsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());

    }



    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);

            name= (TextView) itemView.findViewById(R.id.txt_devicename);

        }
    }
}
