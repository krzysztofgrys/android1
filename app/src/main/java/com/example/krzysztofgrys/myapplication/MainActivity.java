package com.example.krzysztofgrys.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * Created by krzysztofgrys on 3/13/17.
 */

public class MainActivity extends AppCompatActivity {

    private GridView gw;
    private GridViewAdapter gwA;
    Images images = new Images();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gw = (GridView) findViewById(R.id.grid);
        gwA = new GridViewAdapter(this, images.photos());
        gw.setAdapter(gwA);
        gw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1 = new Intent(parent.getContext(), Details.class);
                intent1.putExtra("ImgPosition", position);
                images.setCurrentPos(position);
                int[] intArray = new int[images.photos().length];
                for (int i = 0; i < images.photos().length; i++) {
                    intArray[i] = images.photos()[i];
                }
                intent1.putExtra("photosId", intArray);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                startActivity(new Intent(intent1));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

            }
        });
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
}
