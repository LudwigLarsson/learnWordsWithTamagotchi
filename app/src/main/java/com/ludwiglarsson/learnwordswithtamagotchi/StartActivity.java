package com.ludwiglarsson.learnwordswithtamagotchi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.content.pm.ActivityInfo;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }
    public void onSendName(View view) {
        EditText nameView = (EditText)findViewById(R.id.name);
        String nameText = nameView.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("name", nameText);
        setResult(RESULT_OK, intent);
        finish();
    }
}