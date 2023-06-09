package com.ludwiglarsson.learnwordswithtamagotchi.UI;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.ludwiglarsson.learnwordswithtamagotchi.R;
import com.ludwiglarsson.learnwordswithtamagotchi.RecyclerTouchListener;
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
        ArrayList<Words> words = (ArrayList<Words>) bd.getAllUsedWords();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, words);
        RecyclerView rv = (RecyclerView) findViewById(R.id.recycler);
        rv.setBackgroundColor(Color.parseColor("#f7f7f7"));
        rv.setAdapter(adapter);
        rv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        rv.addOnItemTouchListener(new RecyclerTouchListener(this, rv, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(StudiedWordsActivity.this, NewWordActivity.class);
                intent.putExtra("id", position + 1);
                intent.putExtra("category", "used");
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {
            }

        }));
    }
}