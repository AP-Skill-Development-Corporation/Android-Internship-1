package com.example.retroexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<Pojo> dataList;
    private Context context;

    public CustomAdapter(Context context,List<Pojo> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

       TextView name,login;

        CustomViewHolder(View itemView) {
            super(itemView);

            login=itemView.findViewById(R.id.login);
            name=itemView.findViewById(R.id.name);

        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        holder.name.setText(dataList.get(position).getName());
        holder.login.setText(dataList.get(position).getLogin());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}