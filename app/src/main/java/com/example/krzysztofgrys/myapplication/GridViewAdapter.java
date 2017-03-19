package com.example.krzysztofgrys.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by krzysztofgrys on 3/13/17.
 */

public class GridViewAdapter extends BaseAdapter {
    private Context ctx;
    private int resource;
    private ArrayList data;
    private  Integer[] photosId;

    public GridViewAdapter(Context c, Integer[] phid) {
        this.ctx = c;
        this.photosId=phid;
    }
    @Override
    public int getCount() {
        return photosId.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return photosId[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView iv;
        if(convertView==null){
            iv = new ImageView(ctx);
        }else{
            iv = (ImageView) convertView;
        }
        iv.setImageResource(photosId[position]);
        iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(560, 560));

        iv.setLayoutParams(lp);
        return iv;
    }

}
