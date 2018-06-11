package com.geovanni.studioghibli.views.entityDao.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.geovanni.studioghibli.views.bussiness.models.ServiceImagesDb;

import java.util.List;

@Dao
public interface IServiceImagesDao {

    @Query("SELECT * FROM ServiceImagesDb")
    List<ServiceImagesDb> getAll();

    @Insert
    void insert(ServiceImagesDb images);
}
