package com.example.gates.domesticstaff.model;

public class AllStaffMemberModel {

    String uid, soc_code, staff_name,
                staff_type, staff_icon,
                staff_mobile_no, staff_rating, staff_creation_date,
                staff_deactivate_date, staff_is_active;

    public AllStaffMemberModel() {
    }

    public AllStaffMemberModel(String uid, String soc_code, String staff_name, String staff_type, String staff_icon, String staff_mobile_no, String staff_rating, String staff_creation_date, String staff_deactivate_date, String staff_is_active) {
        this.uid = uid;
        this.soc_code = soc_code;
        this.staff_name = staff_name;
        this.staff_type = staff_type;
        this.staff_icon = staff_icon;
        this.staff_mobile_no = staff_mobile_no;
        this.staff_rating = staff_rating;
        this.staff_creation_date = staff_creation_date;
        this.staff_deactivate_date = staff_deactivate_date;
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

    public String getStaff_type() {
        return staff_type;
    }

    public void setStaff_type(String staff_type) {
        this.staff_type = staff_type;
    }

    public String getStaff_icon() {
        return staff_icon;
    }

    public void setStaff_icon(String staff_icon) {
        this.staff_icon = staff_icon;
    }

    public String getStaff_mobile_no() {
        return staff_mobile_no;
    }

    public void setStaff_mobile_no(String staff_mobile_no) {
        this.staff_mobile_no = staff_mobile_no;
    }

    public String getStaff_rating() {
        return staff_rating;
    }

    public void setStaff_rating(String staff_rating) {
        this.staff_rating = staff_rating;
    }

    public String getStaff_creation_date() {
        return staff_creation_date;
    }

    public void setStaff_creation_date(String staff_creation_date) {
        this.staff_creation_date = staff_creation_date;
    }

    public String getStaff_deactivate_date() {
        return staff_deactivate_date;
    }

    public void setStaff_deactivate_date(String staff_deactivate_date) {
        this.staff_deactivate_date = staff_deactivate_date;
    }

    public String getStaff_is_active() {
        return staff_is_active;
    }

    public void setStaff_is_active(String staff_is_active) {
        this.staff_is_active = staff_is_active;
    }
}
