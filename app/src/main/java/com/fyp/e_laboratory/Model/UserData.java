package com.fyp.e_laboratory.Model;

public class UserData {
    String name;
    String email;
    String city;
    String image;
    String uid;


    public UserData(String name, String email, String city, String image, String uid) {
        this.name = name;
        this.email = email;
        this.city = city;
        this.image = image;
        this.uid = uid;

    }

    public UserData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUid() {
        return uid;
    }



    public void setUid(String uid) {
        this.uid = uid;
    }
}
