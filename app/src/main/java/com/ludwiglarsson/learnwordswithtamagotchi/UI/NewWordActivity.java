package com.ludwiglarsson.learnwordswithtamagotchi.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ludwiglarsson.learnwordswithtamagotchi.R;
import com.ludwiglarsson.learnwordswithtamagotchi.data.DataBaseHandler;
import com.ludwiglarsson.learnwordswithtamagotchi.data.Words;

public class NewWordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);
        Intent i = getIntent();
        int id = i.getIntExtra("id", 1);
        String category = i.getStringExtra("category");
        Log.d("Tag1", id + "");
        Log.d("Tag2", category);
        DataBaseHandler bd = new DataBaseHandler(this);
        Words word = (Words) bd.getWord(id, category);
        String currName = word.getName();
        String currDescription = word.getDescription();
        String currPhoto = word.getPhoto();
        TextView name = (TextView) findViewById(R.id.name);
        TextView description = (TextView) findViewById(R.id.description);
        name.setText(currName);
        description.setText(currDescription);
    }
    //public void onBackPressed() {
    //}
}