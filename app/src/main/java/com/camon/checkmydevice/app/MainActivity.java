package com.camon.checkmydevice.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;


public class MainActivity extends FragmentActivity implements View.OnClickListener, CheckListFragment.OnCheckListSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            return;
        }

        // Create an instance of ExampleFragment
        CheckListFragment checkListFragment = new CheckListFragment();

        // In case this activity was started with special instructions from an Intent,
        // pass the Intent's extras to the fragment as arguments
        checkListFragment.setArguments(getIntent().getExtras());

        // Add the fragment to the 'fragment_container' FrameLayout
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, checkListFragment).commit();

    }


    @Override
    public void onClick(View view) {

    }

    @Override
    public void onCheckItemSelected(int position) {
        // The user selected the headline of an article from the HeadlinesFragment

        if (position == 0) { // Basic Device Infomation
            BasicFragment newFragment = new BasicFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        } else if (position == 1) { // Pixels Check
            // TODO fragment는 notitle, fullscreen이 안되는듯
            // activity를 사용하도록 수정해야 한다... ㅠㅠ

    /*        requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
//            setContentView(R.layout.main);


            PixelsFragment newFragment = new PixelsFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        } else if (position == 2) { // Multi Touch
            Intent intent = new Intent(this, MultiTouchActivity.class);
            startActivity(intent);
        } else if (position == 3) { // Sensor

        }

    }
}
