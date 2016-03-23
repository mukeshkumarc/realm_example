package com.example.mukesh_kumar.realm.Binders;

import com.example.mukesh_kumar.realm.ViewModels.StudioVM;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by mukesh_kumar on 22/10/15.
 */
public class StudioViewBiender {

    public  static  StudioVM getTrainerVMById(Realm realm,int id){
        RealmResults<StudioVM> studioVMs =realm.where(StudioVM.class).equalTo("Id",id).findAll();
        return studioVMs.get(0);
    }
}
