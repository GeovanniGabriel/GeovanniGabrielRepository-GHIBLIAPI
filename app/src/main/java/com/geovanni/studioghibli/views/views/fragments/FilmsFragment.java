package com.geovanni.studioghibli.views.views.fragments;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.geovanni.studioghibli.R;
import com.geovanni.studioghibli.views.bussiness.interfaces.IProgressLayout;
import com.geovanni.studioghibli.views.bussiness.interfaces.IServicesContract;
import com.geovanni.studioghibli.views.bussiness.models.ServiceFilmResponse;
import com.geovanni.studioghibli.views.bussiness.models.ServiceImagesResponse;
import com.geovanni.studioghibli.views.bussiness.presenters.RootPresenter;
import com.geovanni.studioghibli.views.bussiness.utils.ServicesError;
import com.geovanni.studioghibli.views.bussiness.utils.ServicesResponse;
import com.geovanni.studioghibli.views.entityDao.roomDataBase.FilmsRoomDatabase;
import com.geovanni.studioghibli.views.entityDao.roomDataBase.ImagesRoomDatabase;
import com.geovanni.studioghibli.views.entityDao.roomDataBase.ManagerDbAsync;
import com.geovanni.studioghibli.views.views.adapters.FilmsAdapter;
import com.geovanni.studioghibli.views.views.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import butterknife.BindView;

public class FilmsFragment extends BaseFragment implements IServicesContract.View {

    public static final String TAG = FilmsFragment.class.getSimpleName();
    private RootPresenter rootPresenter;
    private FilmsAdapter filmsAdapter;
    private List<ServiceFilmResponse> films;
    private List<ServiceImagesResponse> images;
    private IProgressLayout iProgressLayout;
    private Typeface lightGhibli, boldGhibli;

    @BindView(R.id.rvGeneralData)
    RecyclerView rvFilms;

    public static FilmsFragment newInstance() {
        FilmsFragment fragment = new FilmsFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = null;
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
        iProgressLayout = (IProgressLayout) activity;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rootPresenter = new RootPresenter(getContext(), this);
        films = new ArrayList<>();
        images = new ArrayList<>();
        filmsAdapter = new FilmsAdapter(getContext());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        showProgress();
        setupRecyclerView();
        showToolbarDefaultMode();

        lightGhibli = Typeface.createFromAsset(getContext().getAssets(), "fonts/ghibli.ttf");
        boldGhibli = Typeface.createFromAsset(getContext().getAssets(), "fonts/ghibli_bold.ttf");

        try {
            films = new ManagerDbAsync.GetAllDataFromDbAsync(FilmsRoomDatabase.getDatabase(getContext())).execute().get();
            images = new ManagerDbAsync.GetImagesFromDbAsync(ImagesRoomDatabase.getDatabase(getContext())).execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if (films != null && films.size() == 0) {
            rootPresenter.requestFilms();
        } else {
            filmsAdapter.replaceData(films, images);
            hideProgress();
        }

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_general_list;
    }

    @Override
    protected String getCustomTag() {
        return TAG;
    }

    private void setupRecyclerView() {
        rvFilms.setLayoutManager(new LinearLayoutManager(getContext()));
        rvFilms.setAdapter(filmsAdapter);
    }

    @Override
    public void showResponse(ServicesResponse response) {

        try {
            List<ServiceFilmResponse> listResponse = (List<ServiceFilmResponse>) response.getResponse();
            filmsAdapter.replaceData(listResponse, images);
            new ManagerDbAsync.InsertDataToDbAsync(FilmsRoomDatabase.getDatabase(getContext()), listResponse).execute();
        } catch (Exception e) {
        }

    }

    @Override
    public void showError(ServicesError broxelServicesError) {
        getActivity().onBackPressed();
    }

    @Override
    public void showProgress() {
        iProgressLayout.getProgress().setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        iProgressLayout.getProgress().setVisibility(View.GONE);
    }

    private void showToolbarDefaultMode() {
        updateToolbar("Films", R.drawable.ic_films_2);
    }
}
