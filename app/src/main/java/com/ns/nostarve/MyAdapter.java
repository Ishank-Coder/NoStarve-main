package com.ns.nostarve;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    Context context;

    ArrayList<userlistmodel> list;

    public MyAdapter(Context context, ArrayList<userlistmodel> list){
        this.context = context;
        this.list = list;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.user_cardview,parent , false);

        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        userlistmodel userlistmodel = list.get(position);
        holder.name.setText(userlistmodel.getName());
        holder.address.setText(userlistmodel.getAddress());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name , address;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.textView7);
            address = itemView.findViewById(R.id.textView8);
        }
    }
}
