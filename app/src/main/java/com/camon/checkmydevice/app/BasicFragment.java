package com.camon.checkmydevice.app;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

public class BasicFragment extends ListFragment {
    private static String[] buildInfoList = {
            "[RadioVersion] " + Build.getRadioVersion(),
            "[USER] " + Build.USER,
            "[SERIAL] " + Build.SERIAL,
            "[ID] " + Build.ID,
            "[HOST] " + Build.HOST,
            "[HARDWARE] " + Build.HARDWARE,
            "[DISPLAY] " + Build.DISPLAY,
            "[BOARD] " + Build.BOARD,
            "[BOOTLOADER] " + Build.BOOTLOADER,
            "[BRAND] " + Build.BRAND,
            "[CPU_ABI] " + Build.CPU_ABI,
            "[CPU_ABI2] " + Build.CPU_ABI2,
            "[DEVICE]" + Build.DEVICE,
            "[FINGERPRINT] " + Build.FINGERPRINT,
            "[MANUFACTURER] " + Build.MANUFACTURER,
            "[VERSION.SDK_INT] " + Build.VERSION.SDK_INT,
            "[MODEL] " + Build.MODEL,
            "[PRODUCT] " + Build.PRODUCT,
            "[TAGS] " + Build.TAGS,
            "[TYPE] " + Build.TYPE,
            "[TIME] " + Build.TIME,
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // We need to use a different list item layout for devices older than Honeycomb
        int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
                android.R.layout.simple_list_item_activated_1 : android.R.layout.simple_list_item_1;

        // Create an array adapter for the list view, using the Ipsum headlines array
        setListAdapter(new ArrayAdapter<String>(getActivity(), layout, buildInfoList));
    }
}
