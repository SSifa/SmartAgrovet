package com.example.smartagrovet;

public class Farmer {
    int img, phone;
    String name, email, location;

    public Farmer(int img, String name, String email, int phone, String location) {
        this.img = img;
        this.phone = phone;
        this.name = name;
        this.email = email;
        this.location = location;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
