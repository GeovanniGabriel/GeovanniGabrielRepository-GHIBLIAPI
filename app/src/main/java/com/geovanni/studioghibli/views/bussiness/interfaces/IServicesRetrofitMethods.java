package com.geovanni.studioghibli.views.bussiness.interfaces;

import com.geovanni.studioghibli.views.bussiness.models.ServiceFilmResponse;
import com.geovanni.studioghibli.views.bussiness.models.ServiceImagesResponse;
import com.geovanni.studioghibli.views.bussiness.models.ServicePeopleResponse;
import com.geovanni.studioghibli.views.bussiness.utils.ServicesConstants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface IServicesRetrofitMethods {

    //***************************************   getFilms *******************************
    @Headers("Content-Type: application/json")
    @GET(ServicesConstants.GET_FILMS_API)
    Call<List<ServiceFilmResponse>> getFilms();

    //***************************************   getPeople *******************************
    @Headers("Content-Type: application/json")
    @GET(ServicesConstants.GET_PEOPLE_API)
    Call<List<ServicePeopleResponse>> getPeople();

    //***************************************   getImages *******************************
    @Headers("Content-Type: application/json")
    @GET(ServicesConstants.GET_IMAGES)
    Call<ServiceImagesResponse> getImages();
}
