package com.geovanni.studioghibli.views.entityDao.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.geovanni.studioghibli.views.bussiness.models.ServicePeopleResponse;

import java.util.List;

@Dao
public interface IServicePeopleDao {

    @Query("SELECT * FROM ServicePeopleResponse")
    List<ServicePeopleResponse> getAll();

    @Insert
    void insert(ServicePeopleResponse film);
}
