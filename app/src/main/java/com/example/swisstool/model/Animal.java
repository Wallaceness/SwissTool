package com.example.swisstool.model;

public class Animal {

    private String name;
    private String Scientific_name;
    private String consStatus;

    public Animal(String name, String scientific_name, String consStatus) {
        this.name = name;
        this.Scientific_name = scientific_name;
        this.consStatus = consStatus;
    }

    public String getName() {
        return name;
    }

    public String getscName() {
        return Scientific_name;
    }

    public String getStatus() {
        return consStatus;
    }

    public void setName(String name) {
        this.name = name;
    }
}
