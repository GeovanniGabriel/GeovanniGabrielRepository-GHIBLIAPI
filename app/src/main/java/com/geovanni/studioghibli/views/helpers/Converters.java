package com.geovanni.studioghibli.views.helpers;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;

import java.util.List;

public class Converters {

    @TypeConverter
    public static String arrayToJson(List<String> list) {
        if (list == null)
            return null;

        String data = list.get(0);
        return list.isEmpty() ? null : new Gson().toJson(data);

    }
}
