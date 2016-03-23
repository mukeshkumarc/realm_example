package com.example.mukesh_kumar.realm.ViewModels;

import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by mukesh_kumar on 22/10/15.
 */
public class StudioVM extends RealmObject {

    private	int	Id;
    private	String	Name;
    private	String	Address;
    private	String	about;
    private	double	latitude;
    private	double	longitude;
    private String studioLogoURL;
    private String locality;
    private int localityId;
    private RealmList<ActivityVM> List_of_Activity_Names;
    private RealmList<Amenity> List_of_Amenities;
   private	RealmList<ClassDetailVM> List_of_Sessions;

    public RealmList<ClassDetailVM> getList_of_Sessions() {
        return List_of_Sessions;
    }

    public void setList_of_Sessions(RealmList<ClassDetailVM> list_of_Sessions) {
        List_of_Sessions = list_of_Sessions;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public int getLocalityId() {
        return localityId;
    }

    public void setLocalityId(int localityId) {
        this.localityId = localityId;
    }

    public String getStudioLogoURL() {
        return studioLogoURL;
    }

    public void setStudioLogoURL(String studioLogoURL) {
        this.studioLogoURL = studioLogoURL;
    }

    public RealmList<ActivityVM> getList_of_Activity_Names() {
        return List_of_Activity_Names;
    }

    public void setList_of_Activity_Names(RealmList<ActivityVM> list_of_Activity_Names) {
        List_of_Activity_Names = list_of_Activity_Names;
    }

    public RealmList<Amenity> getList_of_Amenities() {
        return List_of_Amenities;
    }

    public void setList_of_Amenities(RealmList<Amenity> list_of_Amenities) {
        List_of_Amenities = list_of_Amenities;
    }
    private Date lastUpdate;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
