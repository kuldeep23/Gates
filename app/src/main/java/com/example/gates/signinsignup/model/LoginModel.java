package com.example.gates.signinsignup.model;

public class LoginModel {
    String message;

    public LoginModel(String message) {
        this.message = message;
    }

    public LoginModel() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
