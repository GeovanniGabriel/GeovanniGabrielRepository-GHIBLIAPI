package com.geovanni.studioghibli.views.entityDao.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.geovanni.studioghibli.views.bussiness.models.ServiceFilmResponse;

import java.util.List;

@Dao
public interface IServiceFilmsDao {

    @Query("SELECT * FROM ServiceFilmResponse")
    List<ServiceFilmResponse> getAll();

    @Insert
    void insert(ServiceFilmResponse film);

}
