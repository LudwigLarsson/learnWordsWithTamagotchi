package com.ludwiglarsson.learnwordswithtamagotchi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

public class ViewPager2Adapter extends RecyclerView.Adapter<ViewPager2Adapter.ViewHolder> {

    // Array of images
    // Adding images from drawable folder
    private int[] images = {R.drawable.first, R.drawable.second, R.drawable.third, R.drawable.fourth};
    private String[] texts = {"Добро пожаловать! В этом приложении вы будете познавать мир вместе со своим тамагочи", "Для того, чтобы о нём позаботиться, вы можете изучать новые слова и повторять их, ведь они пригодятся вам в играх", "Игры помогут запомнить пройденный материал и тоже улучшат здоровье тамагочи", "Постарайтесь поддерживать здоровье тамагочи как можно дольше!"};
    private Context ctx;

    // Constructor of our ViewPager2Adapter class
    public ViewPager2Adapter(Context ctx) {
        this.ctx = ctx;
    }

    // This method returns our layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.start_page, parent, false);
        return new ViewHolder(view);
    }

    // This method binds the screen with the view
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // This will set the images in imageview
        holder.images.setImageResource(images[position]);
        holder.texts.setText(texts[position]);
    }

    // This Method returns the size of the Array
    @Override
    public int getItemCount() {
        return images.length;
    }

    // The ViewHolder class holds the view
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView images;
        TextView texts;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            images = itemView.findViewById(R.id.images);
            texts = itemView.findViewById(R.id.texts);
        }
    }
}