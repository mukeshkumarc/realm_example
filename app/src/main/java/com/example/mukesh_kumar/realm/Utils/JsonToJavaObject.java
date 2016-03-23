package com.example.mukesh_kumar.realm.Utils;

import com.example.mukesh_kumar.realm.ViewModels.Amenity;
import com.example.mukesh_kumar.realm.ViewModels.ClassDetailVM;
import com.example.mukesh_kumar.realm.ViewModels.ClassSummaryVM;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

import io.realm.RealmList;

/**
 * Created by mukesh_kumar on 4/11/15.
 */
public class JsonToJavaObject {

    public  static  ClassDetailVM getClassDetailVM(JSONObject object) {
        ClassDetailVM classDetailVM=new ClassDetailVM();
        try {
            classDetailVM.setSessionId(object.getInt("classSessionId"));
            classDetailVM.setClassId(object.getInt("classId"));
            classDetailVM.setClass_Name(object.getString("className"));
            classDetailVM.setTrainerId(object.getInt("trainerId"));
            classDetailVM.setTrainer_Name(object.getString("trainerName"));
            classDetailVM.setTrainer_Image_URL(object.getString("trainerImageURL"));
            classDetailVM.setStudioId(object.getInt("studioId"));
            classDetailVM.setStudio_Name(object.getString("studioName"));
            classDetailVM.setStudio_logo_URL(object.getString("studioLogoURL"));
            classDetailVM.setStart_Time(new Date(object.getLong("startTime")));
            classDetailVM.setEndTime(new Date(object.getLong("endTime")));
            classDetailVM.setAbout(object.getString("about"));
            classDetailVM.setLatitude(object.getDouble("latitude"));
            classDetailVM.setLongitude(object.getDouble("longitude"));
            classDetailVM.setSlots_Left(object.getInt("slotsLeft"));
            classDetailVM.setBeen_here(object.getBoolean("beenHere"));
            classDetailVM.setVenueId(object.getInt("venueId"));
            classDetailVM.setAddress(object.getString("address"));
            classDetailVM.setLocalityId(object.getInt("localityId"));
            classDetailVM.setLocality(object.getString("locality"));
            classDetailVM.setVideo_URL(object.getString("videoURL"));
            classDetailVM.setBackground_Image_URL(object.getString("backgroundImageURL"));
            classDetailVM.setActivityId(object.getInt("activityId"));
            RealmList<Amenity> amenityRealmList= new RealmList<>();
            JSONArray amenityArray= object.getJSONArray("amenityVMList");
            for(int j=0;j<amenityArray.length();j++){
                Amenity amenity=new Amenity();
                JSONObject c=amenityArray.getJSONObject(j);
                amenity.setId(c.getInt("amenityId"));
                amenity.setName(c.getString("amenityName"));
                amenity.setLogo_URL(c.getString("logoURL"));
                amenity.setPaid(c.getBoolean("paid"));
                amenityRealmList.add(amenity);
            }
            classDetailVM.setAmenityList(amenityRealmList);
            classDetailVM.setBeInformedText(object.getString("beInformedText"));
            classDetailVM.setLastUpdate(new Date(object.getLong("lastUpdate")));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return classDetailVM;
    }
    public static  Amenity getAmenityVm(JSONObject c){
        Amenity amenity=new Amenity();
        try {
            amenity.setId(c.getInt("amenityId"));
            amenity.setId(c.getInt("amenityId"));
            amenity.setName(c.getString("amenityName"));
            amenity.setLogo_URL(c.getString("logoURL"));
            amenity.setPaid(c.getBoolean("paid"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return amenity;
    }
}
