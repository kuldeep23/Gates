package com.example.gates.domesticstaff.model;

public class AllStaffModel {

    String uid, soc_code, staff_name, staff_icon, staff_is_active;

    public AllStaffModel() {
    }

    public AllStaffModel(String uid, String soc_code, String staff_name, String staff_icon, String staff_is_active) {
        this.uid = uid;
        this.soc_code = soc_code;
        this.staff_name = staff_name;
        this.staff_icon = staff_icon;
        this.staff_is_active = staff_is_active;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSoc_code() {
        return soc_code;
    }

    public void setSoc_code(String soc_code) {
        this.soc_code = soc_code;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getStaff_icon() {
        return staff_icon;
    }

    public void setStaff_icon(String staff_icon) {
        this.staff_icon = staff_icon;
    }

    public String getStaff_is_active() {
        return staff_is_active;
    }

    public void setStaff_is_active(String staff_is_active) {
        this.staff_is_active = staff_is_active;
    }
}
