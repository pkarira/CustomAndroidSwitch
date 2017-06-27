package com.pulkit.sdsmdg.custom.switchbar;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by pulkit on 27/6/17.
 */

public class CustomSwitch extends Switch {
    Context mContext;
    public CustomSwitch(Context context) {
        super(context);
        mContext=context;
    }
    public CustomSwitch(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext=context;

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomSwitch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr, 0);
        mContext=context;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomSwitch(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mContext=context;
    }
    public void setTrackText(int leftString,int rightString)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            this.setTrackDrawable(new SwitchTrackTextDrawable(mContext, leftString, rightString));
        }
    }
}
