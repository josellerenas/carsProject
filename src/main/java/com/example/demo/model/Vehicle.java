package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vehicle {
    private int id;
    private String type;
    private String brand;

    public Vehicle(@JsonProperty("id") int id,
                   @JsonProperty("type") String type,
                   @JsonProperty("brand") String brand) {
        this.id = id;
        this.type = type;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
