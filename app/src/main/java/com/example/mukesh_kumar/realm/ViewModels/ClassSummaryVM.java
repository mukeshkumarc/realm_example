package com.example.mukesh_kumar.realm.ViewModels;

import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by mukesh_kumar on 22/10/15.
 */
public class ClassSummaryVM extends RealmObject {
    private	int	Id;
    private	String	Class_Name;
    private	String	Trainer_Name;
    private	String	Studio_Name;
    private Date StartTime;
    private	Date	endTime;
    private	String	Locality;
    private	String	Video_URL;
    private	String	Background_ImageURL;
    private String TAG;

    public String getTAG() {
        return TAG;
    }

    public void setTAG(String TAG) {
        this.TAG = TAG;
    }

    public int getId() {
        return Id;
    }
3425w56wayqzhaqugsxs    public void setId(int id) {
        Id = id;
    }

    public String getClass_Name() {
        return Class_Name;
    }

    public void setClass_Name(String class_Name) {
        Class_Name = class_Name;
    }

    public String getTrainer_Name() {
        return Trainer_Name;
    }

    public void setTrainer_Name(String trainer_Name) {
        Trainer_Name = trainer_Name;
    }

    public String getStudio_Name() {
        return Studio_Name;
    }

    public void setStudio_Name(String studio_Name) {
        Studio_Name = studio_Name;
    }

    public Date getStartTime() {
        return StartTime;
    }

    public void setStartTime(Date startTime) {
        StartTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getLocality() {
        return Locality;
    }

    public void setLocality(String locality) {
        Locality = locality;
    }

    public String getVideo_URL() {
        return Video_URL;
    }

    public void setVideo_URL(String video_URL) {
        Video_URL = video_URL;
    }

    public String getBackground_ImageURL() {
        return Background_ImageURL;
    }

    public void setBackground_ImageURL(String background_ImageURL) {
        Background_ImageURL = background_ImageURL;
    }
}
