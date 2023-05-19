package com.ludwiglarsson.learnwordswithtamagotchi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ludwiglarsson.learnwordswithtamagotchi.R;
import com.ludwiglarsson.learnwordswithtamagotchi.data.DataBaseHandler;
import com.ludwiglarsson.learnwordswithtamagotchi.data.Words;

public class NewWordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);

        /*Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String category = extras.getString("category");
        }*/
        DataBaseHandler bd = new DataBaseHandler(this);
        Words word = (Words) bd.getRandomWord();
        String name = word.getName();
        String description = word.getDescription();
        String photo = word.getPhoto();
    }
}