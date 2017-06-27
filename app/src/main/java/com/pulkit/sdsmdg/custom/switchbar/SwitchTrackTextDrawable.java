package com.pulkit.sdsmdg.custom.switchbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.util.Log;

/**
 * Created by pulkit on 27/6/17.
 */

public class SwitchTrackTextDrawable extends Drawable {

    private final Context mContext;

    private final String mLeftText;

    private final String mRightText;

    private final Paint mTextPaint;

    public SwitchTrackTextDrawable(@NonNull Context context,
                                   @StringRes int leftTextId,
                                   @StringRes int rightTextId) {
        mContext = context;

        // Left text
        mLeftText = context.getString(leftTextId);
        mTextPaint = createTextPaint();

        // Right text
        mRightText = context.getString(rightTextId);
    }

    private Paint createTextPaint() {
        Paint textPaint = new Paint();
        //noinspection deprecation
        textPaint.setColor(mContext.getResources().getColor(android.R.color.white));
        textPaint.setAntiAlias(true);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(30);
        // Set textSize, typeface, etc, as you wish
        return textPaint;
    }
    private Paint createBackgroundPaint()
    {
        Paint background = new Paint();
        //noinspection deprecation
        background.setColor(mContext.getResources().getColor(android.R.color.black));
        background.setAntiAlias(true);
        background.setStyle(Paint.Style.FILL);
        background.setTextAlign(Paint.Align.CENTER);
        background.setTextSize(30);
        // Set textSize, typeface, etc, as you wish
        return background;
    }
    @Override
    public void draw(Canvas canvas) {
        final Rect textBounds = new Rect();
        Log.e("base bounds",canvas.getClipBounds()+"");
        RectF rect=new RectF(0,0,400,100);
        mTextPaint.getTextBounds(mRightText, 0, mRightText.length(), textBounds);
        canvas.drawRoundRect(rect,45,45,createBackgroundPaint());
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(3);
        canvas.drawRoundRect(rect,45,45,paint);
        // The baseline for the text: centered, including the height of the text itself
        final int heightBaseline = canvas.getClipBounds().height() / 2 + textBounds.height() / 2;

        // This is one quarter of the full width, to measure the centers of the texts
        final int widthQuarter = canvas.getClipBounds().width() / 4;
        canvas.drawText(mLeftText, 0, mLeftText.length(),
                widthQuarter, heightBaseline,
                mTextPaint);
        canvas.drawText(mRightText, 0, mRightText.length(),
                widthQuarter * 3, heightBaseline,
                mTextPaint);
    }

    @Override
    public void setAlpha(int alpha) {
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}