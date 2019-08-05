package com.example.dev.model;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class ItemRecycler implements Serializable {
    int id;
    int img;
    int favorite, save;

    public ItemRecycler(int img, int favorite, int save) {
        this.img = img;
        this.favorite = favorite;
        this.save = save;
    }

    public ItemRecycler() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

    public int getSave() {
        return save;
    }

    public void setSave(int save) {
        this.save = save;
    }
}
