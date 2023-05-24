package com.ludwiglarsson.learnwordswithtamagotchi.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ludwiglarsson.learnwordswithtamagotchi.R;
import com.ludwiglarsson.learnwordswithtamagotchi.ViewPager2Adapter;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

public class ViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        ViewPager2 viewPager2 = (ViewPager2) findViewById(R.id.viewpager2);
        viewPager2.setAdapter(new ViewPager2Adapter(this));
        DotsIndicator dotsIndicator = (DotsIndicator) findViewById(R.id.dots_indicator2);
        dotsIndicator.attachTo(viewPager2);
        Button b = (Button) findViewById(R.id.homebtn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewPagerActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}