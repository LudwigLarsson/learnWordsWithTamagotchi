package com.ludwiglarsson.learnwordswithtamagotchi.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Color;
import android.os.Bundle;

import com.ludwiglarsson.learnwordswithtamagotchi.R;
import com.ludwiglarsson.learnwordswithtamagotchi.RecyclerViewAdapter;
import com.ludwiglarsson.learnwordswithtamagotchi.data.DataBaseHandler;
import com.ludwiglarsson.learnwordswithtamagotchi.data.Words;

import java.util.ArrayList;

public class StudiedWordsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studied_words);
        DataBaseHandler bd = new DataBaseHandler(this);
        ArrayList<Words> products = (ArrayList<Words>) bd.getAllUsedWords();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, products);
        RecyclerView rv = (RecyclerView) findViewById(R.id.recycler);
        rv.setBackgroundColor(Color.parseColor("#f7f7f7"));
        rv.setAdapter(adapter);
        rv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
    }
}