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

    public RootPresenter(Context context) {
        this.servicesImpl = new ServicesImpl(context);
        this.servicesImpl.setOnServicesListener(this);
    }

    public void requestFilms() {
        servicesImpl.getFilms();
    }

    public void setView(IServicesContract.View view) {
        this.view = view;
    }

    @Override
    public void onResponse(ServicesResponse response) {
        view.showResponse(response);
    }

    @Override
    public void onError(ServicesError broxelServicesError) {
        view.showError(broxelServicesError);
    }
}
