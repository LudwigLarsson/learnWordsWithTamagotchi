package com.ludwiglarsson.learnwordswithtamagotchi.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;

import com.ludwiglarsson.learnwordswithtamagotchi.R;

public class GameListActivity extends AppCompatActivity {
    HomeActivity homeActivity;

    private SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);
        ImageView one = (ImageView) findViewById(R.id.game1);
        ImageView two = (ImageView) findViewById(R.id.game2);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeActivity = new HomeActivity();
                homeActivity.points(15, 2, getApplicationContext());
                Intent intent = new Intent(GameListActivity.this, GallowsActivity.class);
                startActivity(intent);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeActivity = new HomeActivity();
                homeActivity.points(15, 2, getApplicationContext());
                Intent intent = new Intent(GameListActivity.this, GuessActivity.class);
                startActivity(intent);
            }
        });
    }
}