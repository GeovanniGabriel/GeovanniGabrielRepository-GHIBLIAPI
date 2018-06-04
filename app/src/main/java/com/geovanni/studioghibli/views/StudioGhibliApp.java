package com.geovanni.studioghibli.views;

import android.app.Application;
import android.content.Context;

public class StudioGhibliApp extends Application {

    private static Context contextApp;
    private static StudioGhibliApp m_singleton;

    @Override
    public void onCreate() {
        super.onCreate();
        contextApp = this;
        m_singleton = this;
    }

    public static Context getContext() {
        return contextApp;
    }

    public static StudioGhibliApp getInstance() {
        return m_singleton;
    }
}
