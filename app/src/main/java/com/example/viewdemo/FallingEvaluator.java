package com.example.viewdemo;

import android.animation.TypeEvaluator;
import android.graphics.Point;

public class FallingEvaluator implements TypeEvaluator<Point> {
    private Point point=new Point();
    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        point.x= (int) (startValue.x+fraction*(endValue.x-startValue.x));
        if (fraction*2<1){
            point.y= (int) (startValue.y+fraction*(endValue.y-startValue.y));
        }else point.y=endValue.y;

    return  point;
    }
}
