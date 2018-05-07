package com.vironit.pharmacy.dto;

public class NewRegistrationUser {
    private String login;
    private String password;


    public NewRegistrationUser(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public NewRegistrationUser() {
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
