package com.ludwiglarsson.learnwordswithtamagotchi.UI;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ludwiglarsson.learnwordswithtamagotchi.MyViewModel;
import com.ludwiglarsson.learnwordswithtamagotchi.R;
import com.ludwiglarsson.learnwordswithtamagotchi.data.DataBaseHandler;
import com.ludwiglarsson.learnwordswithtamagotchi.data.Words;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pl.droidsonroids.gif.GifImageView;

public class GallowsActivity extends AppCompatActivity {
    public int attemptsCount = 9;
    public int positions = 1;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallows);
        DataBaseHandler bd = new DataBaseHandler(this);


        long rows = bd.tableSize("used");
        if (rows < 5) {
            Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
            intent.putExtra("result", 2);
            startActivity(intent);
        }
        Words words = (Words) bd.getRandomWord("used");
        String word = words.getName().toLowerCase();
        int word_length = word.length();
        char[] letters = new char[word_length];
        for (int i = 0; i < word.length(); ++i){
            letters[i] = (word.charAt(i));
        }
        LinearLayout word_fields = (LinearLayout) findViewById(R.id.word);
        for (int i = 0; i < word_length; ++i) {
            TextView textView = new TextView(this);
            if (letters[i] != ' ') {
                textView.setText("_   ");
            } else {
                textView.setText("   ");
                letters[i] = '0';
            }
            textView.setTextColor(Color.WHITE);
            textView.setId(i);
            textView.setTextSize(20);
            word_fields.addView(textView);
        }
        List<TextView> textViewList = new ArrayList<>();
        initTV(textViewList);
        /*MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);

        final TextView textView1 = findViewById(1);

        viewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                //textView1.setText(s);
            }
        });

        textView1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                viewModel.setText(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });*/

        for (int j = 0; j < 33; ++j) {
            TextView curr1 = textViewList.get(j);
            curr1.setTag(j+"");
            char[] small = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();
            String[] big = {"А   ", "Б   ", "В   ", "Г   ", "Д   ", "Е   ", "Ё   ", "Ж   ", "З   ", "И   ", "Й   ", "К   ", "Л   ", "М   ", "Н   ", "О   ", "П   ", "Р   ", "С   ", "Т   ", "У   ", "Ф   ", "Х   ", "Ц   ", "Ч   ", "Ш   ", "Щ   ", "Ъ   ", "Ы   ", "Ь   ", "Э   ", "Ю   ", "Я   "};
            curr1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int number = Integer.parseInt(v.getTag().toString());
                    boolean flag = false;
                    for (int i = 0; i < word_length; ++i) {
                        Log.d( "Tag1", small[number] + "=" + letters[i]);
                        if (letters[i] == small[number]) {
                            TextView curr = (TextView) findViewById(i);
                            curr.setText(big[number]);
                            flag = true;
                            letters[i] = '0';
                        }
                    }
                    if (flag) {
                        curr1.setTextColor(Color.GREEN);
                        boolean end = true;
                        for (int i = 0; i < word_length; ++i) {
                            if (letters[i] != '0') {
                                end = false;
                            }
                        }
                        if (end) {
                            /*Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                            intent.putExtra("result", 1);
                            startActivity(intent);
                            finishAffinity();*/
                            new AlertDialog.Builder(getApplication()).create().show();
                        }
                    } else {
                        curr1.setTextColor(Color.RED);
                        TextView attempts = (TextView) findViewById(R.id.count);
                        attemptsCount--;
                        attempts.setText(String.valueOf(attemptsCount));
                        GifImageView moon = (GifImageView) findViewById(R.id.moon);
                        positions++;
                        moon.setBackgroundDrawable(null);
                        switch (positions) {
                            case 2: moon.setImageResource(R.drawable.moon2);
                                break;
                            case 3: moon.setImageResource(R.drawable.moon3);
                                break;
                            case 4: moon.setImageResource(R.drawable.moon4);
                                break;
                            case 5: moon.setImageResource(R.drawable.moon5);
                                break;
                            case 6: moon.setImageResource(R.drawable.moon6);
                                break;
                            case 7: moon.setImageResource(R.drawable.moon7);
                                break;
                            case 8: moon.setImageResource(R.drawable.moon8);
                                break;
                            case 9: moon.setImageResource(R.drawable.moon9);
                                break;
                            case 10: moon.setImageResource(R.drawable.moon_end);
                                break;
                        }
                        if (attemptsCount <= 0) {
                            Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                            intent.putExtra("result", 0);
                            startActivity(intent);
                            finishAffinity();
                        }
                    }
                    curr1.setOnClickListener(null);
                }
            });
        }
    }
    private void initTV( List<TextView> textViewList) {
        TextView l1 = (TextView) findViewById(R.id.l1);
        TextView l2 = (TextView) findViewById(R.id.l2);
        TextView l3 = (TextView) findViewById(R.id.l3);
        TextView l4 = (TextView) findViewById(R.id.l4);
        TextView l5 = (TextView) findViewById(R.id.l5);
        TextView l6 = (TextView) findViewById(R.id.l6);
        TextView l7 = (TextView) findViewById(R.id.l7);
        TextView l8 = (TextView) findViewById(R.id.l8);
        TextView l9 = (TextView) findViewById(R.id.l9);
        TextView l10 = (TextView) findViewById(R.id.l10);
        TextView l11 = (TextView) findViewById(R.id.l11);
        TextView l12 = (TextView) findViewById(R.id.l12);
        TextView l13 = (TextView) findViewById(R.id.l13);
        TextView l14 = (TextView) findViewById(R.id.l14);
        TextView l15 = (TextView) findViewById(R.id.l15);
        TextView l16 = (TextView) findViewById(R.id.l16);
        TextView l17 = (TextView) findViewById(R.id.l17);
        TextView l18 = (TextView) findViewById(R.id.l18);
        TextView l19 = (TextView) findViewById(R.id.l19);
        TextView l20 = (TextView) findViewById(R.id.l20);
        TextView l21 = (TextView) findViewById(R.id.l21);
        TextView l22 = (TextView) findViewById(R.id.l22);
        TextView l23 = (TextView) findViewById(R.id.l23);
        TextView l24 = (TextView) findViewById(R.id.l24);
        TextView l25 = (TextView) findViewById(R.id.l25);
        TextView l26 = (TextView) findViewById(R.id.l26);
        TextView l27 = (TextView) findViewById(R.id.l27);
        TextView l28 = (TextView) findViewById(R.id.l28);
        TextView l29 = (TextView) findViewById(R.id.l29);
        TextView l30 = (TextView) findViewById(R.id.l30);
        TextView l31 = (TextView) findViewById(R.id.l31);
        TextView l32 = (TextView) findViewById(R.id.l32);
        TextView l33 = (TextView) findViewById(R.id.l33);
        textViewList.add(l1);
        textViewList.add(l2);
        textViewList.add(l3);
        textViewList.add(l4);
        textViewList.add(l5);
        textViewList.add(l6);
        textViewList.add(l7);
        textViewList.add(l8);
        textViewList.add(l9);
        textViewList.add(l10);
        textViewList.add(l11);
        textViewList.add(l12);
        textViewList.add(l13);
        textViewList.add(l14);
        textViewList.add(l15);
        textViewList.add(l16);
        textViewList.add(l17);
        textViewList.add(l18);
        textViewList.add(l19);
        textViewList.add(l20);
        textViewList.add(l21);
        textViewList.add(l22);
        textViewList.add(l23);
        textViewList.add(l24);
        textViewList.add(l25);
        textViewList.add(l26);
        textViewList.add(l27);
        textViewList.add(l28);
        textViewList.add(l29);
        textViewList.add(l30);
        textViewList.add(l31);
        textViewList.add(l32);
        textViewList.add(l33);
    }
}