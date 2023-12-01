package com.example.newlibrary.Domain;

public class usersDomain {
    private String userName;
    private String Password;
    private String Name;

    public usersDomain(String userName, String password, String name) {
        this.userName = userName;
        this.Password = password;
        this.Name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
