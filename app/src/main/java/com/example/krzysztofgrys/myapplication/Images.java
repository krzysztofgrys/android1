package com.example.krzysztofgrys.myapplication;

/**
 * Created by krzysztofgrys on 3/13/17.
 */

public class Images {
    private  Integer[] photosId = {R.drawable.p1,R.drawable.p2,R.drawable.p3,
            R.drawable.p4,R.drawable.p5,R.drawable.p6,R.drawable.p7,R.drawable.p8,
            R.drawable.p9,R.drawable.p10,R.drawable.p11,R.drawable.p12};
    private int currentPos = 0;

    Integer[] photos(){
        return  photosId;
    }

    int getCurrentPos(){
        return currentPos;
    }

    void setCurrentPos(int currentPos){
        this.currentPos = currentPos;
    }

}
