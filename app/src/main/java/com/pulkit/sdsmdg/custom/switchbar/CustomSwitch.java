package com.pulkit.sdsmdg.custom.switchbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by pulkit on 27/6/17.
 */

public class CustomSwitch extends Switch {
    private Context mContext;
    public static String SMALL = "small";
    public static String LARGE = "large";
    private String type = SMALL;
    public String leftString = "ST0RE";
    public String rightString = "CLOSET";
    public int borderColor = Color.WHITE;
    public int trackColor = Color.BLACK;
    public int thumbColor = Color.WHITE;
    public int borderWidth = 2;
    public int trackTextColor = Color.WHITE;
    private SwitchTrackTextDrawable switchTrackTextDrawable;
    public CustomSwitch(Context context) {
        super(context);
    }

    public CustomSwitch(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.CustomSwitch);
        if (a.getString(R.styleable.CustomSwitch_size) != null)
            type = a.getString(R.styleable.CustomSwitch_size);
        if (a.getString(R.styleable.CustomSwitch_leftTrackText) != null)
            leftString = a.getString(R.styleable.CustomSwitch_leftTrackText);
        if (a.getString(R.styleable.CustomSwitch_rightTrackText) != null)
            rightString = a.getString(R.styleable.CustomSwitch_rightTrackText);
        if (a.getString(R.styleable.CustomSwitch_borderColor) != null)
            borderColor = Color.parseColor(a.getString(R.styleable.CustomSwitch_borderColor));
        if (a.getString(R.styleable.CustomSwitch_trackColor) != null)
            trackColor = Color.parseColor(a.getString(R.styleable.CustomSwitch_trackColor));
        if (a.getString(R.styleable.CustomSwitch_thumbColor) != null)
            thumbColor = Color.parseColor(a.getString(R.styleable.CustomSwitch_thumbColor));
        if (a.getString(R.styleable.CustomSwitch_borderWidth) != null)
            borderWidth = Color.parseColor(a.getString(R.styleable.CustomSwitch_borderWidth));
        if (a.getString(R.styleable.CustomSwitch_trackTextColor) != null)
            trackTextColor = Color.parseColor(a.getString(R.styleable.CustomSwitch_trackTextColor));
        a.recycle();
        setSwitch();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomSwitch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomSwitch(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setSwitch() {
        if (type.equals(LARGE)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                switchTrackTextDrawable=new SwitchTrackTextDrawable(mContext, leftString, rightString, 30, 400, 100, borderWidth, 50, trackColor, trackTextColor, borderColor);
                this.setTrackDrawable(switchTrackTextDrawable);
            }
            this.setThumbDrawable(addSelector(LARGE));
        } else if (type.equals(SMALL)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                switchTrackTextDrawable=new SwitchTrackTextDrawable(mContext, leftString, rightString, 23, 300, 50, borderWidth, 25, trackColor, trackTextColor, borderColor);
                this.setTrackDrawable(switchTrackTextDrawable);
            }
            this.setThumbDrawable(addSelector(SMALL));
        }
        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    changeBackground(true);
                }else
                {
                    changeBackground(false);
                }
                return false;
            }
        });

    }

    public StateListDrawable addSelector(String type) {
        StateListDrawable res = new StateListDrawable();
        if (type.equals(LARGE)) {
            this.setSwitchTextAppearance(mContext,R.style.LargeText);
            res.addState(new int[]{android.R.attr.state_checked}, getResources().getDrawable(R.drawable.large_switch));
            res.addState(new int[]{-android.R.attr.state_checked}, getResources().getDrawable(R.drawable.large_switch));
        } else if (type.equals(SMALL)) {
            this.setSwitchTextAppearance(mContext,R.style.SmallText);
            res.addState(new int[]{android.R.attr.state_checked}, getResources().getDrawable(R.drawable.small_switch));
            res.addState(new int[]{-android.R.attr.state_checked}, getResources().getDrawable(R.drawable.small_switch));
        }
        return res;
    }
    public void changeBackground(boolean isMoving)
    {
            switchTrackTextDrawable.changeBackground(isMoving);
    }
}
