package com.camon.checkmydevice.app;

import android.app.Activity;
import android.os.Bundle;

public class MultiTouchActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(new MultiTouchCustomView(this));
    }
}
