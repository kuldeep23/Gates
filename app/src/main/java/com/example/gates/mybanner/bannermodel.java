package com.example.gates.mybanner;

public class bannermodel {
    String image,sno;

    public bannermodel() {
    }

    public bannermodel(String image, String sno) {
        this.image = image;
        this.sno = sno;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }
}
