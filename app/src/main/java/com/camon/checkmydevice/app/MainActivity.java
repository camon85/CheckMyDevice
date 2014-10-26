package com.camon.checkmydevice.app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends FragmentActivity implements CheckListFragment.OnCheckListSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            return;
        }

        showCheckListFragment();
    }

    private void showCheckListFragment() {
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
    public void onCheckItemSelected(int position) {
        // The user selected the headline of an article from the HeadlinesFragment

        if (position == 0) { // Basic Device Infomation
            BasicFragment newFragment = new BasicFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        } else if (position == 1) { // Pixels Check
            Intent intent = new Intent(this, PixelActivity.class);
            startActivity(intent);
        } else if (position == 2) { // Multi Touch
            Intent intent = new Intent(this, MultiTouchActivity.class);
            startActivity(intent);
        } else if (position == 3) { // Sensor
            Intent intent = new Intent(this, SensorTestActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the main; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (R.id.action_dev_info == id) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("개발자 소개");
            builder.setView(getLayoutInflater().inflate(R.layout.dev_info, null));
            builder.setNegativeButton("닫기", null).show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (isCheckListFragment()) {
            showExitConfirmDialog();
        } else {
            super.onBackPressed();
        }
    }

    private void showExitConfirmDialog() {
        String appName = getResources().getString(R.string.app_name);
        String msg = getResources().getString(R.string.msg_back);
        String btnYes = getResources().getString(R.string.btn_yes);
        String btnNo = getResources().getString(R.string.btn_no);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(appName);
        builder.setMessage(msg);
        builder.setNegativeButton(btnNo, null);
        builder.setPositiveButton(btnYes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                moveTaskToBack(true);
                finish();
            }
        }).show();
    }

    private boolean isCheckListFragment() {
        Class currentFragmentClass = getSupportFragmentManager().findFragmentById(R.id.fragment_container).getClass();

        return CheckListFragment.class == currentFragmentClass;
    }
}
