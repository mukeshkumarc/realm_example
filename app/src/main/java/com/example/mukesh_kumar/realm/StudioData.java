package com.example.mukesh_kumar.realm;

import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.mukesh_kumar.realm.Binders.StudioViewBiender;
import com.example.mukesh_kumar.realm.Utils.AppController;
import com.example.mukesh_kumar.realm.Utils.JsonToJavaObject;
import com.example.mukesh_kumar.realm.ViewModels.Amenity;
import com.example.mukesh_kumar.realm.ViewModels.ClassDetailVM;;
import com.example.mukesh_kumar.realm.ViewModels.StudioVM;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import io.realm.Realm;
import io.realm.RealmList;

/**
 * Created by mukesh_kumar on 4/11/15.
 */
public class StudioData {
    Realm realm;
    public  StudioData(Realm realm){
        this.realm=realm;
    }

    public   void  getDataFromUrl(){

        String url ="http://192.168.0.105:8080/com.zealo.web/studio/details";
        JSONObject params=new JSONObject();
        try {
            params.put("userId",1);
            params.put("studioId",3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest request= new JsonObjectRequest(url,params,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("response1", "" + response);
                            StudioVM studioVM=getStudioVM(response);
                            realm.beginTransaction();
                            //ClassDetailVM classDetailVM1=realm.copyToRealm(classDetailVM);
                            StudioVM studioVM1=realm.copyToRealm(studioVM);
                            realm.commitTransaction();
                        StudioVM  studioVM2 = StudioViewBiender.getTrainerVMById(realm, 3);
                        Log.e("StudioVM", "" + studioVM2);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               // Toast.makeText(context, "Some Error occurred ", Toast.LENGTH_SHORT).show();
                Log.e("response1", "" + error);
            }
        });
        AppController.getInstance().addToRequestQueue(request);

    }
    private StudioVM getStudioVM(JSONObject object){
        StudioVM studioVM=new StudioVM();
        try {
            studioVM.setId(object.getInt("studioId"));
            studioVM.setName(object.getString("name"));
            studioVM.setStudioLogoURL(object.getString("studioLogoURL"));
            studioVM.setAddress(object.getString("address"));
            studioVM.setAbout(object.getString("about"));
            studioVM.setLatitude(object.getDouble("latitude"));
            studioVM.setLongitude(object.getDouble("longitude"));
            studioVM.setLocality(object.getString("locality"));
            studioVM.setLocalityId(object.getInt("localityId"));
            RealmList<Amenity> amenityRealmList=new RealmList<>();
            JSONArray amenityArray= object.getJSONArray("amenityList");
            for(int j=0;j<amenityArray.length();j++){

                JSONObject c=amenityArray.getJSONObject(j);
                Amenity amenity=JsonToJavaObject.getAmenityVm(c);
                amenityRealmList.add(amenity);
            }
            studioVM.setList_of_Amenities(amenityRealmList);
            RealmList<ClassDetailVM> classSummaryVMRealmList=new RealmList<>();
            JSONArray classSessionArray= object.getJSONArray("classSessionList");
            for (int j=0;j<classSessionArray.length();j++){
               JSONObject c=classSessionArray.getJSONObject(j);
                ClassDetailVM classDetailVM= JsonToJavaObject.getClassDetailVM(c);
                classSummaryVMRealmList.add(classDetailVM);
            }
            studioVM.setList_of_Sessions(classSummaryVMRealmList);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  studioVM;
    }
}
