package com.geovanni.studioghibli.views.entityDao.roomDataBase;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.geovanni.studioghibli.views.bussiness.models.ServiceImagesDb;
import com.geovanni.studioghibli.views.entityDao.interfaces.IServiceImagesDao;

@Database(entities = {ServiceImagesDb.class}, version = 1)
public abstract class ImagesRoomDatabase extends RoomDatabase {

    private static ImagesRoomDatabase INSTANCE;

    public abstract IServiceImagesDao imagesDao();

    public static synchronized ImagesRoomDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ImagesRoomDatabase.class, "images_database").build();
        }
        return INSTANCE;
    }

    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }
}
