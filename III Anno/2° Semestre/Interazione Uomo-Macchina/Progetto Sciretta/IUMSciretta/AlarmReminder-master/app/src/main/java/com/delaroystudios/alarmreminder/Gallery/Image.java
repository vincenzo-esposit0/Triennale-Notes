package com.delaroystudios.alarmreminder.Gallery;

/**
 * Created by franc on 13/02/2018.
 */

public class Image {

    private int id;
    private String name;
    private String anno;
    private byte[] image;

    public Image(String name, String anno, byte[] image, int id) {
        this.name = name;
        this.anno = anno;
        this.image = image;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String price) {
        this.anno = anno;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}


