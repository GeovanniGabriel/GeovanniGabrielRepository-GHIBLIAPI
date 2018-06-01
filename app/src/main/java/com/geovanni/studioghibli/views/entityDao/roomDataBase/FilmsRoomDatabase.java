package com.geovanni.studioghibli.views.entityDao.roomDataBase;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.geovanni.studioghibli.views.bussiness.models.ServiceFilmResponse;
import com.geovanni.studioghibli.views.entityDao.interfaces.IServiceFilmsDao;

@Database(entities = {ServiceFilmResponse.class}, version = 1)
public abstract class FilmsRoomDatabase extends RoomDatabase {

    private static FilmsRoomDatabase INSTANCE;

    public abstract IServiceFilmsDao filmsDao();

    public static synchronized FilmsRoomDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), FilmsRoomDatabase.class, "films_database").build();
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
