package com.geovanni.studioghibli.views.views.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.geovanni.studioghibli.R;
import com.geovanni.studioghibli.views.bussiness.utils.NavigationUtil;

public class SplashScreen extends Activity {

    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);
        initApp();
    }

    public void initApp() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                NavigationUtil.openActivity(SplashScreen.this, MainActivity.class);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}
