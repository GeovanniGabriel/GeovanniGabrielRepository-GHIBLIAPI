package com.geovanni.studioghibli.views.helpers;

import android.arch.persistence.room.TypeConverter;

import com.geovanni.studioghibli.views.bussiness.models.DetailImages;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class Converters {

    static Gson gson = new Gson();

    @TypeConverter
    public static List<DetailImages> stringToObjectList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<DetailImages>>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String objectListToString(List<DetailImages> objects) {
        return gson.toJson(objects);
    }
}
