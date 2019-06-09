package com.example.singhkiran.smartiot.UI.UserNormal.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.singhkiran.smartiot.JsonRequests.Admin.AdminPanel.Devices.Device_Model;
import com.example.singhkiran.smartiot.JsonRequests.Nrml_Users.ShowLogs.ShowLogs_Model;
import com.example.singhkiran.smartiot.R;

import java.util.List;

public class LogsAdapter extends RecyclerView.Adapter<LogsAdapter.ViewHolder> {
    Context context;
    List<ShowLogs_Model> list;

    public LogsAdapter(Context context, List<ShowLogs_Model> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.nrml_logs_recycler_view_item, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.title.setText(list.get(position).getName());
        holder.date.setText(list.get(position).getCreatedOn());
        holder.perms.setText(list.get(position).getPermission());
        holder.value.setText(list.get(position).getValue());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView date;
        TextView perms;
        TextView value;

        public ViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.cardviewLogs_title);
            date = (TextView) itemView.findViewById(R.id.cardLogs_date);
            perms = (TextView) itemView.findViewById(R.id.card_name);
            value = (TextView) itemView.findViewById(R.id.cardValue);

        }
    }
}
