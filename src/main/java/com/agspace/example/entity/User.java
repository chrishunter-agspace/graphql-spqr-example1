package com.agspace.example.entity;

import com.vividsolutions.jts.geom.Geometry;

public class User {
    private String name;

    private Geometry location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Geometry getLocation() {
        return location;
    }

    public void setLocation(Geometry location) {
        this.location = location;
    }
}
