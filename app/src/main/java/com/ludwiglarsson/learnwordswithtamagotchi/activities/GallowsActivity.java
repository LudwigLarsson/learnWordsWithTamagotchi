package com.ludwiglarsson.learnwordswithtamagotchi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ludwiglarsson.learnwordswithtamagotchi.R;

public class GallowsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallows);
        //получаем рандомное слово и его длину
        LinearLayout word = (LinearLayout) findViewById(R.id.word);
        for (int i = 0; i < 15; ++i) { //на самом деле, длина слова
            TextView textView = new TextView(this);
            textView.setText("_   ");
            textView.setTextColor(Color.WHITE);
            textView.setTextSize(30);
            word.addView(textView);
        }
    }
}