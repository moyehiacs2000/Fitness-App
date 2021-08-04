package com.example.newfitnessapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newfitnessapp.Models.*;
import com.example.newfitnessapp.R;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProgramsAdapter extends RecyclerView.Adapter<ProgramsAdapter.MyViewHolder> {
    private List<PogramModel> DataItems;
    private Context context;

    public ProgramsAdapter(List<PogramModel> dataItems, Context context) {
        DataItems = dataItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ProgramsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_programs,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull  ProgramsAdapter.MyViewHolder holder, int position) {

        Picasso.get().load(DataItems.get(position).getImg()).into(holder.Program_Image);
        holder.Program_Name.setText(DataItems.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return DataItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView Program_Name;
        private ImageView Program_Image;
        public MyViewHolder(@NonNull  View itemView) {
            super(itemView);
            Program_Image=itemView.findViewById(R.id.program_img);
            Program_Name=itemView.findViewById(R.id.program_name);
        }
    }
}
