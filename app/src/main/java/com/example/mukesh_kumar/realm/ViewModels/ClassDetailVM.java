package com.example.mukesh_kumar.realm.ViewModels;

import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by mukesh_kumar on 22/10/15.
 */
public class ClassDetailVM extends RealmObject {

    private	int	sessionId;
    private	int	classId;
    private	String	Class_Name;
    private	int	trainerId;
    private	String	Trainer_Name;
    private  String trainer_Image_URL;
    private	int	StudioId;
    private	String	Studio_Name;
    private String studio_logo_URL;
    private Date Start_Time ;
    private	Date	endTime;
    private	String	About;
    private	Double	latitude;
    private	Double	longitude;
    private	int	Slots_Left;
    private	boolean	Been_here;
    private  int venueId;
    private	String	Address;
    private int localityId;
    private	String	Locality;
    private	String	Video_URL;
    private	String	Background_Image_URL;
    private int activityId;
    private RealmList<Amenity> amenityList;
    private	String	beInformedText;
    private ActivityVM activityVM;
    private Date lastUpdate;

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public ActivityVM getActivityVM() {
        return activityVM;
    }

    public void setActivityVM(ActivityVM activityVM) {
        this.activityVM = activityVM;
    }

    public int getLocalityId() {
        return localityId;
    }

    public void setLocalityId(int localityId) {
        this.localityId = localityId;
    }


    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClass_Name() {
        return Class_Name;
    }

    public void setClass_Name(String class_Name) {
        Class_Name = class_Name;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public String getTrainer_Name() {
        return Trainer_Name;
    }

    public void setTrainer_Name(String trainer_Name) {
        Trainer_Name = trainer_Name;
    }

    public int getStudioId() {
        return StudioId;
    }

    public void setStudioId(int studioId) {
        StudioId = studioId;
    }

    public String getStudio_Name() {
        return Studio_Name;
    }

    public void setStudio_Name(String studio_Name) {
        Studio_Name = studio_Name;
    }

    public Date getStart_Time() {
        return Start_Time;
    }

    public void setStart_Time(Date start_Time) {
        Start_Time = start_Time;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getAbout() {
        return About;
    }

    public void setAbout(String about) {
        About = about;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public int getSlots_Left() {
        return Slots_Left;
    }

    public void setSlots_Left(int slots_Left) {
        Slots_Left = slots_Left;
    }

    public boolean isBeen_here() {
        return Been_here;
    }

    public void setBeen_here(boolean been_here) {
        Been_here = been_here;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
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

    public String getBackground_Image_URL() {
        return Background_Image_URL;
    }

    public void setBackground_Image_URL(String background_Image_URL) {
        Background_Image_URL = background_Image_URL;
    }

    public RealmList<Amenity> getAmenityList() {
        return amenityList;
    }

    public void setAmenityList(RealmList<Amenity> amenityList) {
        this.amenityList = amenityList;
    }

    public String getBeInformedText() {
        return beInformedText;
    }

    public void setBeInformedText(String beInformedText) {
        this.beInformedText = beInformedText;
    }

    public String getTrainer_Image_URL() {
        return trainer_Image_URL;
    }

    public void setTrainer_Image_URL(String trainer_Image_URL) {
        this.trainer_Image_URL = trainer_Image_URL;
    }

    public String getStudio_logo_URL() {
        return studio_logo_URL;
    }

    public void setStudio_logo_URL(String studio_logo_URL) {
        this.studio_logo_URL = studio_logo_URL;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }
}

