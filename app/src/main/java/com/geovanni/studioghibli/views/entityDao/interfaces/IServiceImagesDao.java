package com.geovanni.studioghibli.views.entityDao.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.geovanni.studioghibli.views.bussiness.models.ServiceImagesResponse;

import java.util.List;

@Dao
public interface IServiceImagesDao {

    @Query("SELECT * FROM ServiceImagesResponse")
    List<ServiceImagesResponse> getAll();

    @Insert
    void insert(ServiceImagesResponse images);
}
