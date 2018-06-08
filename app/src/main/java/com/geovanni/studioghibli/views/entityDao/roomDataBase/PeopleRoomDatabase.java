package com.geovanni.studioghibli.views.entityDao.roomDataBase;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.geovanni.studioghibli.views.bussiness.models.ServicePeopleResponse;
import com.geovanni.studioghibli.views.entityDao.interfaces.IServicePeopleDao;

@Database(entities = {ServicePeopleResponse.class}, version = 1)
public abstract class PeopleRoomDatabase extends RoomDatabase {

    private static PeopleRoomDatabase INSTANCE;

    public abstract IServicePeopleDao peopleDao();

    public static synchronized PeopleRoomDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), PeopleRoomDatabase.class, "people_database").build();
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
