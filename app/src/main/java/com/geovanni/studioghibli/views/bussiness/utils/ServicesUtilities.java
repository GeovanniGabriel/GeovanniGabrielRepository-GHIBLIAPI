package com.geovanni.studioghibli.views.bussiness.utils;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

/**
 * @author Broxel Labs.
 */

public class ServicesUtilities {

    /**
     * Return a json object from string
     *
     * @param s string
     * @param c type class to convert
     * @return a object convertion JSON
     */
    public Object parseToObjectClass(String s, Class c) {
        try {
            Gson gson = new Gson();
            return gson.fromJson(s, c);
        } catch (JsonParseException e) {
            return e;
        }
    }
}
