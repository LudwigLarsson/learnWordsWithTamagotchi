package com.ludwiglarsson.learnwordswithtamagotchi.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;

import com.ludwiglarsson.learnwordswithtamagotchi.R;
import com.ludwiglarsson.learnwordswithtamagotchi.data.DataBaseHandler;


public class CategoryListActivity extends AppCompatActivity {
    HomeActivity homeActivity;
    private SharedPreferences sharedPref;

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

        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        DataBaseHandler handler = new DataBaseHandler(this);
        professions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                int id = handler.getRandomId("professions");
                if (id == -1) {
                    intent = new Intent(CategoryListActivity.this, ResultActivity.class);
                    intent.putExtra("result", -1);
                    startActivity(intent);
                } else {
                    homeActivity = new HomeActivity();
                    homeActivity.points(25, 1, getApplicationContext());
                    intent = new Intent(CategoryListActivity.this, NewWordActivity.class);
                    intent.putExtra("id", id);
                    intent.putExtra("category", "professions");
                    startActivity(intent);
                }
            }
        });
        inventions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                int id = handler.getRandomId("inventions");
                if (id == -1) {
                    intent = new Intent(CategoryListActivity.this, ResultActivity.class);
                    intent.putExtra("result", -1);
                    startActivity(intent);
                } else {
                    homeActivity = new HomeActivity();
                    homeActivity.points(25, 1, getApplicationContext());
                    intent = new Intent(CategoryListActivity.this, NewWordActivity.class);
                    intent.putExtra("id", id);
                    intent.putExtra("category", "inventions");
                    startActivity(intent);
                }
            }
        });
        plants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                int id = handler.getRandomId("plants");
                if (id == -1) {
                    intent = new Intent(CategoryListActivity.this, ResultActivity.class);
                    intent.putExtra("result", -1);
                    startActivity(intent);
                } else {
                    homeActivity = new HomeActivity();
                    homeActivity.points(25, 1, getApplicationContext());
                    intent = new Intent(CategoryListActivity.this, NewWordActivity.class);
                    intent.putExtra("id", id);
                    intent.putExtra("category", "plants");
                    startActivity(intent);
                }
            }
        });
        animals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                int id = handler.getRandomId("animals");
                if (id == -1) {
                    intent = new Intent(CategoryListActivity.this, ResultActivity.class);
                    intent.putExtra("result", -1);
                    startActivity(intent);
                } else {
                    homeActivity = new HomeActivity();
                    homeActivity.points(25, 1, getApplicationContext());
                    intent = new Intent(CategoryListActivity.this, NewWordActivity.class);
                    intent.putExtra("id", id);
                    intent.putExtra("category", "animals");
                    startActivity(intent);
                }
            }
        });
        space.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                int id = handler.getRandomId("space");
                if (id == -1) {
                    intent = new Intent(CategoryListActivity.this, ResultActivity.class);
                    intent.putExtra("result", -1);
                    startActivity(intent);
                } else {
                    homeActivity = new HomeActivity();
                    homeActivity.points(25, 1, getApplicationContext());
                    intent = new Intent(CategoryListActivity.this, NewWordActivity.class);
                    intent.putExtra("id", id);
                    intent.putExtra("category", "space");
                    startActivity(intent);
                }
            }
        });
        architecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                int id = handler.getRandomId("architecture");
                if (id == -1) {
                    intent = new Intent(CategoryListActivity.this, ResultActivity.class);
                    intent.putExtra("result", -1);
                    startActivity(intent);
                } else {
                    homeActivity = new HomeActivity();
                    homeActivity.points(25, 1, getApplicationContext());
                    intent = new Intent(CategoryListActivity.this, NewWordActivity.class);
                    intent.putExtra("id", id);
                    intent.putExtra("category", "architecture");
                    startActivity(intent);
                }
            }
        });
    }

}