package com.example.krzysztofgrys.myapplication;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by krzysztofgrys on 3/13/17.
 */

public class MyPagerAdapter extends PagerAdapter {

    Images images;
    Boolean positionChanged = false;
    Boolean afterChange = false;
    Context mContext;
    LayoutInflater mLayoutInflater;

    public MyPagerAdapter(Context context, Images image) {
        mContext = context;
        this.images = image;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return images.photos().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.swpie, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.image_view);
        imageView.getLayoutParams().height = 1324;
        imageView.getLayoutParams().width = 1470;
        System.out.println(position);
        imageView.setImageResource(images.photos()[position]);
        System.out.println(positionChanged);
        positionChanged = true;
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}