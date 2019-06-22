package com.example.viewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.v4.widget.ImageViewCompat;
import android.util.AttributeSet;
import android.widget.ImageView;

public class fallingBallImageView extends android.support.v7.widget.AppCompatImageView {


    public fallingBallImageView(Context context) {
        super(context);
    }

    public fallingBallImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public fallingBallImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public  void setFallingPos (Point point){
        layout(point.x,point.y,point.x+getWidth(),point.y+getHeight());
}

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        paint.setColor(Color.BLUE);
    canvas.drawCircle(getWidth()/2,getHeight()/2,getHeight()/2,paint);

    }
}

