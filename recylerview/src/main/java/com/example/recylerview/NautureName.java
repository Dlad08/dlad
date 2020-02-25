package com.example.recylerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NautureName extends RecyclerView.Adapter<NautureName.NautureHolder> {
    public NautureName(Context context, List<AndroidVersion> list) {
        this.context = context;
        this.list = list;
    }

    private Context context;
    private List<AndroidVersion> list;
    @NonNull
    @Override
    public NautureHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context)
                .inflate(R.layout.singke_view,parent,false);
        return new NautureHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NautureHolder holder, int position) {
       holder.getName().setText(list.get(position).getImage());
       holder.getImage().setImageResource(list.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class NautureHolder extends RecyclerView.ViewHolder {

        public NautureHolder(@NonNull View itemView) {
            super(itemView);
        }

        TextView getName(){
            return itemView.findViewById(R.id.textView11);

        }
        ImageView getImage(){
            return itemView.findViewById(R.id.imageView3);
        }
    }}

