package com.cricket.core;

import java.util.Objects;

public class Cricket {
    private String name;
    private int age;
    private String email_id;
    private String phone;
    private double rating;

    public Cricket(String name, int age, String email_id, String phone, double rating) {
        this.name = name;
        this.age = age;
        this.email_id = email_id;
        this.phone = phone;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Cricket{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email_id='" + email_id + '\'' +
                ", phone='" + phone + '\'' +
                ", rating=" + rating +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail_id() {
        return email_id;
    }

    public String getPhone() {
        return phone;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
