package com.geovanni.studioghibli.views.bussiness.models;

import java.util.List;

public class ServiceImagesResponse {

    List<DetailImages> Movies;
    List<DetailImages> People;

    public List<DetailImages> getMovies() {
        return Movies;
    }

    public void setMovies(List<DetailImages> movies) {
        Movies = movies;
    }

    public List<DetailImages> getPeople() {
        return People;
    }

    public void setPeople(List<DetailImages> people) {
        People = people;
    }
}
