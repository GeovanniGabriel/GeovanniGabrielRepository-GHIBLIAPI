package com.geovanni.studioghibli.views.bussiness.productsApi;

import android.content.Context;

import com.geovanni.studioghibli.views.bussiness.interfaces.IServiceListener;
import com.geovanni.studioghibli.views.bussiness.interfaces.IServicesContract;
import com.geovanni.studioghibli.views.bussiness.presenters.RootPresenter;
import com.geovanni.studioghibli.views.bussiness.utils.ServicesError;
import com.geovanni.studioghibli.views.bussiness.utils.ServicesResponse;

public class ServicesGhibliApi implements IServicesContract.View {

    private static ServicesGhibliApi instance = null;
    private IServiceListener iServiceListener;
    private RootPresenter rootPresenter;

    public ServicesGhibliApi(Context context) {
        rootPresenter = new RootPresenter(context, this);
    }

    public void getFilms(IServiceListener iServiceListener) {
        setOnServicesListener(iServiceListener);
        rootPresenter.requestFilms();
    }

    public void setOnServicesListener(IServiceListener iServiceListener) {
        this.iServiceListener = iServiceListener;
    }


    @Override
    public void showResponse(ServicesResponse response) {
    }

    @Override
    public void showError(ServicesError servicesError) {
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
