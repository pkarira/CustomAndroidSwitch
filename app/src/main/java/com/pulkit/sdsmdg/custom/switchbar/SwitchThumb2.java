package com.pulkit.sdsmdg.custom.switchbar;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;

/**
 * Created by pulkit on 27/6/17.
 */

public class SwitchThumb2 extends Drawable {
    @Override
    public void draw(Canvas canvas) {
        Log.e("bounds",canvas.getClipBounds()+"");
        Log.e("height1",canvas.getHeight()+"");
        Log.e("width1",canvas.getWidth()+"");
        RectF rect=new RectF(0,0,200,100);
        Paint background = new Paint();
        //noinspection deprecation
        background.setColor(Color.WHITE);
        background.setAntiAlias(true);
        background.setStyle(Paint.Style.FILL);
        background.setTextAlign(Paint.Align.CENTER);
        canvas.drawRoundRect(rect,45,45,background);
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
