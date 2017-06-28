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

    private int textSize;

    private int switchWidth;

    private int switchHeight;

    private int radius;

    private int textColor;

    private int trackColor;

    private int strokeColor;

    private int borderWidth;

    private boolean setMoving;

    public SwitchTrackTextDrawable(@NonNull Context context,
                                   String leftTextString,
                                   String rightTextString, int textSize, int switchWidth, int switchHeight, int borderWidth, int radius, int trackColor, int textColor, int strokeColor) {
        mContext = context;
        mLeftText = leftTextString;
        this.textColor = textColor;
        this.textSize = textSize;
        mTextPaint = createTextPaint();
        mRightText = rightTextString;
        this.switchHeight = switchHeight;
        this.switchWidth = switchWidth;
        this.radius = radius;
        this.trackColor = trackColor;
        this.strokeColor = strokeColor;
        this.borderWidth = borderWidth;
        setMoving = false;
    }

    private Paint createTextPaint() {
        Paint textPaint = new Paint();
        //noinspection deprecation
        textPaint.setColor(textColor);
        textPaint.setAntiAlias(true);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(textSize);
        // Set textSize, typeface, etc, as you wish
        return textPaint;
    }

    private Paint createBackgroundPaint() {
        Paint background = new Paint();
        background.setColor(trackColor);
        background.setAntiAlias(true);
        background.setStyle(Paint.Style.FILL);
        background.setTextAlign(Paint.Align.CENTER);
        return background;
    }

    @Override
    public void draw(Canvas canvas) {
        final Rect textBounds = new Rect();
        RectF rect = new RectF(0, 0, switchWidth, switchHeight);
        mTextPaint.getTextBounds(mRightText, 0, mRightText.length(), textBounds);
        canvas.drawRoundRect(rect, radius, radius, createBackgroundPaint());
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(strokeColor);
        paint.setStrokeWidth(borderWidth);
        canvas.drawRoundRect(rect, radius, radius, paint);
        if(setMoving)
            return;
        final int heightBaseline = canvas.getClipBounds().height() / 2 + textBounds.height() / 2;
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

    public void changeBackground(boolean isMoving) {
        if (isMoving == true) {
            setMoving=true;
            invalidateSelf();
        } else {
            setMoving=false;
            invalidateSelf();
        }
    }
}