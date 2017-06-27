package com.pulkit.sdsmdg.custom.switchbar;

import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    Switch mySwitch;
    TextView tvState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomSwitch customSwitch=(CustomSwitch) findViewById(R.id.mySwitch);
        customSwitch.setTrackText(R.string.store,R.string.closet);
        //customSwitch.setThumbDrawable(getResources().getDrawable(R.drawable.customswitchselector));
        customSwitch.setThumbDrawable(addSelector());
        tvState=(TextView)findViewById(R.id.tvState);
        customSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                }
                else {

                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public StateListDrawable addSelector() {
        StateListDrawable res = new StateListDrawable();
        res.addState(new int[]{android.R.attr.state_checked},getResources().getDrawable(R.drawable.customswitchselector));
        res.addState(new int[]{-android.R.attr.state_checked},getResources().getDrawable(R.drawable.customswitchselector));
        return res;
    }
}