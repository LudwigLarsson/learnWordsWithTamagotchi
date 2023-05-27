package com.ludwiglarsson.learnwordswithtamagotchi.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ludwiglarsson.learnwordswithtamagotchi.R;
import com.ludwiglarsson.learnwordswithtamagotchi.data.DataBaseHandler;
import com.ludwiglarsson.learnwordswithtamagotchi.data.Words;

import org.w3c.dom.Text;

public class GuessActivity extends AppCompatActivity {

    int pos = 4;
    String word;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);
        DataBaseHandler bd = new DataBaseHandler(this);
        long rows = bd.tableSize("used");
        if (rows < 5) {
            Intent intent = new Intent(GuessActivity.this, ResultActivity.class);
            intent.putExtra("result", 2);
            startActivity(intent);
        }
        Words words = (Words) bd.getRandomWord("used");
        word = words.getName().toLowerCase();
        String[] hints = words.getHints().split("/");
        TextView setHints = (TextView) findViewById(R.id.hint);
        setHints.setText(hints[pos]);
        Button newHint = (Button) findViewById(R.id.newHint);
        newHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView amount = (TextView)findViewById(R.id.amount1);
                pos--;
                if (pos >= 0) {
                    amount.setText(pos + "");
                    TextView setHints = (TextView) findViewById(R.id.hint);
                    setHints.setText(hints[pos]);
                }
                else if (pos < 0) {
                    newHint.setVisibility(View.GONE);
                    TextView text = (TextView) findViewById(R.id.text);
                    text.setText("Подсказок больше не осталось. Введите отгаданное слово:");
                }
            }
        });
        EditText answer = (EditText) findViewById(R.id.answer);
        answer.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Button newAnswer = (Button) findViewById(R.id.sendans);
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    if (answer.getText().length() == 0) {
                        Toast.makeText(GuessActivity.this, "Слово не может быть пустым", Toast.LENGTH_SHORT);
                    } else {
                        newAnswer.setOnClickListener(new Button.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String nameText = answer.getText().toString().toLowerCase();
                                //Log.d("Tagg", nameText + "=" + word);
                                Intent intent = new Intent(GuessActivity.this, ResultActivity.class);
                                if (nameText.equals(word)) {
                                    intent.putExtra("result", 1);
                                    startActivity(intent);
                                } else {
                                    intent.putExtra("result", 0);
                                    startActivity(intent);
                                }
                            }
                        });
                    }
                    return true;
                }
                return false;
            }
        });
    }
}