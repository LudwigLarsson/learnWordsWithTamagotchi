package com.ludwiglarsson.learnwordswithtamagotchi.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.ludwiglarsson.learnwordswithtamagotchi.R;

public class ResultActivity extends AppCompatActivity {
    HomeActivity homeActivity;

    private SharedPreferences sharedPref;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Dialog dialog = new Dialog(this, android.R.style.Theme_Dialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_result);
        View v = getWindow().getDecorView();
        v.setBackgroundResource(android.R.color.transparent);

        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        Button b = (Button) findViewById(R.id.exit);
        b.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, HomeActivity.class);
                startActivity(intent);
                //finishAffinity();
            }
        });

        Intent i = getIntent();
        int res = i.getIntExtra("result", 1);
        TextView message = (TextView) findViewById(R.id.message);
        if (res == 2) {
            message.setText("Для того, чтобы открыть игру, вы должны пройти не менее пяти слов!");
        } else if (res == 0) {
            homeActivity = new HomeActivity();
            homeActivity.points(-10, 3, getApplicationContext());
            message.setText("Вы проиграли");
        } else if (res == -1) {
            message.setText("К сожалению, слова в этой категории закончились! Вы освоили тему полностью:)");
        } else if (res == -5) {
            message.setText("К сожалению, ваш тамагочи умер");
        } else {
            homeActivity = new HomeActivity();
            homeActivity.points(10, 3, getApplicationContext());
            message.setText("Вы победили!");
        }
    }
    @Override
    public void onBackPressed() {
    }
}