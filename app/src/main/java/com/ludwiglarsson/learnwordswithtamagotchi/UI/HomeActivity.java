package com.ludwiglarsson.learnwordswithtamagotchi.UI;

import androidx.appcompat.app.AppCompatActivity;

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

import pl.droidsonroids.gif.GifImageView;


public class HomeActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 1;
    protected String name = "///";
    protected int currentCondition = 2;
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
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView name_view = (TextView) findViewById(R.id.set_name);
        TextView time_view = (TextView) findViewById(R.id.time_view);
        preferences = getPreferences(MODE_PRIVATE);
        firstTime = preferences.getBoolean("firstTime", true);
        name = preferences.getString("name", "");
        currentTime = preferences.getLong("currentTime", 1);
        time_view.setText(String.format("%02d:%02d:%02d:%02d", currentTime / 86400000,
                (currentTime % 86400000) / 3600000, ((currentTime % 86400000) % 3600000) / 60000, (((currentTime % 86400000) % 3600000) % 60000) / 1000));
        runTimer();
        name_view.setText(name);
        if (firstTime) {
            Intent intent = new Intent(HomeActivity.this, StartActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
            Intent intent1 = new Intent(HomeActivity.this, ViewPagerActivity.class);
            startActivity(intent1);
            firstTime = false;
            preferences = getPreferences(MODE_PRIVATE);
            editor = preferences.edit();
            editor.putBoolean("firstTime", firstTime);
            editor.commit();
        }
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(getResources().getColor(R.color.background));
        setPhotos();
        onChangeScale1();
        onChangeScale2();
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

        DataBaseHandler dataBaseHandler = new DataBaseHandler(HomeActivity.this);
        Dictionary dict = new Dictionary();
        dict.words(dataBaseHandler);
    }

    private void runTimer() {
        final TextView timeView = (TextView)findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                currentTime = SystemClock.elapsedRealtime();;
                timeView.setText(String.format("%02d:%02d:%02d:%02d", currentTime / 86400000,
                        (currentTime % 86400000) / 3600000, ((currentTime % 86400000) % 3600000) / 60000, (((currentTime % 86400000) % 3600000) % 60000) / 1000));
                preferences = getPreferences(MODE_PRIVATE);
                editor = preferences.edit();
                editor.putLong("currentTime", currentTime);
                editor.commit();
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
    public void setPhotos() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        ImageView back = (ImageView) findViewById(R.id.back);
        back.getLayoutParams().width = (int) Math.ceil(height * 16 / 9);
        back.requestLayout();

        GifImageView gif = (GifImageView) findViewById(R.id.gif);
        gif.setImageResource(R.drawable.neutral);
        gif.getLayoutParams().height = (int) Math.ceil(height / 2);
        gif.getLayoutParams().width = (int) Math.ceil(height / 2 * 584 / 389);
        gif.requestLayout();

        GifImageView space = (GifImageView) findViewById(R.id.space);
        space.getLayoutParams().height = (int) Math.ceil((width - height * 16 / 9) + (height * 16 / 9 * 80 / 590) / 1.5 * 388 / 215);
        space.getLayoutParams().width = (int) Math.ceil((width - height * 16 / 9) + (height * 16 / 9 * 80 / 590) / 1.5);
        space.requestLayout();

        ImageView table = (ImageView) findViewById(R.id.table);
        table.getLayoutParams().height = (int) Math.ceil(width / 2 * 520 / 924);
        table.getLayoutParams().width = (int) Math.ceil(width / 2);
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
    public void onChangePhotos() {
        GifImageView gif = (GifImageView) findViewById(R.id.gif);
        if (currentCondition == 2) {
            //gif.setImageResource(R.drawable.neutral);
        } else if (currentCondition == 1) {
            //gif.setImageResource(R.drawable.neutral);
        } else if (currentCondition == 3) {
            //gif.setImageResource(R.drawable.neutral);
        } else if (currentCondition == 4) {
            //gif.setImageResource(R.drawable.neutral);
        } else if (currentCondition == 5) {
            //gif.setImageResource(R.drawable.neutral);
        }
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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE  && resultCode  == RESULT_OK) {
            String name = data.getStringExtra("name");
            TextView name_view = (TextView) findViewById(R.id.set_name);
            name_view.setText(name);
            preferences = getPreferences(MODE_PRIVATE);
            Log.d("TAG1", preferences.getString("name", ".")+"");
            editor = preferences.edit();
            editor.putString("name", name);
            editor.commit();
        }
    }
    public void getPoints1() {}
    public void getPoints2() {}
    public void getPoints3() {}
    public void onChangeCondition() {
    }
    public void onDie() {}

}
