package com.siddhantbhardwaj.fashionapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ImageViewHolder> {


    Context mContext;
    List<Row> mData;

    public RecyclerViewAdapter() {
    }

    public RecyclerViewAdapter(Context mContext, List<Row> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item,
                parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int i) {

        // Binding image here
        // USING GLIDE LIBRARY

        Glide.
                with(mContext)
                .load(mData.get(i).getImage())
                .into(holder.image);

        // Binding TextView with data
        holder.title.setText(mData.get(i).getTitle());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }



    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image;
        TextView title;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.textView2);

            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            if(getLayoutPosition() == 0){
                Toast.makeText(mContext, "You clicked on the first item", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
