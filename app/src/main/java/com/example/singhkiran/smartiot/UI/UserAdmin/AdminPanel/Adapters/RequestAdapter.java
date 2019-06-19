package com.example.singhkiran.smartiot.UI.UserAdmin.AdminPanel.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.singhkiran.smartiot.JsonRequests.Admin.AdminPanel.PermissionRequest.Permission_Model;
import com.example.singhkiran.smartiot.R;

import java.util.List;

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.ViewHolder> {
    Context context;
    public static List<Permission_Model> list;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public static List<Permission_Model> getList() {
        return list;
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public RequestAdapter(Context context, List<Permission_Model> list) {
        this.context = context;
        this.list = list;

    }

    @Override
    public RequestAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.admin_request_recycler_items, parent, false);
        RequestAdapter.ViewHolder holder = new RequestAdapter.ViewHolder(v, mListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(RequestAdapter.ViewHolder holder, int position) {

        holder.title.setText(list.get(position).getName());

        holder.value.setText(list.get(position).getEndPoint());
//        holder.eindpoint.setText(list.get(position).getEindpoint());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;
        TextView date;
        TextView perms;
        TextView value;
        TextView eindpoint;
        onRequestListener onRequestListener;

        public ViewHolder(View itemView,final OnItemClickListener listener) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.cardviewLogs_title);
            date = (TextView) itemView.findViewById(R.id.cardLogs_date);
            perms = (TextView) itemView.findViewById(R.id.card_name);
            value = (TextView) itemView.findViewById(R.id.cardValue);
            eindpoint = (TextView) itemView.findViewById(R.id.cardEndpoint);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }

        @Override
        public void onClick(View v) {
        }
    }

    public interface onRequestListener {
        void onRequestClick(int position);
    }
}
