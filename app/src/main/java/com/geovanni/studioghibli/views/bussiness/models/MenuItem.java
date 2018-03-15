package com.geovanni.studioghibli.views.bussiness.models;

public class MenuItem {

    private int name;
    private int imageResource;
    private int description;

    public MenuItem(int name, int imageResource, int description) {
        this.name = name;
        this.imageResource = imageResource;
        this.description = description;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getImage() {
        return imageResource;
    }

    public void setImage(int image) {
        this.imageResource = image;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }


}
