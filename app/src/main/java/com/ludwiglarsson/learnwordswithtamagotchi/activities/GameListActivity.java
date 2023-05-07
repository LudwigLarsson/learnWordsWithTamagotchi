package com.ludwiglarsson.learnwordswithtamagotchi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.ludwiglarsson.learnwordswithtamagotchi.R;

public class GameListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);
        ImageView one = (ImageView) findViewById(R.id.game1);
        ImageView two = (ImageView) findViewById(R.id.game2);
        ImageView three = (ImageView) findViewById(R.id.game3);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameListActivity.this, GallowsActivity.class);
                startActivity(intent);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameListActivity.this, GuessActivity.class);
                startActivity(intent);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameListActivity.this, PermutationActivity.class);
                startActivity(intent);
            }
        });
    }
}