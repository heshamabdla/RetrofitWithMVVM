package com.example.retrofitwithmvvmrv.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.retrofitwithmvvmrv.R;
import com.example.retrofitwithmvvmrv.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<PostModel> PostModelArrayList= new ArrayList<>() ;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textViewTitle.setText(PostModelArrayList.get(position).getTitle());
        holder.textViewUserID.setText(PostModelArrayList.get(position).getUserId()+"");
        holder.textViewBody.setText(PostModelArrayList.get(position).getBody());

    }

    public void setList(List<PostModel> PostModelArrayList) {
        this.PostModelArrayList = PostModelArrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return PostModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle,textViewUserID,textViewBody;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle=itemView.findViewById(R.id.titleTV);
            textViewUserID=itemView.findViewById(R.id.userIdTV);
            textViewBody=itemView.findViewById(R.id.bodyTV);

        }
    }
}
