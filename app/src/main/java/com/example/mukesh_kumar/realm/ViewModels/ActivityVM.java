package com.example.mukesh_kumar.realm.ViewModels;

import io.realm.RealmObject;

/**
 * Created by mukesh_kumar on 22/10/15.
 */
public class ActivityVM extends RealmObject {

    private int 	id;
    private String	name;
    private String	logoURL;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoURL() {
        return logoURL;
    }

    public void setLogoURL(String logoURL) {
        this.logoURL = logoURL;
    }
}
