package com.camon.checkmydevice.app;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;


public class PixelActivity extends Activity implements View.OnTouchListener{
    static int[] colorList = {
            Color.RED,
            Color.GREEN,
            Color.BLUE,
            Color.YELLOW,
            Color.BLACK,
            Color.WHITE,
    };
    private int currentIndex = 0;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pixel);

        tv = (TextView) findViewById(R.id.text_pixel);
        tv.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Log.i("PixelActivity", "ACTION:" + motionEvent.getAction());
        clearText();
        changeBackgroundColor(view);

        return false;
    }

    private void clearText() {
        String text = tv.getText().toString();
        if (!text.isEmpty()) {
            tv.setText("");
        }
    }

    private void changeBackgroundColor(View view) {
        view.setBackgroundColor(colorList[currentIndex++]);

        if (currentIndex >= colorList.length) {
            currentIndex = 0;
        }
    }
}
