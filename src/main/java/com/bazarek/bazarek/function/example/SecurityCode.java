package com.bazarek.bazarek.function.example;

public class SecurityCode {
    private int id;
    private final String name;
    private String login;
    private String password;
    private String url;

    public SecurityCode(int id,String name, String login, String password, String url) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public SecurityCode setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public SecurityCode setLogin(String login) {
        this.login = login;
        return  this;
    }

    public String getPassword() {
        return password;
    }

    public SecurityCode setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public SecurityCode setUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public String toString() {
        return "SecurityCode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
