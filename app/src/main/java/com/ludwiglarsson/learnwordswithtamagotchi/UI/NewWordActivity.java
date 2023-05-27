package com.ludwiglarsson.learnwordswithtamagotchi.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ludwiglarsson.learnwordswithtamagotchi.ImageApi;
import com.ludwiglarsson.learnwordswithtamagotchi.ImageLoader;
import com.ludwiglarsson.learnwordswithtamagotchi.R;
import com.ludwiglarsson.learnwordswithtamagotchi.RetrofitClient;
import com.ludwiglarsson.learnwordswithtamagotchi.data.DataBaseHandler;
import com.ludwiglarsson.learnwordswithtamagotchi.data.Words;
import com.makeramen.roundedimageview.RoundedImageView;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewWordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);
        Intent i = getIntent();
        int id = i.getIntExtra("id", 1);
        String category = i.getStringExtra("category");
        DataBaseHandler bd = new DataBaseHandler(this);
        Words word = (Words) bd.getWord(id, category);
        String currName = word.getName();
        String currDescription = word.getDescription();
        /*String imageUrl = "https://raw.githubusercontent.com/LudwigLarsson/images/main/README.md";
        ImageApi imageApi = RetrofitClient.getClient("https://raw.githubusercontent.com/").create(ImageApi.class);

        imageApi.getImage(imageUrl).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                RoundedImageView pic = (RoundedImageView) findViewById(R.id.pic);
                if (response.isSuccessful()) {
                    ImageLoader.loadImage(getApplicationContext(), imageUrl, pic);
                } else {
                    // Обработка ошибки
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                // Обработка ошибки
            }
        });*/
        String currPhoto = word.getPhoto();
        TextView name = (TextView) findViewById(R.id.name);
        TextView description = (TextView) findViewById(R.id.description);
        name.setText(currName);
        description.setText(currDescription);
    }
    //public void onBackPressed() {
    //}
}