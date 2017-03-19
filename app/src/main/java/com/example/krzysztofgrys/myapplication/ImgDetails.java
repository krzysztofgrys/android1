package com.example.krzysztofgrys.myapplication;

/**
 * Created by krzysztofgrys on 3/13/17.
 */
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ImgDetails extends AppCompatActivity {

    Images images = new Images();
    Button buttonBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_details);
        buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
//                overridePendingTransition(R.anim.enter,R.anim.exit);
            }
        });
        Intent intent1 = getIntent();
        int position = intent1.getIntExtra("ImgPosition",-1);
        ImageView iv = (ImageView) findViewById(R.id.imageItemDetails);
        Bitmap bMap = BitmapFactory.decodeResource(getResources(), images.photos()[position]);
        Bitmap bMapScaled = Bitmap.createScaledBitmap(bMap, 3500, 3500, true);

        if(position!=-1){
//            iv.setImageResource(images.photos()[position]);String tmp=""+position;
            iv.setImageBitmap(bMapScaled);

        }else{
            Toast.makeText(this,"Blad obrazka",Toast.LENGTH_SHORT).show();
        }
//        overridePendingTransition(R.anim.enter,R.anim.exit);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        overridePendingTransition(R.anim.enter, R.anim.exit);
    }
}