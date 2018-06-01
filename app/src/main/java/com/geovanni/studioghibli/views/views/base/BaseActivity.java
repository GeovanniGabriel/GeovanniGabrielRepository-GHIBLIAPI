package com.geovanni.studioghibli.views.views.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public class BaseActivity extends AppCompatActivity {

    private String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void initViews() {
        ButterKnife.bind(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 1) {
            finish();
        } else {
            super.onBackPressed();
        }
    }
}
