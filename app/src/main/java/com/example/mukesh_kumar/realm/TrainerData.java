package com.example.mukesh_kumar.realm;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.mukesh_kumar.realm.Binders.StudioViewBiender;
import com.example.mukesh_kumar.realm.Utils.AppController;
import com.example.mukesh_kumar.realm.Utils.JsonToJavaObject;
import com.example.mukesh_kumar.realm.ViewModels.ClassDetailVM;
import com.example.mukesh_kumar.realm.ViewModels.StudioVM;
import com.example.mukesh_kumar.realm.ViewModels.TrainerDeatilVM;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.realm.Realm;
import io.realm.RealmList;

/**
 * Created by mukesh_kumar on 4/11/15.
 */
public class TrainerData {

    Realm realm;
    public  TrainerData (Realm realm){
        this.realm=realm;
    }

    public   void  getDataFromUrl(){

        String url ="http://192.168.0.105:8080/com.zealo.web/trainer/details";
        JSONObject params=new JSONObject();
        try {
            params.put("userId",1);
            params.put("trainerId",2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final JsonObjectRequest request= new JsonObjectRequest(url,params,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                     realm.beginTransaction();
                        TrainerDeatilVM trainerDeatilVM=realm.copyToRealm(getTrainerDeatilVM(response));
                        realm.commitTransaction();
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
    private TrainerDeatilVM getTrainerDeatilVM(JSONObject object){
        TrainerDeatilVM trainerDeatilVM=new TrainerDeatilVM();
        try {
            trainerDeatilVM.setId(object.getInt("trainerId"));
            String  firstName=object.getString("firstName");
            String lastName=object.getString("lastName");
            trainerDeatilVM.setName(firstName+" "+lastName);
            trainerDeatilVM.setProfile_Pic(object.getString("profilePicURL"));
            trainerDeatilVM.setAbout(object.getString("about"));

            RealmList<ClassDetailVM> classSummaryVMRealmList=new RealmList<>();
            JSONArray classSessionArray= object.getJSONArray("classSessionList");
            for (int j=0;j<classSessionArray.length();j++){
                JSONObject c=classSessionArray.getJSONObject(j);
                ClassDetailVM classDetailVM= JsonToJavaObject.getClassDetailVM(c);
                classSummaryVMRealmList.add(classDetailVM);
            }
            trainerDeatilVM.setList_of_Sessions(classSummaryVMRealmList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return trainerDeatilVM;
    }
}
