package com.geovanni.studioghibli.views.bussiness.utils;

import org.json.JSONObject;

public class ServicesError {

    private String message = "";
    private int type = 0;

    public ServicesError() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}