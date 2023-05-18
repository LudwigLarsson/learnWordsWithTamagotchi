package com.ludwiglarsson.learnwordswithtamagotchi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ludwiglarsson.learnwordswithtamagotchi.R;

public class ResultActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Dialog dialog = new Dialog(this, android.R.style.Theme_Dialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_result);
        View v = getWindow().getDecorView();
        v.setBackgroundResource(android.R.color.transparent);

        Intent i = getIntent();
        boolean res = i.getBooleanExtra("result", true);
        TextView message = (TextView) findViewById(R.id.message);
        if (res) {
            message.setText("Вы победили!");
        } else {
            message.setText("Вы проиграли");
        }

        Button b = (Button) findViewById(R.id.exit);
        b.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
    }
}