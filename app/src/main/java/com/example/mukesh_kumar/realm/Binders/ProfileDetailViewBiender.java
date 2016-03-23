package com.example.mukesh_kumar.realm.Binders;

import com.example.mukesh_kumar.realm.ViewModels.ProfileVM;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by mukesh_kumar on 22/10/15.
 */
public class ProfileDetailViewBiender {

    public ProfileVM getUserProfileVMById(Realm realm,int id){
        RealmResults<ProfileVM> profileVMs=realm.where(ProfileVM.class).equalTo("Id",id).findAll();
        return profileVMs.get(0);
    }
}
