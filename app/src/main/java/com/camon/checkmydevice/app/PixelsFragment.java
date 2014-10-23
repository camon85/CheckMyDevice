package com.camon.checkmydevice.app;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Administrator on 2014-10-22.
 */
public class PixelsFragment extends Fragment implements View.OnTouchListener {

    static int[] colorList = {
            Color.RED,
            Color.GREEN,
            Color.BLUE,
            Color.YELLOW,
            Color.BLACK,
            Color.WHITE,
    };
    private TextView tv;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pixels_check, container, false);
        tv = (TextView) view.findViewById(R.id.text_pixel);
        view.setOnTouchListener(this);

        return view;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Log.i("PixelsFragment", "ACTION:" + motionEvent.getAction());
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
        Random rd = new Random();
        int selectedIndex = rd.nextInt(colorList.length);
        view.setBackgroundColor(colorList[selectedIndex]);
    }
}
