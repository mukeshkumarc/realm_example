package com.example.mukesh_kumar.realm.ViewModels;

import io.realm.RealmObject;

/**
 * Created by mukesh_kumar on 22/10/15.
 */
public class Amenity extends RealmObject {

    private  int id;
    private String Name;
    private String Logo_URL;
    private  boolean paid;

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLogo_URL() {
        return Logo_URL;
    }

    public void setLogo_URL(String logo_URL) {
        Logo_URL = logo_URL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
