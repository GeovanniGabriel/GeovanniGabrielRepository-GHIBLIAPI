package com.geovanni.studioghibli.views.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.geovanni.studioghibli.R;
import com.geovanni.studioghibli.views.bussiness.interfaces.IServicesContract;
import com.geovanni.studioghibli.views.bussiness.presenters.RootPresenter;
import com.geovanni.studioghibli.views.bussiness.utils.ServicesError;
import com.geovanni.studioghibli.views.bussiness.utils.ServicesResponse;
import com.geovanni.studioghibli.views.views.base.BaseFragment;

public class FilmsFragment extends BaseFragment implements IServicesContract.View {

    public static final String TAG = FilmsFragment.class.getSimpleName();
    private RootPresenter rootPresenter;

    public static FilmsFragment newInstance() {
        FilmsFragment fragment = new FilmsFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rootPresenter = new RootPresenter(getContext());
        rootPresenter.setView(this);
        rootPresenter.requestFilms();
    }


    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_films;
    }

    @Override
    public void showResponse(ServicesResponse response) {
    }

    @Override
    public void showError(ServicesError broxelServicesError) {
    }
}
