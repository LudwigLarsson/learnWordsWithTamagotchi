package com.ludwiglarsson.learnwordswithtamagotchi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.common.util.ArrayUtils;
import com.ludwiglarsson.learnwordswithtamagotchi.R;

public class GallowsActivity extends AppCompatActivity {
    public int attemptsCount = 8;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallows);
        //получаем рандомное слово
        String word = ("Капибара").toLowerCase();
        int word_length = word.length();
        char[] letters = new char[word_length];
        for (int i = 0; i < word.length(); ++i){
            letters[i] = (word.charAt(i));
        }
        LinearLayout word_fields = (LinearLayout) findViewById(R.id.word);
        for (int i = 0; i < word_length; ++i) {
            TextView textView = new TextView(this);
            textView.setText("_   ");
            textView.setTextColor(Color.WHITE);
            textView.setId(i);
            textView.setTextSize(20);
            word_fields.addView(textView);
        }
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

        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'а') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("А   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    l1.setTextColor(Color.GREEN);
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l1.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l1.setOnClickListener(null);
            }
        });
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'б') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("Б   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    l2.setTextColor(Color.GREEN);
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l2.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l2.setOnClickListener(null);
            }
        });
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'в') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("В   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    l3.setTextColor(Color.GREEN);
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l3.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l3.setOnClickListener(null);
            }
        });
        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'г') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("Г   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    l4.setTextColor(Color.GREEN);
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l4.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l4.setOnClickListener(null);
            }
        });
        l5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'д') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("Д   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    l5.setTextColor(Color.GREEN);
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l5.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l5.setOnClickListener(null);
            }
        });
        l6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'е') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("Е   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    l6.setTextColor(Color.GREEN);
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l6.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l6.setOnClickListener(null);
            }
        });
        l7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'ё') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("Ё   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    l7.setTextColor(Color.GREEN);
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l7.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l7.setOnClickListener(null);
            }
        });
        l8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'ж') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("Ж   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    l8.setTextColor(Color.GREEN);
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l8.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l8.setOnClickListener(null);
            }
        });
        l9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'з') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("З   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l9.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l9.setOnClickListener(null);
            }
        });
        l10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'и') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("И   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    l10.setTextColor(Color.GREEN);
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l10.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l10.setOnClickListener(null);
            }
        });
        l11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'й') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("Й   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    l11.setTextColor(Color.GREEN);
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l11.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l11.setOnClickListener(null);
            }
        });
        l12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'к') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("К   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    l12.setTextColor(Color.GREEN);
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l12.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l12.setOnClickListener(null);
            }
        });
        l13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'л') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("Л   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    l13.setTextColor(Color.GREEN);
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l13.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l13.setOnClickListener(null);
            }
        });
        l14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'м') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("М   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    l14.setTextColor(Color.GREEN);
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l14.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l14.setOnClickListener(null);
            }
        });
        l15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'н') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("Н   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    l15.setTextColor(Color.GREEN);
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l15.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l15.setOnClickListener(null);
            }
        });
        l16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'о') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("О   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    l16.setTextColor(Color.GREEN);
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l16.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l16.setOnClickListener(null);
            }
        });
        l17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'п') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("П   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    l17.setTextColor(Color.GREEN);
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l17.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l17.setOnClickListener(null);
            }
        });
        l18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'р') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("Р   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    l18.setTextColor(Color.GREEN);
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l18.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l18.setOnClickListener(null);
            }
        });
        l19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'с') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("С   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    l19.setTextColor(Color.GREEN);
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l19.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l19.setOnClickListener(null);
            }
        });
        l20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'т') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("Т   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    l20.setTextColor(Color.GREEN);
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l20.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l20.setOnClickListener(null);
            }
        });
        l21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'у') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("У   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    l21.setTextColor(Color.GREEN);
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l21.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l21.setOnClickListener(null);
            }
        });
        l22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'ф') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("Ф   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    l22.setTextColor(Color.GREEN);
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l22.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l22.setOnClickListener(null);
            }
        });
        l23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'х') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("Х   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    l23.setTextColor(Color.GREEN);
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l23.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l23.setOnClickListener(null);
            }
        });
        l24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'ц') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("Ц   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    l24.setTextColor(Color.GREEN);
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l24.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l24.setOnClickListener(null);
            }
        });
        l25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'ч') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("Ч   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    l25.setTextColor(Color.GREEN);
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l25.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l25.setOnClickListener(null);
            }
        });
        l26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'ш') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("Ш   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    l26.setTextColor(Color.GREEN);
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l26.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l26.setOnClickListener(null);
            }
        });
        l27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'щ') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("Щ   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    l27.setTextColor(Color.GREEN);
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l27.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l27.setOnClickListener(null);
            }
        });
        l28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'ъ') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("Ъ   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    l28.setTextColor(Color.GREEN);
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l28.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l28.setOnClickListener(null);
            }
        });
        l29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'ы') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("Ы   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    l29.setTextColor(Color.GREEN);
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l29.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l29.setOnClickListener(null);
            }
        });
        l30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'ь') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("Ь   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    l30.setTextColor(Color.GREEN);
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l30.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l30.setOnClickListener(null);
            }
        });
        l31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'э') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("Э   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    l31.setTextColor(Color.GREEN);
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l31.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l31.setOnClickListener(null);
            }
        });
        l32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'ю') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("Ю   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    l32.setTextColor(Color.GREEN);
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l32.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l32.setOnClickListener(null);
            }
        });
        l33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < word_length; ++i) {
                    if (letters[i] == 'я') {
                        TextView curr = (TextView) findViewById(i);
                        curr.setText("Я   ");
                        flag = true;
                        letters[i] = '0';
                    }
                }
                if (flag) {
                    l33.setTextColor(Color.GREEN);
                    boolean end = true;
                    for (int i = 0; i < word_length; ++i) {
                        if (letters[i] != '0') {
                            end = false;
                        }
                    }
                    if (end) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                    }
                } else {
                    l33.setTextColor(Color.RED);
                    TextView attempts = (TextView) findViewById(R.id.count);
                    attemptsCount--;
                    attempts.setText(String.valueOf(attemptsCount));
                    if (attemptsCount <= 0) {
                        Intent intent = new Intent(GallowsActivity.this, ResultActivity.class);
                        intent.putExtra("result", false);
                        startActivity(intent);
                    }
                }
                l33.setOnClickListener(null);
            }
        });
    }
}