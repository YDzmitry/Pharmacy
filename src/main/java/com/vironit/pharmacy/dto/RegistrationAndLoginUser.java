package com.vironit.pharmacy.dto;

public class RegistrationAndLoginUser {
    private String login;
    private String password;


    public RegistrationAndLoginUser(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public RegistrationAndLoginUser() {
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
