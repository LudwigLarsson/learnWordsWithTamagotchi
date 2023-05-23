package com.ludwiglarsson.learnwordswithtamagotchi;


import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ludwiglarsson.learnwordswithtamagotchi.data.Words;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater inflater;
    private ArrayList<Words> words;
    private Context context;
    private int counter = 0;

    public RecyclerViewAdapter(Context context, ArrayList<Words> words) {
        this.inflater = LayoutInflater.from(context);
        this.words = words;
        this.context = context;

    }

    private class MyHolder extends RecyclerView.ViewHolder {
        private TextView word_name;
        private ImageView image;


        public MyHolder(@NonNull View itemView) {
            super(itemView);
            word_name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.pic);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.view_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Words w = this.words.get(position);
        ((MyHolder) holder).word_name.setText(w.getName());
        ((MyHolder) holder).image.setImageBitmap(BitmapFactory.decodeFile(w.getPhoto()));
    }
    @Override
    public int getItemCount() {
        return words.size();
    }
}
