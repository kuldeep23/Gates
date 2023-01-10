package com.example.gates.model;

public class responsemodel1 {
    String id, name, desig, image;

    public responsemodel1() {
    }

    public responsemodel1(String id, String name, String desig, String image) {
        this.id = id;
        this.name = name;
        this.desig = desig;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesig() {
        return desig;
    }

    public void setDesig(String desig) {
        this.desig = desig;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

