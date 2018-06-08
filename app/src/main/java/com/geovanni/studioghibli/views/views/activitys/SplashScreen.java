package com.geovanni.studioghibli.views.views.activitys;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.geovanni.studioghibli.R;
import com.geovanni.studioghibli.views.bussiness.interfaces.IServicesContract;
import com.geovanni.studioghibli.views.bussiness.models.ServiceImagesResponse;
import com.geovanni.studioghibli.views.bussiness.presenters.RootPresenter;
import com.geovanni.studioghibli.views.bussiness.utils.NavigationUtil;
import com.geovanni.studioghibli.views.bussiness.utils.ServicesError;
import com.geovanni.studioghibli.views.bussiness.utils.ServicesResponse;
import com.geovanni.studioghibli.views.customViews.ProgressLayout;
import com.geovanni.studioghibli.views.entityDao.roomDataBase.ImagesRoomDatabase;
import com.geovanni.studioghibli.views.entityDao.roomDataBase.ManagerDbAsync;
import com.geovanni.studioghibli.views.views.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import butterknife.BindView;

public class SplashScreen extends BaseActivity implements IServicesContract.View {

    private RootPresenter rootPresenter;
    private List<ServiceImagesResponse> images;
    private static int SPLASH_TIME_OUT = 3000;

    @BindView(R.id.plLoading)
    ProgressLayout progressLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        rootPresenter = new RootPresenter(this, this);
        images = new ArrayList<>();
        setContentView(R.layout.activity_splash_screen);
        initViews();
    }

    @Override
    protected void initViews() {
        super.initViews();
        initApp();
    }

    public void initApp() {

        try {
            images = new ManagerDbAsync.GetImagesFromDbAsync(ImagesRoomDatabase.getDatabase(this)).execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if (images != null && images.size() == 0) {
            rootPresenter.requestImagesToFilms();
        } else {
            hideProgress();
            navigateToMainActivity();
        }


    }

    private void navigateToMainActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                NavigationUtil.openActivity(SplashScreen.this, MainActivity.class);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    @Override
    public void showResponse(ServicesResponse response) {
        try {
            List<ServiceImagesResponse> listResponse = (List<ServiceImagesResponse>) response.getResponse();
            new ManagerDbAsync.InsertImagesToDbAsync(ImagesRoomDatabase.getDatabase(this), listResponse).execute();
        } catch (Exception e) {
            navigateToMainActivity();
        }
        navigateToMainActivity();

    }

    @Override
    public void showError(ServicesError broxelServicesError) {
        navigateToMainActivity();
    }

    @Override
    public void showProgress() {
        progressLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressLayout.setVisibility(View.GONE);
    }
}
