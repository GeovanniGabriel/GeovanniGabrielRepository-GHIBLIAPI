package com.geovanni.studioghibli.views.bussiness.utils;

public class ServicesResponse<T> {

    private T response;
    private int type = 0;

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}