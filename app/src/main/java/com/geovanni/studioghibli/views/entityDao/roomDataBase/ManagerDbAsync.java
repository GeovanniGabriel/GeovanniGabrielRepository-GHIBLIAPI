package com.geovanni.studioghibli.views.entityDao.roomDataBase;

import android.os.AsyncTask;

import com.geovanni.studioghibli.views.bussiness.models.ServiceFilmResponse;
import com.geovanni.studioghibli.views.entityDao.interfaces.IServiceFilmsDao;

import java.util.List;

public class ManagerDbAsync {

    public static class InsertDataToDbAsync extends AsyncTask<Void, Void, Void> {
        private final IServiceFilmsDao filmsDao;
        private final List<ServiceFilmResponse> serviceFilmResponse;

        public InsertDataToDbAsync(FilmsRoomDatabase db, List<ServiceFilmResponse> serviceFilmResponse) {
            filmsDao = db.filmsDao();
            this.serviceFilmResponse = serviceFilmResponse;
        }

        @Override
        protected Void doInBackground(Void... params) {
            for (ServiceFilmResponse film : serviceFilmResponse) {
                filmsDao.insert(film);
            }
            return null;
        }
    }

    public static class GetAllDataFromDbAsync extends AsyncTask<Void, Void, List<ServiceFilmResponse>> {
        private final IServiceFilmsDao filmsDao;

        public GetAllDataFromDbAsync(FilmsRoomDatabase db) {
            filmsDao = db.filmsDao();
        }

        @Override
        protected List<ServiceFilmResponse> doInBackground(Void... voids) {
            return filmsDao.getAll();
        }

    }

}
