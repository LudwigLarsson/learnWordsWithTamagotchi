package com.ludwiglarsson.learnwordswithtamagotchi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.content.pm.ActivityInfo;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;


public class HomeActivity extends AppCompatActivity {
    protected boolean firstTime = true;
    protected long currentTime = 0;
    protected long bestTime = 0;
    protected int scale1 = 100;
    protected int scale2 = 100;
    protected int scale3 = 100;
    protected int timeReduceScale1 = 216000;
    protected int timeReduceScale2 = 432000;
    protected final long condition1 = 225;
    protected final long condition2 = 150;
    protected final long condition3 = 75;
    protected final long condition4 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if (savedInstanceState != null) {
            currentTime = savedInstanceState.getLong("currentTime");
            bestTime = savedInstanceState.getLong("bestTime");
            firstTime = savedInstanceState.getBoolean("firstTime");
            scale1 = savedInstanceState.getInt("scale1");
            scale2 = savedInstanceState.getInt("scale2");
            scale3 = savedInstanceState.getInt("scale3");
            timeReduceScale1 = savedInstanceState.getInt("timeReduceScale1");
            timeReduceScale2 = savedInstanceState.getInt("timeReduceScale2");
        }
        if (firstTime) {
            Intent intent = new Intent(HomeActivity.this, StartActivity.class);
            startActivity(intent);
            firstTime = false;
            runTimer(); //перенести в onActivityResult
            onChangeScale1();
            onChangeScale2();
        }
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(getResources().getColor(R.color.background));
        onChangePhotos();
        runTimer(); //перенести в onActivityResult
        onChangeScale1();
        onChangeScale2();
        /*DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        TextView booktv = (TextView) findViewById(R.id.booktv);
        booktv.getLayoutParams().= (int) Math.ceil(height * 16 / 9);
        booktv.requestLayout();*/
        ImageView book = findViewById(R.id.book);
        ImageView Regal = findViewById(R.id.Regal);
        GifImageView space = (GifImageView) findViewById(R.id.space);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CategoryListActivity.class);
                startActivity(intent);
            }
        });
        Regal.setOnClickListener(new View.OnClickListener() {
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


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putLong("currentTime", currentTime);
        savedInstanceState.putLong("bestTime", bestTime);
        savedInstanceState.putBoolean("firstTime", firstTime);
        savedInstanceState.putInt("scale1", scale1);
        savedInstanceState.putInt("scale2", scale2);
        savedInstanceState.putInt("scale3", scale3);
        savedInstanceState.putInt("timeReduceScale1", timeReduceScale1);
        savedInstanceState.putInt("timeReduceScale2", timeReduceScale2);
    }
    private void runTimer() {
        final TextView timeView = (TextView)findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                long days = currentTime / 86400;
                long hours = currentTime / 3600;
                long minutes = (currentTime % 3600) / 60;
                long seconds = currentTime % 60;
                String time = String.format("%02d:%02d:%02d:%02d", days,
                        hours, minutes, seconds);
                timeView.setText(time);
                currentTime++;
                handler.postDelayed(this, 1000);
            }
        });
    }
    public void onChangeScale1() {
        ProgressBar progressBar1 = (ProgressBar)findViewById(R.id.progressBar1);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                progressBar1.setProgress(scale1);
                scale1--;
                handler.postDelayed(this, timeReduceScale1);
            }
        });
    }
    public void onChangePhotos() {
        GifImageView gif = (GifImageView) findViewById(R.id.gif);
        gif.setImageResource(R.drawable.sad22);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        gif.getLayoutParams().width = (int) Math.ceil(height * 16 / 9);
        gif.requestLayout();
    }
    public void onChangeScale2() {
        ProgressBar progressBar2 = (ProgressBar)findViewById(R.id.progressBar2);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                progressBar2.setProgress(scale2);
                scale2--;
                handler.postDelayed(this, timeReduceScale2);
            }
        });
    }
    public void onChangeScale3() {
        ProgressBar progressBar3 = (ProgressBar)findViewById(R.id.progressBar3);
        progressBar3.setProgress(scale3);
    }
    public void getPoints1() {}
    public void getPoints2() {}
    public void getPoints3() {}
    public void onChangeCondition() {
    }
    public void onDie() {}
}

/*
        1. @Override
        protected void ActivityResultContract(int requestCode, int resultCode, Intent data) {
            if (data == null) {
                return;
            }
            String name = data.getStringExtra("name");
            public static final NAME = name;
        }
        2. Как поместить переменную в строковый ресурс?
        String msg = getResources().getString(R.string.home, NAME);
        3. Когда пытаюсь убрать панель действий, приложение вылетает
        android:theme="@android:style/Theme.Holo.NoActionBar.Fullscreen" >
        View decorView = getWindow().getDecorView();
        */