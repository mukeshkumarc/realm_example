package com.example.mukesh_kumar.realm.Activity;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.mukesh_kumar.realm.Binders.StudioViewBiender;
import com.example.mukesh_kumar.realm.StudioData;
import com.example.mukesh_kumar.realm.UserData;
import com.example.mukesh_kumar.realm.Utils.AppController;
import com.example.mukesh_kumar.realm.Binders.ClassSessionDetailsViewBInder;
import com.example.mukesh_kumar.realm.R;
import com.example.mukesh_kumar.realm.Utils.VolleyFunction;
import com.example.mukesh_kumar.realm.ViewModels.Amenity;
import com.example.mukesh_kumar.realm.ViewModels.ClassDetailVM;
import com.example.mukesh_kumar.realm.ViewModels.StudioVM;
import com.example.mukesh_kumar.realm.classSessionData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;


import io.realm.Realm;
import io.realm.RealmList;


public class MainActivity extends AppCompatActivity {
    Realm realm;
    /*public  Response.Listener slistener;
    public  Response.ErrorListener errorListener;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //realm.clear(ClassDetailVM.class);
        realm=Realm.getInstance(this);
        classSessionData sessionData=new classSessionData(realm);
        sessionData.getDataFromUrl();
        StudioData studioData=new StudioData(realm);
        studioData.getDataFromUrl();
        UserData userData=new UserData(realm,getApplicationContext());
        userData.getUserDetailByUrl();
    }
}
