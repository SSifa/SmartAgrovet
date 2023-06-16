package com.example.smartagrovet;

public class Agrovet {
    int image, phone;
    String location, email, name;

    public Agrovet(int image, String name, String email, int phone, String location) {
        this.image = image;
        this.phone = phone;
        this.location = location;
        this.email = email;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
