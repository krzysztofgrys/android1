package com.example.krzysztofgrys.myapplication;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by krzysztofgrys on 3/13/17.
 */

public class Details extends AppCompatActivity {
    ViewPager viewPager;
    MyPagerAdapter pagerAdapter;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        Images images = new Images();
        Intent intent1 = getIntent();
        int position = intent1.getIntExtra("ImgPosition",-1);
        images.setCurrentPos(position);
        viewPager = (ViewPager)findViewById(R.id.pager);
        pagerAdapter = new MyPagerAdapter(this, images);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(position);

        back = (Button) findViewById(R.id.buttonBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
}
