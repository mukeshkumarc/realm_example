package com.example.mukesh_kumar.realm.ViewModels;

import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by mukesh_kumar on 22/10/15.
 */
public class TrainerDeatilVM extends RealmObject{

    private	int	id;
    private	String Name;
    private	String	Profile_Pic;
    private	String	about;
    private RealmList<ActivityVM> List_of_Activity_Names;
    private RealmList<ClassDetailVM> List_of_Sessions;
    private Date lastUpdate;

    public RealmList<ClassDetailVM> getList_of_Sessions() {
        return List_of_Sessions;
    }

    public void setList_of_Sessions(RealmList<ClassDetailVM> list_of_Sessions) {
        List_of_Sessions = list_of_Sessions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getProfile_Pic() {
        return Profile_Pic;
    }

    public void setProfile_Pic(String profile_Pic) {
        Profile_Pic = profile_Pic;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public RealmList<ActivityVM> getList_of_Activity_Names() {
        return List_of_Activity_Names;
    }

    public void setList_of_Activity_Names(RealmList<ActivityVM> list_of_Activity_Names) {
        List_of_Activity_Names = list_of_Activity_Names;
    }
    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
