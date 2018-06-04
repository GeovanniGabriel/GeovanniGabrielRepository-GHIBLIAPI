package com.geovanni.studioghibli.views.bussiness.presenters;

import android.content.Context;

import com.geovanni.studioghibli.views.bussiness.controller.ServicesImpl;
import com.geovanni.studioghibli.views.bussiness.interfaces.IServiceListener;
import com.geovanni.studioghibli.views.bussiness.interfaces.IServicesContract;
import com.geovanni.studioghibli.views.bussiness.utils.ServicesError;
import com.geovanni.studioghibli.views.bussiness.utils.ServicesResponse;

public class RootPresenter implements IServiceListener {

    private ServicesImpl servicesImpl;
    private IServicesContract.View view;

    public RootPresenter(Context context, IServicesContract.View view) {
        this.servicesImpl = new ServicesImpl(context);
        this.servicesImpl.setOnServicesListener(this);
        this.view = view;
    }

    public void requestFilms() {
        view.showProgress();
        servicesImpl.getFilms();
    }

    @Override
    public void onResponse(ServicesResponse response) {
        view.hideProgress();
        view.showResponse(response);
    }

    @Override
    public void onError(ServicesError broxelServicesError) {
        view.hideProgress();
        view.showError(broxelServicesError);
    }
}
