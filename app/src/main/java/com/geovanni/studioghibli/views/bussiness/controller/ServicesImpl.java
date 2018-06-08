package com.geovanni.studioghibli.views.bussiness.controller;

import android.content.Context;

import com.geovanni.studioghibli.views.bussiness.interfaces.IServiceListener;
import com.geovanni.studioghibli.views.bussiness.interfaces.IServicesRetrofitMethods;
import com.geovanni.studioghibli.views.bussiness.models.ServiceFilmResponse;
import com.geovanni.studioghibli.views.bussiness.models.ServiceImagesResponse;
import com.geovanni.studioghibli.views.bussiness.models.ServicePeopleResponse;
import com.geovanni.studioghibli.views.bussiness.utils.ServicesError;
import com.geovanni.studioghibli.views.bussiness.utils.ServicesResponse;
import com.geovanni.studioghibli.views.bussiness.utils.ServicesRetrofitManager;
import com.geovanni.studioghibli.views.bussiness.utils.ServicesUtilities;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ServicesImpl {

    private Context context;
    private Retrofit retrofit;
    private Retrofit retrofitGit;
    private IServiceListener iServiceListener;
    private IServicesRetrofitMethods iServicesRetrofitMethods;
    private IServicesRetrofitMethods iServicesRetrofitMethodsGit;
    private ServicesUtilities servicesUtilities;

    public ServicesImpl(Context context) {
        this.context = context;
        retrofit = ServicesRetrofitManager.getInstance().getRetrofitAPI();
        iServicesRetrofitMethods = retrofit.create(IServicesRetrofitMethods.class);

        retrofitGit = ServicesRetrofitManager.getInstance().getRetrofitGitHubAPI();
        iServicesRetrofitMethodsGit = retrofitGit.create(IServicesRetrofitMethods.class);

        servicesUtilities = new ServicesUtilities();
    }

    /* *******************************************************************************************************************************************************
    *****************************************************               getFilms            **********************************************************
    *********************************************************************************************************************************************************/

    public void getFilms() {
        final ServicesError servicesError = new ServicesError();

        iServicesRetrofitMethods.getFilms().enqueue(new Callback<List<ServiceFilmResponse>>() {
            @Override
            public void onResponse(Call<List<ServiceFilmResponse>> call, Response<List<ServiceFilmResponse>> response) {
                ServicesResponse<List<ServiceFilmResponse>> servicesResponse = new ServicesResponse<>();
                servicesResponse.setResponse(response.body());
                iServiceListener.onResponse(servicesResponse);
            }

            @Override
            public void onFailure(Call<List<ServiceFilmResponse>> call, Throwable t) {
                servicesError.setMessage("");
                servicesError.setType(1);
                iServiceListener.onError(servicesError);
            }
        });
    }

    /* *******************************************************************************************************************************************************
    *****************************************************               getPeople            **********************************************************
    *********************************************************************************************************************************************************/

    public void getPeople() {
        final ServicesError servicesError = new ServicesError();

        iServicesRetrofitMethods.getPeople().enqueue(new Callback<List<ServicePeopleResponse>>() {
            @Override
            public void onResponse(Call<List<ServicePeopleResponse>> call, Response<List<ServicePeopleResponse>> response) {
                ServicesResponse<List<ServicePeopleResponse>> servicesResponse = new ServicesResponse<>();
                servicesResponse.setResponse(response.body());
                iServiceListener.onResponse(servicesResponse);
            }

            @Override
            public void onFailure(Call<List<ServicePeopleResponse>> call, Throwable t) {
                servicesError.setMessage("");
                servicesError.setType(1);
                iServiceListener.onError(servicesError);
            }
        });
    }

    /* *******************************************************************************************************************************************************
    *****************************************************               getImages            **********************************************************
    *********************************************************************************************************************************************************/

    public void getImagesToFilms() {
        final ServicesError servicesError = new ServicesError();

        iServicesRetrofitMethodsGit.getImages().enqueue(new Callback<List<ServiceImagesResponse>>() {
            @Override
            public void onResponse(Call<List<ServiceImagesResponse>> call, Response<List<ServiceImagesResponse>> response) {
                ServicesResponse<List<ServiceImagesResponse>> servicesResponse = new ServicesResponse<>();
                servicesResponse.setResponse(response.body());
                iServiceListener.onResponse(servicesResponse);
            }

            @Override
            public void onFailure(Call<List<ServiceImagesResponse>> call, Throwable t) {
                servicesError.setMessage("");
                servicesError.setType(1);
                iServiceListener.onError(servicesError);
            }
        });
    }

    public void setOnServicesListener(IServiceListener iServiceListener) {
        this.iServiceListener = iServiceListener;
    }
}
