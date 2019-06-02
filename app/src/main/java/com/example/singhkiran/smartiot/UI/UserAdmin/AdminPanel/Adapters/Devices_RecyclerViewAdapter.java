package com.example.singhkiran.smartiot.UI.UserAdmin.AdminPanel.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.singhkiran.smartiot.JsonRequests.AdminPanel.Devices.Device_Model;
import com.example.singhkiran.smartiot.R;

import java.util.List;

public class Devices_RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.Adapte> {


    private List<Device_Model> device_modelList;
    private Context context ;
    public Devices_RecyclerViewAdapter(Context context, List<Device_Model> Data ) {
        Log.i("autolog", "RecyclerViewAdapter");
        this.device_modelList = Data;
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i("autolog", "onCreateViewHolder");
        View view = LayoutInflater.from(context).inflate(R.layout.admin_devices_recycler_view_row, null);

        return new RecyclerView.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
