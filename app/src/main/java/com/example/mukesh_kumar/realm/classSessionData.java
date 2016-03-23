package com.example.mukesh_kumar.realm;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.mukesh_kumar.realm.Binders.ClassSessionDetailsViewBInder;
import com.example.mukesh_kumar.realm.Utils.AppController;
import com.example.mukesh_kumar.realm.Utils.JsonToJavaObject;
import com.example.mukesh_kumar.realm.ViewModels.Amenity;
import com.example.mukesh_kumar.realm.ViewModels.ClassDetailVM;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmList;

/**
 * Created by mukesh_kumar on 4/11/15.
 */
public class classSessionData {

    Realm realm;
    public classSessionData(Realm realm){
        this.realm=realm;
    }
    public  void getDataFromUrl() {
        String url ="http://192.168.0.105:8080/com.zealo.web/session/list/locality";
        ArrayList<Integer> localityId=new ArrayList<>();
        localityId.add(3);
        JSONObject params=new JSONObject();
        try {
            params.put("userId",1);
            params.put("localityIdList",new JSONArray(localityId));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final JsonArrayRequest request= new JsonArrayRequest(url,params,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("Response", "" + response);
                        for(int i=0;i<response.length();i++){
                            try {
                                JSONObject object= response.getJSONObject(i);
                                ClassDetailVM classDetailVM= JsonToJavaObject.getClassDetailVM(object);
                                realm.beginTransaction();
                                ClassDetailVM classDetailVM1=realm.copyToRealm(classDetailVM);
                                Log.d("classDetailVM1",""+classDetailVM1);
                                realm.commitTransaction();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Response1",""+error);
            }
        });
        Log.d("Response2", "" + request);
        if(request!=null){
            AppController.getInstance().addToRequestQueue(request);}

    }

    /*public ClassDetailVM getClassDetailVM(JSONObject object) {
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


    private void realmFunction() {
        ClassDetailVM detailVM= ClassSessionDetailsViewBInder.getClassDetailsVMById(realm, 1);

        Log.d("ClassDetailVM123",""+detailVM);

    }*/
}
