package com.arms.arms.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arms.arms.R;
import com.arms.arms.model.Picture;
import com.arms.arms.view.PictureDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PictureAdapterRecyclerView extends RecyclerView.Adapter<PictureAdapterRecyclerView.PictureViewHolder>{
    private ArrayList<Picture> pictures;
    private Activity activity;
    private int resource;

    public PictureAdapterRecyclerView(ArrayList<Picture> pictures, Activity activity, int resource) {
        this.pictures = pictures;
        this.activity = activity;
        this.resource = resource;
    }

    @NonNull
    @Override
    public PictureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PictureViewHolder holder, int position) {
        final Picture picture=pictures.get(position);
        holder.usernamecardview.setText(picture.getUsername());
        holder.timecard.setText(picture.getTime());
        holder.cantidad_gusta.setText(picture.getLike());
        Picasso.get().load(picture.getPicture()).into(holder.picturecard);
        holder.picturecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(activity,PictureDetailActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    public class PictureViewHolder extends RecyclerView.ViewHolder{

        private ImageView picturecard;
        private TextView timecard;
        private TextView usernamecardview;
        private TextView cantidad_gusta;

        public PictureViewHolder(View itemView) {
            super(itemView);

            picturecard=itemView.findViewById(R.id.picturecard);
            timecard=itemView.findViewById(R.id.timecard);
            usernamecardview=itemView.findViewById(R.id.usernamecardview);
            cantidad_gusta=itemView.findViewById(R.id.cantidad_gusta);
        }
    }
}
