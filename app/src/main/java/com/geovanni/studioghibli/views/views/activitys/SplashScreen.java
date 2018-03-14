package com.geovanni.studioghibli.views.views.activitys;

import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.geovanni.studioghibli.R;
import com.geovanni.studioghibli.views.bussiness.utils.NavigationUtil;
import com.geovanni.studioghibli.views.views.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by gabri
 */

public class SplashScreen extends BaseActivity {

    private static int SPLASH_TIME_OUT = 4000;

    @BindView(R.id.lavsome)
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);
        initViews();
        initApp();
    }

    public void initApp() {

        lottieAnimationView.setAnimation("jump_loader.json");
        lottieAnimationView.setRepeatCount(LottieDrawable.INFINITE);
        lottieAnimationView.setRepeatMode(LottieDrawable.INFINITE);
        lottieAnimationView.playAnimation();

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
