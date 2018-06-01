package com.geovanni.studioghibli.views.bussiness.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class ServiceFilmResponse {



    @PrimaryKey
    @NonNull
    private String id;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "director")
    private String director;
    @ColumnInfo(name = "producer")
    private String producer;
    @ColumnInfo(name = "releaseDate")
    private String releaseDate;
    @ColumnInfo(name = "rtScore")
    private String rtScore;
//    @TypeConverter(Converters.class)
//    private List<String> people = null;
//    @TypeConverter(Converters.class)
//    private List<String> species = null;
//    @TypeConverter(Converters.class)
//    private List<String> locations = null;
//    @TypeConverter(Converters.class)
//    private List<String> vehicles = null;
    @ColumnInfo(name = "url")
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRtScore() {
        return rtScore;
    }

    public void setRtScore(String rtScore) {
        this.rtScore = rtScore;
    }

//    public List<String> getPeople() {
//        return people;
//    }
//
//    public void setPeople(List<String> people) {
//        this.people = people;
//    }
//
//    public List<String> getSpecies() {
//        return species;
//    }
//
//    public void setSpecies(List<String> species) {
//        this.species = species;
//    }
//
//    public List<String> getLocations() {
//        return locations;
//    }
//
//    public void setLocations(List<String> locations) {
//        this.locations = locations;
//    }
//
//    public List<String> getVehicles() {
//        return vehicles;
//    }
//
//    public void setVehicles(List<String> vehicles) {
//        this.vehicles = vehicles;
//    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}