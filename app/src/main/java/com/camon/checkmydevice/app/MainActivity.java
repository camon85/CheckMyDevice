package com.camon.checkmydevice.app;

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

        if (position == 0) {
            BasicFragment newFragment = new BasicFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        } else if (position == 1) {
            PixelsFragment newFragment = new PixelsFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }

    }
}
