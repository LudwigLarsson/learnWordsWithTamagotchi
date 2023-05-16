package com.ludwiglarsson.learnwordswithtamagotchi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.ludwiglarsson.learnwordswithtamagotchi.R;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Dialog dialog = new Dialog(this, android.R.style.Theme_Dialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_start);
        View v = getWindow().getDecorView();
        v.setBackgroundResource(android.R.color.transparent);

        Button b = (Button) findViewById(R.id.send);
        b.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nameView = (EditText) findViewById(R.id.name);
                String nameText = nameView.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("name", nameText);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() { //чтобы пользователь не смог нажать кнопочку "назад" и не сломал мне приложение, хихи
    }
}
