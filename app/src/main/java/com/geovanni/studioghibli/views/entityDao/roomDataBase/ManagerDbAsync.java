package com.geovanni.studioghibli.views.entityDao.roomDataBase;

import android.os.AsyncTask;

import com.geovanni.studioghibli.views.bussiness.models.ServiceFilmResponse;
import com.geovanni.studioghibli.views.bussiness.models.ServiceImagesDb;
import com.geovanni.studioghibli.views.bussiness.models.ServicePeopleResponse;
import com.geovanni.studioghibli.views.entityDao.interfaces.IServiceFilmsDao;
import com.geovanni.studioghibli.views.entityDao.interfaces.IServiceImagesDao;
import com.geovanni.studioghibli.views.entityDao.interfaces.IServicePeopleDao;

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

    public static class InsertImagesToDbAsync extends AsyncTask<Void, Void, Void> {
        private final IServiceImagesDao imagesDao;
        private final List<ServiceImagesDb> serviceImagesDbs;

        public InsertImagesToDbAsync(ImagesRoomDatabase db, List<ServiceImagesDb> serviceImagesResponse) {
            imagesDao = db.imagesDao();
            this.serviceImagesDbs = serviceImagesResponse;
        }

        @Override
        protected Void doInBackground(Void... params) {
            for (ServiceImagesDb images : serviceImagesDbs) {
                imagesDao.insert(images);
            }
            return null;
        }
    }

    public static class GetImagesFromDbAsync extends AsyncTask<Void, Void, List<ServiceImagesDb>> {
        private final IServiceImagesDao imagesDao;

        public GetImagesFromDbAsync(ImagesRoomDatabase db) {
            imagesDao = db.imagesDao();
        }

        @Override
        protected List<ServiceImagesDb> doInBackground(Void... voids) {
            return imagesDao.getAll();
        }
    }

    public static class InsertPeopleToDbAsync extends AsyncTask<Void, Void, Void> {
        private final IServicePeopleDao peopleDao;
        private final List<ServicePeopleResponse> servicePeopleResponse;

        public InsertPeopleToDbAsync(PeopleRoomDatabase db, List<ServicePeopleResponse> servicePeopleResponse) {
            peopleDao = db.peopleDao();
            this.servicePeopleResponse = servicePeopleResponse;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            for (ServicePeopleResponse film : servicePeopleResponse) {
                peopleDao.insert(film);
            }
            return null;
        }
    }

    public static class GetPeopleFromDbAsync extends AsyncTask<Void, Void, List<ServicePeopleResponse>> {
        private final IServicePeopleDao peopleDao;

        public GetPeopleFromDbAsync(PeopleRoomDatabase db) {
            peopleDao = db.peopleDao();
        }

        @Override
        protected List<ServicePeopleResponse> doInBackground(Void... voids) {
            return peopleDao.getAll();
        }
    }

}
