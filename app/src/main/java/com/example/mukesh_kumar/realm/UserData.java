package com.example.mukesh_kumar.realm;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.mukesh_kumar.realm.Utils.AppController;
import com.example.mukesh_kumar.realm.Utils.JsonToJavaObject;
import com.example.mukesh_kumar.realm.ViewModels.ClassDetailVM;
import com.example.mukesh_kumar.realm.ViewModels.ProfileVM;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.realm.Realm;
import io.realm.RealmList;

/**
 * Created by mukesh_kumar on 4/11/15.
 */
public class UserData {
    Realm  realm;
    int UserId=4;
    Context context;
    public UserData (Realm realm,Context context){
        this.realm=realm;
        this.context=context;
    }
    public  void  getUserDetailByUrl(){
        String Url="http://192.168.0.105:8080/com.zealo.web/user/details";
        JSONObject params= new JSONObject();
        try {
            params.put("userId",UserId);
            params.put("userUUID","e85ba98a-fab8-4dd4-b4c8-075658ed2713");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest request= new JsonObjectRequest(Url,params,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        ProfileVM profileVM=new ProfileVM();
                        try {
                            profileVM.setId(response.getInt("userId"));
                            profileVM.setName(response.getString("firstName")+" "+response.getString("lastName"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        realm.beginTransaction();
                        ProfileVM profileVM1=realm.copyToRealm(profileVM);
                        realm.commitTransaction();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Some Error occurred ", Toast.LENGTH_SHORT).show();
            }
        });
        AppController.getInstance().addToRequestQueue(request);

    }
    public void  getJourneyByUrl(){
        JSONObject params= new JSONObject();
        String URL="http://192.168.0.105:8080/com.zealo.web/user/journey";
        try {
            params.put("userId",UserId);
            params.put("userUUID","e85ba98a-fab8-4dd4-b4c8-075658ed2713");
            params.put("startDate",1335859586829L);
            params.put("endDate" ,1445859586829L);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final JsonArrayRequest request= new JsonArrayRequest(URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        RealmList<ClassDetailVM> classSummaryVMRealmList=new RealmList<>();
                        for (int j=0;j<response.length();j++){
                            JSONObject c= null;
                            try {
                                c = response.getJSONObject(j);
                                ClassDetailVM classDetailVM= JsonToJavaObject.getClassDetailVM(c);
                                classSummaryVMRealmList.add(classDetailVM);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        ProfileVM profileVM=new ProfileVM();
                        profileVM.setId(UserId);
                        profileVM.setJourney(classSummaryVMRealmList);
                        realm.beginTransaction();
                        ProfileVM profileVM1=realm.copyToRealmOrUpdate(profileVM);
                        realm.commitTransaction();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"Some Error occurred ",Toast.LENGTH_SHORT).show();
            }
        });
        AppController.getInstance().addToRequestQueue(request);

    }
    public  void  getUpcomingListByUrl(){
        JSONObject params= new JSONObject();
        String URL="http://192.168.0.105:8080/com.zealo.web/user/upcoming";
        try {
            params.put("userId",4);
            params.put("userUUID","e85ba98a-fab8-4dd4-b4c8-075658ed2713");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final JsonArrayRequest request= new JsonArrayRequest(URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        RealmList<ClassDetailVM> classSummaryVMRealmList=new RealmList<>();
                        for (int j=0;j<response.length();j++){
                            JSONObject c= null;
                            try {
                                c = response.getJSONObject(j);
                                ClassDetailVM classDetailVM= JsonToJavaObject.getClassDetailVM(c);
                                classSummaryVMRealmList.add(classDetailVM);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        ProfileVM profileVM=new ProfileVM();
                        profileVM.setId(UserId);
                        profileVM.setList_of_Upcoming_classes(classSummaryVMRealmList);
                        realm.beginTransaction();
                        ProfileVM profileVM1=realm.copyToRealmOrUpdate(profileVM);
                        realm.commitTransaction();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"Some Error occurred ",Toast.LENGTH_SHORT).show();
            }
        });
        AppController.getInstance().addToRequestQueue(request);
    }
}
