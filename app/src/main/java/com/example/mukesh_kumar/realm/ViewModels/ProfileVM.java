package com.example.mukesh_kumar.realm.ViewModels;

import java.util.Date;


import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mukesh_kumar on 22/10/15.
 */
public class ProfileVM extends RealmObject {

    @PrimaryKey
    private	int	Id;
    private	String	Name;
    private	String	Total_Classes;
    private	String	Avg_ClasssesWeek;
    private RealmList<ClassDetailVM> List_of_Upcoming_classes;
    private	RealmList<ClassDetailVM>Journey;
    private Date lastUpdate;


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTotal_Classes() {
        return Total_Classes;
    }

    public void setTotal_Classes(String total_Classes) {
        Total_Classes = total_Classes;
    }

    public String getAvg_ClasssesWeek() {
        return Avg_ClasssesWeek;
    }

    public void setAvg_ClasssesWeek(String avg_ClasssesWeek) {
        Avg_ClasssesWeek = avg_ClasssesWeek;
    }

    public RealmList<ClassDetailVM> getList_of_Upcoming_classes() {
        return List_of_Upcoming_classes;
    }

    public void setList_of_Upcoming_classes(RealmList<ClassDetailVM> list_of_Upcoming_classes) {
        List_of_Upcoming_classes = list_of_Upcoming_classes;
    }

    public void setJourney(RealmList<ClassDetailVM> journey) {
        Journey = journey;
    }

    public RealmList<ClassDetailVM> getJourney() {
        return Journey;
    }


    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getId() {

        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
