package com.example.gates.mybanner;

public class bannermodel {
    String UID,Banner_Image,Creation_Date,Is_Active;

    public bannermodel() {
    }

    public bannermodel(String UID, String banner_Image, String creation_Date, String is_Active) {
        this.UID = UID;
        Banner_Image = banner_Image;
        Creation_Date = creation_Date;
        Is_Active = is_Active;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getBanner_Image() {
        return Banner_Image;
    }

    public void setBanner_Image(String banner_Image) {
        Banner_Image = banner_Image;
    }

    public String getCreation_Date() {
        return Creation_Date;
    }

    public void setCreation_Date(String creation_Date) {
        Creation_Date = creation_Date;
    }

    public String getIs_Active() {
        return Is_Active;
    }

    public void setIs_Active(String is_Active) {
        Is_Active = is_Active;
    }
}
