package com.ludwiglarsson.learnwordswithtamagotchi.UI;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ludwiglarsson.learnwordswithtamagotchi.R;
import com.ludwiglarsson.learnwordswithtamagotchi.data.DataBaseHandler;
import com.ludwiglarsson.learnwordswithtamagotchi.data.Dictionary;
import com.ludwiglarsson.learnwordswithtamagotchi.data.Words;

import java.time.Duration;
import java.time.Instant;

import pl.droidsonroids.gif.GifImageView;


public class HomeActivity extends AppCompatActivity{
    public static final int REQUEST_CODE = 1;
    protected String name = "";
    protected int currentCondition = 2;
    protected boolean firstTime = true;
    protected long start;
    protected long bestTime = 0;
    protected static int scale1 = 100;
    protected static int scale2 = 100;
    protected static int scale3 = 24;
    protected int timeReduceScale1 = 216000;
    protected int timeReduceScale2 = 432000;
    protected final long condition1 = 225;
    protected final long condition2 = 150;
    protected final long condition3 = 75;
    protected final long condition4 = 0;
    int height;
    int width;
    static ProgressBar progressBar3;
    static ProgressBar progressBar2;
    static ProgressBar progressBar1;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    SharedPreferences preferences1;
    GifImageView gif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView name_view = (TextView) findViewById(R.id.set_name);
        preferences = getPreferences(MODE_PRIVATE);
        firstTime = preferences.getBoolean("firstTime", true);
        name = preferences.getString("name", "");
        bestTime = preferences.getLong("bestTime", 1);
        start = preferences.getLong("start", 1);
        currentCondition = preferences.getInt("currentCondition", 1);
        progressBar3 = (ProgressBar)findViewById(R.id.progressBar3);
        progressBar2 = (ProgressBar)findViewById(R.id.progressBar2);
        progressBar1 = (ProgressBar)findViewById(R.id.progressBar1);
        name_view.setText(name);
        if (!firstTime) {
            scale1 = preferences.getInt("scale1", 1);
            scale2 = preferences.getInt("scale2", 1);
            scale3 = preferences.getInt("scale3", 1);
            long exit = preferences.getLong("exit", 1);
            long entrance = Instant.now().toEpochMilli();
            long passedTime = entrance - exit;
            Log.d("passedtime", passedTime + "");
            scale1 -= passedTime / timeReduceScale1;
            scale2 -= passedTime / timeReduceScale2;
            if (scale1 < 0) {
                scale1 = 0;
            }
            if (scale2 < 0) {
                scale2 = 0;
            }
            if (scale3 < 0) {
                scale3 = 0;
            }
        }
        progressBar1.setProgress(scale1);
        progressBar2.setProgress(scale2);
        progressBar3.setProgress(scale3);
        if (firstTime) {
            Intent intent = new Intent(HomeActivity.this, StartActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
            firstTime = false;
            start = Instant.now().toEpochMilli();
            preferences = getPreferences(MODE_PRIVATE);
            editor = preferences.edit();
            editor.putBoolean("firstTime", firstTime);
            editor.putLong("start", start);
            editor.putInt("scale1", scale1);
            editor.putInt("scale2", scale2);
            editor.putInt("scale3", scale3);
            editor.commit();
            DataBaseHandler dataBaseHandler = new DataBaseHandler(HomeActivity.this);
            Dictionary dict = new Dictionary();
            dict.words(dataBaseHandler);
        }
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(getResources().getColor(R.color.background));
        setPhotos();
        onChangeScale1();
        onChangeScale2();
        onChangeScale3();
        ImageView book = findViewById(R.id.book);
        ImageView shelf = findViewById(R.id.shelf);
        GifImageView space = (GifImageView) findViewById(R.id.space);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CategoryListActivity.class);
                startActivity(intent);
            }
        });
        shelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, StudiedWordsActivity.class);
                startActivity(intent);
            }
        });

        space.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, GameListActivity.class);
                startActivity(intent);
            }
        });

    }

    public void setPhotos() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;

        ImageView back = (ImageView) findViewById(R.id.back);
        back.getLayoutParams().width = (int) Math.ceil(height * 16 / 9);
        back.requestLayout();

        preferences = getPreferences(MODE_PRIVATE);
        currentCondition = preferences.getInt("currentCondition", 1);

        gif = (GifImageView) findViewById(R.id.gif);
        gif.getLayoutParams().height = (int) Math.ceil(height / 2);
        gif.getLayoutParams().width = (int) Math.ceil(height / 2 * 584 / 389);
        gif.requestLayout();
        switch (currentCondition) {
            case 2: gif.setImageResource(R.drawable.neutral);
                break;
            case 3: gif.setImageResource(R.drawable.angry);
                break;
            case 4: gif.setImageResource(R.drawable.crying2);
                break;
            case 5: gif.setImageResource(R.drawable.dead1);
                onDie();
                break;
            case 1: gif.setImageResource(R.drawable.happy);
                gif.getLayoutParams().height = (int) Math.ceil(height / 2);
                gif.getLayoutParams().width = (int) Math.ceil(height / 2 * 584 / 389);
                gif.requestLayout();
                break;
        }

        GifImageView space = (GifImageView) findViewById(R.id.space);
        space.getLayoutParams().height = (int) Math.ceil((width - height * 16 / 9) + (height * 16 / 9 * 80 / 590) / 1.5 * 388 / 215);
        space.getLayoutParams().width = (int) Math.ceil((width - height * 16 / 9) + (height * 16 / 9 * 80 / 590) / 1.5);
        space.requestLayout();

        ImageView table = (ImageView) findViewById(R.id.table);
        table.getLayoutParams().height = (int) Math.ceil(width / 1.5 * 720 / 2000);
        table.getLayoutParams().width = (int) Math.ceil(width / 1.5);
        table.requestLayout();

        ImageView book = (ImageView) findViewById(R.id.book);
        book.getLayoutParams().height = (int) Math.ceil(width / 2 * 520 / 924 / 3.5);
        book.getLayoutParams().width = (int) Math.ceil(width / 2 * 520 / 924 / 3.5 * 508 / 326);
        book.requestLayout();

        ImageView shelf = (ImageView) findViewById(R.id.shelf);
        shelf.getLayoutParams().height = (int) Math.ceil(height / 3.5);
        shelf.getLayoutParams().width = (int) Math.ceil(height / 3.5 * 924 / 520);
        shelf.requestLayout();
    }

    public void onChangeCondition(){
        preferences = getPreferences(MODE_PRIVATE);
        scale1 = preferences.getInt("scale1", 1);
        scale2 = preferences.getInt("scale2", 1);
        scale3 = preferences.getInt("scale3", 1);
        int amount = scale1 + scale2 + scale3;
        if (amount < condition1 && amount >= condition2) {
            currentCondition = 2;
        } else if (amount < condition2 && amount >= condition3) {
            currentCondition = 3;
        } else if (amount < condition3 && amount > condition4) {
            currentCondition = 4;
        } else if (amount == condition4) {
            currentCondition = 5;
        } else if (amount >= condition1) {
            currentCondition = 1;
        }
        editor = preferences.edit();
        editor.putInt("currentCondition", currentCondition);
        editor.commit();

        gif = (GifImageView) findViewById(R.id.gif);
        gif.getLayoutParams().height = (int) Math.ceil(height / 2);
        gif.getLayoutParams().width = (int) Math.ceil(height / 2 * 584 / 389);
        gif.requestLayout();
        switch (currentCondition) {
            case 2:
                gif.setImageResource(R.drawable.neutral);
                break;
            case 3:
                gif.setImageResource(R.drawable.angry);
                break;
            case 4:
                gif.setImageResource(R.drawable.crying2);
                break;
            case 5:
                gif.setImageResource(R.drawable.dead1);
                onDie();
                break;
            case 1:
                gif.setImageResource(R.drawable.happy);
                gif.getLayoutParams().height = (int) Math.ceil(height / 2);
                gif.getLayoutParams().width = (int) Math.ceil(height / 2 * 584 / 389);
                gif.requestLayout();
                break;
        }
    }
    public void points(int points, int scale, Context context) {
        //preferences1 = context.getSharedPreferences("preferences1", MODE_PRIVATE);
        //editor = preferences1.edit();
        if (scale == 1) {
            //scale1 = preferences1.getInt("scale1", 1);
            scale1 += points;
            Log.d("scale1", scale1+"");
            if (scale1 > 100) {
                scale1 = 100;
            } else if (scale1 < 0) {
                scale1 = 0;
            }
            //editor.putInt("scale1", scale1);
            progressBar1.setProgress(scale1);
        } else if (scale == 2) {
            //scale2 = preferences1.getInt("scale2", 1);
            scale2 += points;
            if (scale2 > 100) {
                scale2 = 100;
            } else if (scale2 < 0) {
                scale2 = 0;
            }
            //editor.putInt("scale2", scale2);
            progressBar2.setProgress(scale2);
        } else if (scale == 3) {
            //scale3 = preferences1.getInt("scale3", 1);
            scale3 += points;
            if (scale3 > 100) {
                scale3 = 100;
            } else if (scale3 < 0) {
                scale3 = 0;
            }
            //editor.putInt("scale3", scale3);
            progressBar3.setProgress(scale3);
            Log.d("scale3", progressBar3.getProgress()+"");
        }
        //editor.commit();
    }

    public void onChangeScale1() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                preferences = getPreferences(MODE_PRIVATE);
                //scale1 = preferences.getInt("scale1", 1);
                scale1--;
                progressBar1.setProgress(scale1);
                if (scale1 < 0) {
                    scale1 = 0;
                }
                handler.postDelayed(this, timeReduceScale1);
                editor = preferences.edit();
                editor.putInt("scale1", scale1);
                editor.commit();
                //onChangeCondition();
            }
        });
    }
    public void onChangeScale2() {
        final Handler handler1 = new Handler();
        handler1.post(new Runnable() {
            @Override
            public void run() {
                preferences = getPreferences(MODE_PRIVATE);
                scale2 = preferences.getInt("scale2", 1);
                progressBar2.setProgress(scale2);
                //Log.d("scale2", scale2 + "");
                scale2--;
                if (scale2 < 0) {
                    scale2 = 0;
                }
                handler1.postDelayed(this, timeReduceScale2);
                editor = preferences.edit();
                editor.putInt("scale2", scale2);
                editor.commit();
                onChangeCondition();
            }
        });
    }
    public void onChangeScale3() {
        progressBar3.setProgress(scale3);
        if (scale3 < 0) {
            scale3 = 0;
        }
        preferences = getPreferences(MODE_PRIVATE);
        editor = preferences.edit();
        editor.putInt("scale3", scale3);
        editor.commit();
        //onChangeCondition();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE  && resultCode  == RESULT_OK) {
            String name = data.getStringExtra("name");
            TextView name_view = (TextView) findViewById(R.id.set_name);
            name_view.setText(name);
            preferences = getPreferences(MODE_PRIVATE);
            //Log.d("TAG1", preferences.getString("name", ".")+"");
            editor = preferences.edit();
            editor.putString("name", name);
            editor.commit();
            name = preferences.getString("name", "");
            Log.d("name", name);
            Intent intent = new Intent(HomeActivity.this, ViewPagerActivity.class);
            startActivity(intent);
        }
    }
    public void onDie() {
        long finish = Instant.now().toEpochMilli();
        long timeElapsed = (start - finish) / 1000;
        preferences = getPreferences(MODE_PRIVATE);
        editor = preferences.edit();
        if (timeElapsed > bestTime) {
            bestTime = timeElapsed;
            editor.putLong("bestTime", bestTime);
        }
        editor.putBoolean("firstTime", true);
        editor.putInt("scale1", 100);
        editor.putInt("scale2", 100);
        editor.putInt("scale3", 24);
        editor.putInt("currentCondition", 2);
        editor.putString("name", "");
        editor.putInt("timeReduceScale1", timeReduceScale1 - 500);
        editor.putInt("timeReduceScale2", timeReduceScale1 - 1000);
    }

    @Override
    protected void onStop() {
        long exit = Instant.now().toEpochMilli();
        preferences = getPreferences(MODE_PRIVATE);
        editor = preferences.edit();
        editor.putLong("exit", exit);
        editor.commit();
        //exit = preferences.getLong("exit", 1);
        //Log.d("exit", exit +"");
        super.onStop();
    }

}
