package com.example.retroexample;

import com.google.gson.annotations.SerializedName;

public class Pojo
{
    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Pojo() {
    }

    public Pojo(String name, String login) {
        this.name = name;
        this.login = login;
    }

    @SerializedName("login")
    private String login;
}
