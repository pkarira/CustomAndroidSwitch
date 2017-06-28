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

    private int mHeight;

    private int mWidth;

    private int cornerRadius;

    private int textSize;

    public SwitchTrackTextDrawable(@NonNull Context context,
                                   @StringRes int leftTextId,
                                   @StringRes int rightTextId, int mHeight, int mWidth,int textSize,int radius) {
        mContext = context;
        mLeftText = context.getString(leftTextId);
        mTextPaint = createTextPaint();
        mRightText = context.getString(rightTextId);
        this.mHeight = mHeight;
        this.mWidth = mWidth;
        cornerRadius=radius;
        this.textSize=textSize;
    }

    private Paint createTextPaint() {
        Paint textPaint = new Paint();
        textPaint.setColor(mContext.getResources().getColor(android.R.color.white));
        textPaint.setAntiAlias(true);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(30);
        return textPaint;
    }

    private Paint createBackgroundPaint() {
        Paint background = new Paint();
        background.setColor(mContext.getResources().getColor(android.R.color.black));
        background.setAntiAlias(true);
        background.setStyle(Paint.Style.FILL);
        background.setTextAlign(Paint.Align.CENTER);
        background.setTextSize(30);
        return background;
    }

    @Override
    public void draw(Canvas canvas) {
        final Rect textBounds = new Rect();
        Log.e("base bounds", canvas.getClipBounds() + "");
        Log.e("height", canvas.getHeight() + "");
        Log.e("width", canvas.getWidth() + "");
        RectF rect = new RectF(0, 0, 400, 100);
        mTextPaint.getTextBounds(mRightText, 0, mRightText.length(), textBounds);
        canvas.drawRoundRect(rect,50 , 50, createBackgroundPaint());
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(3);
        canvas.drawRoundRect(rect, 50,50, paint);
        final int heightBaseline = canvas.getClipBounds().height() / 2 + textBounds.height() / 2;
        final int widthQuarter = canvas.getClipBounds().width() / 4;
        canvas.drawText(mLeftText, 0, mLeftText.length(),
                widthQuarter, heightBaseline,
                mTextPaint);
        canvas.drawText(mRightText, 0, mRightText.length(),
                widthQuarter * 3, heightBaseline,
                mTextPaint);
        canvas.save();

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