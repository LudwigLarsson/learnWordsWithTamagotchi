package com.ludwiglarsson.learnwordswithtamagotchi.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.ludwiglarsson.learnwordswithtamagotchi.R;

public class CategoryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);
        ImageView professions = (ImageView) findViewById(R.id.professions);
        ImageView inventions = (ImageView) findViewById(R.id.inventions);
        ImageView plants = (ImageView) findViewById(R.id.plants);
        ImageView animals = (ImageView) findViewById(R.id.animals);
        ImageView space = (ImageView) findViewById(R.id.space);
        ImageView architecture = (ImageView) findViewById(R.id.architecture);
        professions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryListActivity.this, NewWordActivity.class);
                intent.putExtra("category", "professions");
                startActivity(intent);
            }
        });
        inventions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryListActivity.this, NewWordActivity.class);
                intent.putExtra("category", "inventions");
                startActivity(intent);
            }
        });
        plants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryListActivity.this, NewWordActivity.class);
                intent.putExtra("category", "plants");
                startActivity(intent);
            }
        });
        animals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryListActivity.this, NewWordActivity.class);
                intent.putExtra("category", "animals");
                startActivity(intent);
            }
        });
        space.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryListActivity.this, NewWordActivity.class);
                intent.putExtra("category", "space");
                startActivity(intent);
            }
        });
        architecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryListActivity.this, NewWordActivity.class);
                intent.putExtra("category", "architecture");
                startActivity(intent);
            }
        });
    }
    /*public void setPhoto() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        int width = displayMetrics.widthPixels;

        professions.getLayoutParams().width = (int) Math.ceil(width / 4);
        professions.requestLayout();

        inventions.getLayoutParams().width = (int) Math.ceil(width / 4);
        inventions.requestLayout();

        plants.getLayoutParams().width = (int) Math.ceil(width / 2 - 50);
        plants.requestLayout();

        animals.getLayoutParams().width = (int) Math.ceil(width / 2 - 50);
        animals.requestLayout();

        space.getLayoutParams().width = (int) Math.ceil(width / 2 - 50);
        space.requestLayout();

        architecture.getLayoutParams().width = (int) Math.ceil(width / 2 - 50);
        architecture.requestLayout();
    }*/

}